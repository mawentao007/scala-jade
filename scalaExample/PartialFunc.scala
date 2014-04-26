package test
import scala.PartialFunction._

object PartialFunc {
	def main(argc:Array[String]){
		val sample = 1 to 10
		val evenNumbers = sample collect isEven
		val numbers = sample map (isEven orElse isOdd)
		println(numbers)
		println(evenNumbers)
	}
	val isEven  = {
		case x if x % 2 == 0 => x+" is even"
		}:PartialFunction[Int, String]
	val isOdd: PartialFunction[Int, String] = {
		case x if x % 2 == 1 => x+" is odd"
		}



}