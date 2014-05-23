public class Thread4{
  class Inner{
    private  void m4t1(){
       int i = 5;
       while(i-- > 0){
          System.out.println(Thread.currentThread().getName()+" :Inner.m4t1()="+ i);
          try{
                 Thread.sleep(100);
          }catch(InterruptedException ie){
          }
       }
    }
     private void m4t2(){
          int i = 5;
          while(i-->0){
                  System.out.println(Thread.currentThread().getName() + ":Inner.m4t2()=" + i);
                  try{
                          Thread.sleep(100);
                  }catch(InterruptedException ie){
                  }
          }
      }
  }
  private void m4t1(Inner inner){
          synchronized(inner){
                  inner.m4t1();
          }

  }

  private void m4t2(Inner inner){
          inner.m4t2();
  }


  public static void main(String[] args){
     final Thread4 myt4 = new Thread4();
     final Inner inner = myt4.new Inner();
     Thread ta = new Thread(new Runnable(){public void run(){myt4.m4t1(inner);}},"ta");
     Thread tb = new Thread(new Runnable(){public void run(){myt4.m4t2(inner);}},"tb");
     ta.start();
     tb.start();
  }
}
