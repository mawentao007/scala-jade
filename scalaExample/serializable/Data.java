import java.io.Serializable;

public class Data implements Serializable{
        private static final long serialVersionUID = 3452354235345L;
        public int n;
        public Data(int n){
                this.n = n;
        }
        public String toString(){
                return Integer.toString(n);
        }
}
