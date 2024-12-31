import java.util.*;
import edu.duke.*;
/**
 * Write a description of CodonCount here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class CodonCount {
    private HashMap<String,Integer> mapDNA;
    
    public CodonCount(){
        mapDNA = new HashMap<String,Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        mapDNA.clear();
        
        int count = 0;
        
        for(int i = start; i < dna.length()-2; i+=3){
            String codon = dna.substring(i,i+3);
            if(!mapDNA.containsKey(codon)){
                mapDNA.put(codon,1);
                count++;
            }
            else{
                mapDNA.put(codon, mapDNA.get(codon)+1);
            }
        }
        System.out.println("reading frame starting with " + start + ", result in " + count + " unique codons");
    }
    
    public String  getMostCommonCodon (){
        int max = 0;
        String result = "";
        for(String s : mapDNA.keySet()){
            if(mapDNA.get(s) > max){
                max = mapDNA.get(s);
                result = s;
            }
        }
        return "most common codon is : " + result.toUpperCase() + " with count " + max;
    }
    
    public void printCodonCounts(int start, int end){
        for(String s : mapDNA.keySet()){
            int key = mapDNA.get(s);
            if(key > start && key <= end){
                System.out.println(s.toUpperCase() + " \t" + mapDNA.get(s));
            }
        }
    }
    
    public void tester(){
        int start = 2;
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toUpperCase();
            buildCodonMap(start, s);
            System.out.println(getMostCommonCodon());
            //printCodonCounts(1,5);
        }
    }
}
