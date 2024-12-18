import edu.duke.*;
import java.io.File;

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("atg");
        if(startIndex == -1){return "";}
        int stopIndex = dna.indexOf("taa") + 3;
        if(stopIndex == -1){return "";};
        if((stopIndex - startIndex)%3 == 0){
            return dna.substring(startIndex,stopIndex);
        }
        else{
            return "";
        }
    }
    
    public void testSimpleGene(){
        String dna = "cccatggggtttaaataataataggagagagagagagagttt";
        System.out.println("DNA strand is = " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
    
        String ap = "atggggtttaaataataatag";
        System.out.println("DNA strand is = " + ap);
        gene = findSimpleGene(ap);
        System.out.println("Gene is = " + gene);
        
        String a = "atgcctag";
        System.out.println("DNA strand is = " + a);
        gene = findSimpleGene(a);
        System.out.println("Gene is = " + gene);
        
        String b = "";
        System.out.println("DNA strand is = " + b);
        gene = findSimpleGene(b);
        System.out.println("Gene is = " + gene);
        
        String c = "atgccctaa";
        System.out.println("DNA strand is = " + c);
        gene = findSimpleGene(c);
        System.out.println("Gene is = " + gene);
    }
}
