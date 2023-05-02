import java.security.*;
import java.io.*;
public class KeyGenerator {
    public static void main(String args[])throws Exception {
        KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair=keyPairGen.generateKeyPair();
        FileOutputStream fos=new FileOutputStream("keyPair");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(keyPair);
        oos.close();
    }
}
