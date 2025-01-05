import edu.duke.*;
import java.util.*;
import java.io.File;
/**
 * Write a description of VigenereBreake here.
 * 
 * @author (Ayten) 
 * @version (04/01/2025)
 */
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices){
        StringBuilder sb = new StringBuilder();
        for(int i=whichSlice; i<message.length(); i+=totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon){
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i=0; i<klength; i++){
            String s = sliceString(encrypted, i, klength);
            key[i]= cc.getKey(s);
        }
        return key;
    }
    
    public void breakVigenere(){
        String[] languages = {"Danish", "Dutch", "English", "French", "German", "Italian", "Portuguese", "Spanish"};
        HashMap<String, HashSet<String>> dictionaries= new HashMap<String, HashSet<String>>();
         for(int i = 0; i < languages.length; i++) {
            FileResource fr = new FileResource("dictionaries/"+languages[i]);
            if(!dictionaries.containsKey(languages[i])) {
                dictionaries.put(languages[i], readDictionary(fr));
                System.out.println("Done reading " + languages[i] + " dictionary");
            }
        }
        FileResource fr = new FileResource(); //select file to decrypt
        String message = fr.asString();
        breakForAllLanguages(message, dictionaries);
         /*System.out.println(message);*/
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> hs = new HashSet<String>();
        
        for(String s : fr.lines()){
            hs.add(s.toLowerCase());
        }
        return hs;
    }
    
    public int countWords(String msg, HashSet<String> dictionary){
        String[] sa = msg.split("\\W+");
        int i = 0;
        for(String s: sa){
            String slower = s.toLowerCase();
            if(dictionary.contains(slower)){
                i++;
            }
        }
        return i;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int max =0;
        char c = mostCommonCharIn(dictionary);
        for(int i=1; i <101; i++){
            int[] key = tryKeyLength(encrypted, i,c);
            VigenereCipher vc = new VigenereCipher(key);
            String s = vc.decrypt(encrypted);
            int a = countWords(s, dictionary);
            if(a > max){
                max =a;
            }
        }
        
        for(int j=1; j<=101; j++){
            int[] key = tryKeyLength(encrypted, j,c);
            VigenereCipher vc = new VigenereCipher(key);
            String s = vc.decrypt(encrypted);
            int a = countWords(s, dictionary);
            if(a == max){
                return s;
            }
        }
        return null;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(String s: dictionary){
            String slower = s.toLowerCase();
            for(char c: slower.toCharArray()){
                if(hm.containsKey(c)){
                    hm.put(c, hm.get(c)+1);
                }
                else{
                    hm.put(c,1);
                }
            }
        }
        int max = 0;
        for(char c: hm.keySet()){
            if(hm.get(c) >max){
                max = hm.get(c);
            }
        }
        for(char c: hm.keySet()){
            if(hm.get(c) == max){
                return c;
            }
        }
        
        return 'n';
    }
    
    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
        int maxWords =0;
        String decryptedMessage = "";
        HashMap<String, Integer> langsMostWords = new HashMap<String, Integer>();
        for(String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            decryptedMessage = breakForLanguage(encrypted, dictionary);
            int count = countWords(decryptedMessage, dictionary);
            langsMostWords.put(language, count);
        }
        for(String lang : langsMostWords.keySet()) {
            if(langsMostWords.get(lang) > maxWords) {
                maxWords = langsMostWords.get(lang);
                System.out.println(decryptedMessage);
                System.out.println("Language: " + lang + " with " + maxWords + " # of words\n");
            }
        }
    }
}
