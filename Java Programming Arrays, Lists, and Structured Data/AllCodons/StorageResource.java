import edu.duke.*;
/**
 * 
 * @author (Ayten) 
 * @version (18/12/2024)
 */
public class StorageResource {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff %3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }
    public StorageResource getAllGenes(String dna){
        StorageResource genelist = new StorageResource();
        int startIndex = 0;
        
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            
            genelist.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex + currentGene.length());
        }
    }
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        StorageResource genes = getAllGeens(dna);
        for(String g: genes.data()){
            System.out.println(g);
        }
    }
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }else{
            minIndex = taaIndex;
        }
        
        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    public void testFindStop(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if(dex != 9)System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if(dex != 21)System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if(dex != 26)System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if(dex != 26)System.out.println("error on TAG");
        System.out.println("Tests finished");
    }
}
