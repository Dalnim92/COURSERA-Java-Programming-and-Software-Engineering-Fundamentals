import edu.duke.*;
/**
 * Write a description of WordPlay here.
 * 
 * @author (Ayten) 
 * @version (23/12/2024)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        String vowel = "aeiouAEIOU";
        if(vowel.indexOf(ch) != -1){
            return true;
        }
        else{
            return false;
        }
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder replaced = new StringBuilder(phrase);
        
        for(int i=0; i<replaced.length(); i++){
            if(isVowel(replaced.charAt(i))){
                replaced.setCharAt(i, ch);
            }
        }
        return replaced.toString();
    }
    public String emphasize(String phrase, char ch){
        StringBuilder emp = new StringBuilder(phrase);
        
        for(int i = 0; i<emp.length(); i++){
            if(Character.toLowerCase(emp.charAt(i)) == ch){
                if(i%2 == 0){
                    emp.setCharAt(i, '*');
                }
                else{
                    emp.setCharAt(i, '+');
                }
            }
        }
        return emp.toString();
    }
    public void test(){
        /*String word = "Hello World";
        char ch = '*';
        System.out.println(replaceVowels(word, ch));*/
        
        String word = "Mary Bella Abracadabra";
        char ch = 'a';
        System.out.println(emphasize(word, ch));
    }
}
