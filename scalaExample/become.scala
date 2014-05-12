package main.scala
import akka.actor._

case object ActNormalMessage
case object TryToFindSolution
case object BadGuysMakeMeAngry

class DavidBanner extends Actor{
  import context._

  def angryState:Receive = {
    case ActNormalMessage =>
      println("Phew,I'm back to being David")
      become(normalState)
    }

  def normalState:Receive = {
    case TryToFindSolution=>
      println("Looking for solution to my problem ...")
    case BadGuysMakeMeAngry=>
      println("I'm getting angry...")
      become(angryState)
    }

  def receive = {
    case BadGuysMakeMeAngry => become(angryState)
    case ActNormalMessage => become(normalState)
  }
}

object BecomeHulkExample {
  def main(args:Array[String]){
    val system = ActorSystem("BecomeHulkExample")
    val davidBanner = system.actorOf(Props[DavidBanner],name = "DavidBanner")
    davidBanner ! ActNormalMessage
    davidBanner ! TryToFindSolution
    davidBanner ! BadGuysMakeMeAngry
    Thread.sleep(1000)
    davidBanner ! ActNormalMessage
    system.shutdown
  }
}

