import jd._
import com.mongodb.casbah.Imports._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  val mongoClient = MongoClient()
  override def init(context: ServletContext) {

    val mongoColl = mongoClient("casbah_test")("test_data")
   // context.mount(new MyScalatraServlet, "/*")
    context.mount(new MyScalatraServlet(mongoColl),"/*")
  }

  override def destroy(context:ServletContext){
      mongoClient.close
  }
}
