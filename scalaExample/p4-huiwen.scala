object Huiwen{
  def main(args:Array[String]){
    var mark = 0
    var answer = 0
    var tanswer = 0
    for(i <- 1000 to 100 by -1 ){
      for(j <- 1000 to 100 by -1){
        tanswer = i * j
        println(answer)
        var st = tanswer.toString
        println(st)
        var ts = st.reverse
        println(ts)
        println("***********************")
        if(ts == st){
          if(tanswer > answer)
            answer = tanswer
      }
  }
}
  println(answer)
        
      
    
  }



}


