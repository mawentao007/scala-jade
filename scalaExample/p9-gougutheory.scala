object Gougu{
  def main(args:Array[String]){
    var k = 0
    var mark = true
    for(i <- 1 to 500 if mark)
      for(j <- i to 500 if mark){
        k = 1000 - i - j
        var lt:List[Int] = List(i,j,k).sorted
        if(k < 500 && lt(2) < lt(1)+lt(0))
          if(lt(2)*lt(2) == lt(1) * lt(1)+lt(0)*lt(0)){
            mark = false
            println(lt(2),lt(1),lt(0))
            println(lt(2)*lt(2) + lt(1) * lt(1)+lt(0)*lt(0))
          }
        }
      }
    }
  



        
        

