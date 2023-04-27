import java.security.*;
import java.io.*;
public class KeyGenerator {
    public static void main(String args[])throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair=keyPairGen.generateKeyPair();
        PublicKey publicKey=keyPair.getPublic();
        PrivateKey privateKey=keyPair.getPrivate();
        FileOutputStream fos=new FileOutputStream("keyPair");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(keyPair);
        oos.close();
    }
}
