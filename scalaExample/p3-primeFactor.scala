import scala.collection.mutable.MutableList 
object primeFactor {
	val lst = MutableList(2,3) 
	findNextPrime(lst,20)
  println(lst)
	def main(args:Array[String]){
		var ans:Int = 2
		var number:Long = 600851475143L
		while(number >= ans){
			for(i <- lst){
				while(number % i == 0){
					number = number / i
					ans = i
				}
			}
			if(number > lst(lst.length -1))
				findNextPrime(lst,10)
		}
		require(number == 1)
		println(ans)
		
	}
		
	
	def findNextPrime(lst:MutableList[Int],num:Int){
		def findOne = {
			var next:Int = lst.apply(lst.length - 1) 
			var ptag:Int = 1
			//ptag == 1 当前的不是prime
			while(ptag == 1){
				ptag = 0
				next += 2
				for(i <- lst;if(ptag == 0)){
					if(next % i == 0)
						ptag = 1	
				}
			}
			lst += next
		}
		for(i <- 1 to num)
			findOne
	}

}
