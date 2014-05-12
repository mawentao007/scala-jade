package main.scala
import akka.actor._
import scala.concurrent.Await
import scala.concurrent.Future
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

case object AskNameMessage

class TestActor extends Actor{
  def receive = {
      case AskNameMessage => sender ! "Fred"
      case _              =>  println("that was unexpected")
    }
  }

object AskTest {
  def main(args:Array[String]){
    val system = ActorSystem("askTestSystem")
    val myActor = system.actorOf(Props[TestActor],name = "myActor")

    implicit val timeout = Timeout(1 seconds)
    val future = myActor ? AskNameMessage
    val result = Await.result(future,timeout.duration).asInstanceOf[String]
    println(result)

    val future2:Future[String] = ask(myActor,AskNameMessage).mapTo[String]
    val result2 = Await.result(future2,3 second)
    println(result2)

    system.shutdown
  }
}
