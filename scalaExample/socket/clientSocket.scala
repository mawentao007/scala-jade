import java.net._
import java.io._
import scala.io._
import swing._
import Swing._

object MyClient extends MainFrame with App {
    title = "Simple Client"
    preferredSize = (500,500)

    val socket = new Socket(InetAddress.getByName("localhost"),19999)
    val in = new BufferedSource(socket.getInputStream).getLines
    val out = new PrintStream(socket.getOutputStream)
    println("Client initialized:")

    contents = new BorderPanel
    {
      add(new FlowPanel
        {
          contents += new Button(new Action("Send"){
              def apply
              {
                out.println("Hello!")
                out.flush
                println("Client received:" + in.next)
              }
            })

          contents += new Button(new Action("Close")
            {
              def apply
              {
                out.println("Disconnect")
                out.flush
                socket.close
              }
            })
        },BorderPanel.Position.Center)
    }

    pack
    visible = true
}


