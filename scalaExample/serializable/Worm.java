import java.io.Serializable;
import java.util.Random;

public class Worm implements Serializable{
        private static final long serialVersionUID = 345345346363L;
        private Data[] d = {
                new Data(random.nextInt(10)),
                new Data(random.nextInt(10)),
                new Data(random.nextInt(10))
        };
        private static Random random = new Random(47);
        private Worm next;
        private char c;

        public Worm(int i,char x){
                System.out.println("Worm constructor:" + i);
                c = x;
                if(--i > 0){
                        next = new Worm(i,(char)(x+1));
                }
        }

        public Worm(){
                System.out.println("Default constructor!");
        }

        public String toString(){
                StringBuilder sb = new StringBuilder(":");
                sb.append(c);
                sb.append("(");
                for(Data data : d){
                        sb.append(data);
                }

                sb.append(")");
                if(next != null){
                        sb.append(next);
                }
                return sb.toString();
        }
}
