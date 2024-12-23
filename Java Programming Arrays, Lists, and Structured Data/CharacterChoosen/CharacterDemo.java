
/**
 * Write a description of CharacterDemo here.
 * 
 * @author (Ayten) 
 * @version (23/12/2024)
 */
public class CharacterDemo {
    public void digitTest(){
        String test = "ABCabc0123456789';#!";
        for(int k = 0; k < test.length(); k++){
            char ch = test.charAt(k);
            if(Character.isDigit(ch)){
                System.out.println(ch + " is digit.");
            }
            if(Character.isAlphabetic(ch)){
                System.out.println(ch + " is alphabetic.");
            }
            if(ch == '#'){
                System.out.println(ch + " is hashtag.");
            }
        }
    }
    public void conversionTest(){
        String test = "ABCabc0123456789';#!";
        for(int k=0; k<test.length(); k++){
            char ch = test.charAt(k);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            System.out.println(ch + " " +uch+" "+lch);
        }
    }
}
