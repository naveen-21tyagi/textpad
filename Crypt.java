import java.io.*;
import java.security.*;
import javax.crypto.Cipher;

public class Crypt {
   Cipher cipher;
   KeyPair keyPair;

   Crypt() throws Exception{
      //Creating a Cipher object
      cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      FileInputStream fis=new FileInputStream("keyPair");
      ObjectInputStream ois=new ObjectInputStream(fis);
      keyPair=(KeyPair)ois.readObject();
      ois.close();
   }
   
   byte[] encrypt(String text)throws Exception{
      cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
	  
      //Add data to the cipher
      byte[] input = text.getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();	 
      // return (new String(cipherText, "UTF8"));
      return cipherText;
   }
   
   String decrypt(byte[] text)throws Exception{
      cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
      
      //Decrypting the text
      byte[] decipheredText = cipher.doFinal(text);
      return (new String(decipheredText));
   }
}