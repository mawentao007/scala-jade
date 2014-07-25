object Nthprime  {
  def main(args:Array[String]){
    var n = 2
    var k:Long = 3
    while(n != 10001){
      k += 2
      if(prime(k))
        n=n+1

      println(n)
    }
    println(k)

  }

  def prime(a:Long):Boolean ={
    var judge:Boolean = true
    var i:Long = 2
    
    while(judge && i <= a/2){
      if(a%i == 0)
        judge = false
      else{
        judge = true
        i+=1
      }
    }
    judge
  }

}

