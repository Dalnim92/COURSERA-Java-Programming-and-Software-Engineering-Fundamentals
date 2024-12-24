import java.util.*;
import edu.duke.*;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (Ayten) 
 * @version (24/12/2024)
 */
public class CharactersInPlay {
    private ArrayList<String> name;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay(){
        name = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index = name.indexOf(person);
        if(index == -1){
            name.add(person);
            counts.add(1);
        }
        else{
            int value = counts.get(index);
            counts.set(index,value+1);
        }
    }
    
    public void findAllCharacters(){
        name.clear();
        counts.clear();
        
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            if(s.contains(".")){
                int idx = s.indexOf(".");
                String poss_name = s.substring(0,idx);
                update(poss_name);
            }
        }
        
    }
    public void tester() {
        findAllCharacters();
        
        for (int k =0; k < counts.size();k++) {
           
            if (counts.get(k) > 0) {
            
             System.out.println("The main character is: "+ name.get(k) +"\t"
             +"The number of speaking parts is: "+ counts.get(k));
             
            }
            
        }
            
        int num1 = 2;
        int num2 = 3;
        //charactersWithNumParts(num1, num2);
    
    }
    
     public void charactersWithNumParts(int num1, int num2) {
        
        for (int k =0; k < counts.size();k++) {
           
            if (counts.get(k) >= num1 && counts.get(k)<= num2) {
            
                System.out.println("The main character between : " + num1 + " and " + num2 
                + " is " + name.get(k) +"\t"
                +"The number of speaking parts is: "+ counts.get(k));
             
            }
            
        }
    
    }
}
