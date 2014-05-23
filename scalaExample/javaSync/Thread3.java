public class Thread3{
  public void m4t1(){
    synchronized(this){
       int i = 5;
       while(i-- > 0){
          System.out.println(Thread.currentThread().getName()+" synchronized loop" + i);
          try{
                 Thread.sleep(100);
          }catch(InterruptedException ie){
          }
       }
    }
  }

  public void m4t2(){
      synchronized(this){
          int i = 5;
          while(i-->0){
                  System.out.println(Thread.currentThread().getName() + ":" + i);
                  try{
                          Thread.sleep(100);
                  }catch(InterruptedException ie){
                  }
          }
      }
  }


  public static void main(String[] args){
     final Thread3 t1 = new Thread3();
     Thread ta = new Thread(new Runnable(){public void run(){t1.m4t1();}},"ta");
     Thread tb = new Thread(new Runnable(){public void run(){t1.m4t2();}},"tb");
     ta.start();
     tb.start();
  }
}
