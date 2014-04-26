package test

object mergesort {
	def main(argc:Array[String]){
		val a:List[Int] = List(9,3,5,6,2,1,6,8,1)
		println(msort((x:Int,y:Int) => x < y)(a))
		
	}
	
	def msort[T](less:(T,T) => Boolean)(xs:List[T]):List[T] = {
		def merge(xs:List[T],ys:List[T]):List[T] = 
			(xs,ys) match{
			case (Nil,_) => ys
			case(_,Nil) => xs
			case(x::xs1,y::ys1) => 
				if(less(x,y)) x:: merge(xs1,ys)
				else y::merge(xs,ys1)
			
		}
		
		val n = xs.length/2
		if(n == 0) xs
		else{
			val (ys,zs) = xs splitAt n
			merge(msort(less)(ys),msort(less)(zs))
		}		
	}

}