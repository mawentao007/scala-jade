import scala.io._
import java.net.ServerSocket
import java.io._

object MyServer {
  def main(args:Array[String]){
    try{
      val server = new ServerSocket(19999)
      println("Server initialized:")
      val client = server.accept

      val in = new BufferedReader(new InputStreamReader(client.getInputStream)).readLine
      val out = new PrintStream(client.getOutputStream)

      println("Server received:" + in)
      out.println("Message received")
      out.flush
      
      if(in.equals("Disconnect")){
        client.close;
        server.close;
        println("Server closing:")
      }
    }

    catch{
      case e:Exception => println(e.getStackTrace)
      System.exit(1)
    }
  }
  
}
