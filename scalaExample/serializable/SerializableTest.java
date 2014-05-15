import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest{
        public static void main(String[] args) throws FileNotFoundException,IOException,ClassNotFoundException{
                Worm w = new Worm(6,'a');
                System.out.println("序列化操作之前");
                System.out.println("w="+w);

                ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("worm.out"));
                oos1.writeObject("Worm storage By FileOutputStream");
                oos1.writeObject(w);
                oos1.close();

                ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("worm.out"));
                String s1 = (String)ois1.readObject();
                Worm w1 = (Worm)ois1.readObject();
                ois1.close();
                System.out.println("反序列化操作1之后");
                System.out.println(s1);
                System.out.println("w1:" + w1);

                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream oos2 = new ObjectOutputStream(byteOutStream);
                oos2.writeObject("worm by byteoutputstream");
                oos2.writeObject(w);
                oos2.flush();

                ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
                ObjectInputStream ois2 = new ObjectInputStream(byteInStream);
                String s2 = (String)ois2.readObject();
                Worm w2 = (Worm)ois2.readObject();
                ois2.close();
                System.out.println("反序列化操作2之后");
                System.out.println(s2);
                System.out.println("w2:"+w2);
        }
}
