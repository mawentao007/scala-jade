object Smallest{
  def main(args:Array[String]){
    var a:Long = 1
    for(i <- 2 to 20){
      a = a * i/gcd(i,a)
      println(a)
    }



  }

  def gcd(small:Long,big:Long):Long = {
    if( big % small == 0)
      small
    else
      gcd(big % small,small)
  }
}


    
