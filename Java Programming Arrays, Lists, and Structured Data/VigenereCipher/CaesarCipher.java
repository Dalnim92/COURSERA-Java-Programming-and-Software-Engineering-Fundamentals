import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (Ayten) 
 * @version (04/01/2025)
 */
public class CaesarCipher {
    private String Alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey = key;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = Alphabet.substring(key) + Alphabet.substring(0,key);
        Alphabet = Alphabet + Alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }
    
    private char transformLetter(char c, String from, String to){
        int idx = from.indexOf(c);
        if(idx != -1){
            return to.charAt(idx);
        }
        return c;
    }
    
    public char encryptLetter(char c){
        return transformLetter(c, Alphabet, shiftedAlphabet);
    }
    
    public char decryptLetter(char c){
        return transformLetter(c, shiftedAlphabet, Alphabet);
    }
    
    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
    
    public String encrypt(String input){
        return transform(input, Alphabet, shiftedAlphabet);
    }
    
    public String decrypt(String input){
        return transform(input, shiftedAlphabet, Alphabet);
    }
    
    public String toString(){
        return "" + mainKey;
    }
}
