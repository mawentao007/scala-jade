package main.scala
import akka.actor.Actor
import akka.event.Logging
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Terminated

object Main{
    def main(argc:Array[String]){
    val system = ActorSystem("HelloSystem")
    val helloActor = system.actorOf(Props(classOf[HelloActor],"Fred"),name = "helloactor")
    helloActor ! "hello"
    helloActor ! "buenos dias"
//    val watchActor = system.actorOf(Props(classOf[WatchActor],"jane"),name = "watchactor")
//    watchActor ! "kill"
  }
}

class HelloActor(myName:String) extends Actor{
  val log = Logging(context.system,this)
  def receive={
    case "hello" => log.info("receive hello")
    case _       => log.info("unknown")
  }
}

/*class WatchActor extends Actor{
  val child = context.actorOf(Props.empty,"child")
  context.watch(child)
  var lastSender = context.system.deadLetters

  def receive = {
    case "kill" =>
      context.stop(child);lastSender = sender()
    case Terminated(`child`)=>lastSender !"finished"
  }
}

*/


