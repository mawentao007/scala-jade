import scala.collection.mutable.MutableList 
object primeFactor {

	def main(args:Array[String]){
		var number:Long = 20000
	  val lst = findPrime(number)
    println(lst.sum)

		
	}
		
	
	def findPrime(num:Long):MutableList[Long] = {
    var t:MutableList[Long] = MutableList(2)
		var next:Long = 3 
    while(next <=  num){
      t += next
		  var ptag:Int = 1
			//ptag == 1 当前的不是prime
      while(ptag == 1){
			  ptag = 0
			  next += 2
			  for(i <- t;if(ptag == 0)){
				  if(next % i == 0)
					  ptag = 1	
			  }
		  }
    }
    t
  }
}
