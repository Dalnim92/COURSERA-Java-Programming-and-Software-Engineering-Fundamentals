import edu.duke.*;
import java.util.*;
/**
 * Write a description of test here.
 * 
 * @author (Ayten) 
 * @version (04/01/2025)
 */
public class test {    
    public void testCaesarCipher(){
        CaesarCipher cc = new CaesarCipher(4);
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc.encrypt(message);
        String decrypted = cc.decrypt(message);
        
        System.out.println(message);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
    
    public void testCaesarCracker(){
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource();
        String message = fr.asString();
        String decrypted = cc.decrypt(message);
        
        System.out.println(message);
        System.out.println(decrypted);
    }
    
    public void testCaesarCracker2(){
        CaesarCracker cc = new CaesarCracker('e');
        FileResource fr = new FileResource();
        String message = fr.asString();
        String decrypted = cc.decrypt(message);
        
        System.out.println(message);
        System.out.println(decrypted);
    }
    
    public void testVigenereCipher(){
        int[] key = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = vc.encrypt(message);
        String decrypted = vc.decrypt(message);
        
        System.out.println(message);
        System.out.println(encrypted);
        
    }
}
