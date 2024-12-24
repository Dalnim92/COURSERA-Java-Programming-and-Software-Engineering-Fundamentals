import edu.duke.*;
/**
 * Write a description of CeaserChipper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnknownkeyCeaser{
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        
        for(int i =0; i<encrypted.length(); i++){
            
            char currChar = encrypted.charAt(i);
            
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if(isUpper(currChar)){
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shifted2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
        for(int i =0; i<encrypted.length(); i++){
            
            char currChar = encrypted.charAt(i);
            
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1){
                if(i % 2 == 0){
                    char newChar = shifted1.charAt(idx);
                    if(isUpper(currChar)){
                    encrypted.setCharAt(i, newChar);
                    }
                     else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                }
                else{
                    char newChar = shifted2.charAt(idx);
                    if(isUpper(currChar)){
                    encrypted.setCharAt(i, newChar);
                    }
                     else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                }
            }
        }
        return encrypted.toString();
    }
    public boolean isUpper(char ch){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(alphabet.indexOf(ch) != -1){
            return true;
        }
        else{
            return false;
        }
    }
    public void testencrypt(){
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 26-key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, key);
        System.out.println(decrypted);
    }
    public void testencrypttwo(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        for(int key1 = 1; key1 < 26; key1++){
            for(int key2 = 1; key2 < 16; key2++){
                String encrypted = encryptTwoKeys(message, 26-key1, 26-key2);
                System.out.println(encrypted);
            }
        }
    }
}
