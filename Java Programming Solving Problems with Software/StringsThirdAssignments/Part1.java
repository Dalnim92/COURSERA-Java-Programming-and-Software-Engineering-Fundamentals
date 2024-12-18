import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part1 here.
 * 
 * @author (Ayten) 
 * @version (18/12/2024)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    public void testFindStopCodon(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if(dex != 9)System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if(dex != 21)System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if(dex != 26)System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");System.out.println("error on TAG");
        System.out.println("Tests finished");
    }
    public String findGene(String dna, int where){
        int atgIndex = dna.indexOf("ATG", where);
        if(atgIndex == -1){return "No ATG found.";}
        
        int taaIndex = findStopCodon(dna, atgIndex, "TAA");
        if(taaIndex == -1){return "";}
        
        int tagIndex = findStopCodon(dna, atgIndex, "TAG");
        if(tagIndex == -1){return "";}
        
        int tgaIndex = findStopCodon(dna, atgIndex, "TGA");
        if(tgaIndex == -1){return "";}
        
        int minIndex = 0;
        
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else{
            minIndex = taaIndex;
        }
        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if(minIndex == -1){
            return "No valid gene";
        }
        
        return dna.substring(atgIndex, minIndex+3);
    }
    /*public void testFindGene(){
        String dna = "TAGGTCCAGGACCATTGCTGAGATTAG";
        System.out.println("The dna is" + dna);
        String gene = findGene(dna);
        System.out.println("the gene is :" + gene);
        
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("The dna is" + dna);
        gene = findGene(dna);
        System.out.println("the gene is :" + gene);
        
        dna = "";
        System.out.println("The dna is" + dna);
        gene = findGene(dna);
        System.out.println("the gene is :" + gene);
        
        dna = "AATGTAGCGTACATGACCTGCTATGCACGGACAGTATGCAGTAA";
        System.out.println("The dna is" + dna);
        gene = findGene(dna);
        System.out.println("the gene is :" + gene);
        
    }*/
    public StorageResource getAllGenes(String dna){
        StorageResource rc = new StorageResource();
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            }
            rc.add(currGene);
            
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return rc;
    }
    public void testgetAllGene(){
        String dna = "TAGGTCCAGGACCATTGCTGAGATTAG";
        System.out.println("Testing all gene on" + dna);
        StorageResource genes =getAllGenes(dna);
        for(String gene: genes.data()){
            System.out.println("This is the list of genes: " + gene);
            
        }
    }
    public void printAllGene(String dna){
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            }
            System.out.println(currGene);
            
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }
}
