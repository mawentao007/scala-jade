import scala.collection.JavaConversions._

object EnvironmentVariables {
  def main(args:Array[String]){
    val environmentVars = System.getenv()
    for ( (k,v) <-environmentVars) 
      println("key: "+k, "value: "+v)
    val properties = System.getProperties()
    for ((k,v)<-properties) 
      println("key: "+k, "value: "+v)
    }
}
