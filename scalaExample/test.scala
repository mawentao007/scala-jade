package test
import scala.collection.mutable.ArrayBuffer

abstract class IntQueue{
	def get():Int
	def put(x:Int)
}

class BasicIntQueue extends IntQueue{
	private val buf = new ArrayBuffer[Int]
	def get() = buf.remove(0)
	def put(x:Int){
		println(x)
		buf += x
		}
}

trait first extends BasicIntQueue {
	abstract override def put(x:Int){
		super.put(x + 1)
		}
}

trait second extends BasicIntQueue{
	abstract override def put(x:Int){
		if(x >= 0)
			super.put(x + 2)
	}
}
	
class fn extends first with second{}
	

object test{
	def main(argc:Array[String]){
		val ans = new fn
		ans.put(-1)
//		ans.put(0)
//		ans.put(-1)
//		println(ans.get())
//		println(ans.get())	
		println(ans.get())	
	
	}
	
}