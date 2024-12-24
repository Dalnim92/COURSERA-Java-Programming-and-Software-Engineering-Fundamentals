import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFreq here.
 * 
 * @author (Ayten) 
 * @version (24/12/2024)
 */
public class WordFreq {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFreq(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println("# uniquewords: " + myWords.size());
        for(int i = 0; i < myWords.size() ; i++){
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        
        int index= findIndexOfMax();
        System.out.println("The word that occurs most and ots counts are : " + myWords.get(index) + "\t" + myFreqs.get(index));
    }
    
    public int findIndexOfMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        
        for(int i = 1; i < myFreqs.size();i++){
            if(myFreqs.get(i) > max){
                max = myFreqs.get(i);
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}
