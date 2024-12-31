import edu.duke.*;
import java.util.*;
/**
 * Write a description of WordFrequenciesMap here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class WordFrequenciesMap {
    public void countWords(){
        FileResource fr = new FileResource();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int total = 0;
        for(String w : fr.words()){
            w = w.toLowerCase();
            if(map.keySet().contains(w)){
                map.put(w, map.get(w) + 1);
            }
            else{
                map.put(w,1);
            }
        }
        for(String w : map.keySet()){
            int occur = map.get(w);
            if(occur > 0){
                System.out.println(occur + " times " + w);
            }
        }
    }
    
    
}
