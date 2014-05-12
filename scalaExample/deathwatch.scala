package main.scala
import akka.actor._

class Kenny extends Actor{
  def receive = {
    case _=> println("Kenny received a message")
  }
}

class Parent extends Actor{
  val kenny = context.actorOf(Props[Kenny],name = "Kenny")
  context.watch(kenny)

  def receive = {
    case Terminated(kenny) => println("OMG,they killed kenny")
    case _ => println("Parent received a message")
  }
}

object DeathWatchTest{
  def main(args:Array[String]){
    val system = ActorSystem("DeathWatchTest")
    val parent = system.actorOf(Props[Parent],name = "Parent")

    val kenny = system.actorSelection("/user/Parent/Kenny")
    kenny ! PoisonPill

    Thread.sleep(5000)
    println("calling system.shutdown")
    system.shutdown
  }
}
