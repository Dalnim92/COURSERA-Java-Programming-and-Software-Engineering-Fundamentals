import edu.duke.*;
import java.io.File;

/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (Ayten) 
 * @version (15/12/2024)
 */
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1)//noATG
        {
            return "NO ATG";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if(stopIndex == -1){
            return "NO TAA";
        }
        result = dna.substring(startIndex,stopIndex+3);
        
        return result;
    }
    public void testFindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        dna = "CGATGGTTTG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }
}
