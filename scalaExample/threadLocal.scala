import java.lang.ThreadLocal

class Test(val a:String){
  def this() = {
    this("")
  }
}

object Test{
  val eg = new ThreadLocal[Test] 
  def set(t:Test){
    eg.set(t)
  }

  def get:Test = {
    eg.get()
  }
}

object Main{
  def main(args:Array[String]){
    val t = new Test("second")
    val te = Test
    println(te.get)
    te.set(t)
    println(te.get.toString)
    
  }
}

Main.main(null)
