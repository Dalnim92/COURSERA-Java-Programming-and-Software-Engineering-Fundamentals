
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneWhile {
    public String findGene(String dna){
        char ch = (char)dna.charAt(0);
        dna = dna.toUpperCase();
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex+3);
        while(currIndex != -1){
            if((currIndex - startIndex)% 3 == 0){
                if(Character.isLowerCase(ch)){
                    String result = dna.substring(startIndex, currIndex +3);
                    return result.toLowerCase();
                }
                else{
                    return dna.substring(startIndex, currIndex +3);
                }
            }
            else{
                currIndex = dna.indexOf("TAA", currIndex+1);
            }
        }
        return "";
    }
    public void testFindGeneSimple(){
        
        String dna = "AATGCTAATTTAATCG";
        String result = findGene(dna);
        System.out.println("1 gene is :" + result);
        
        dna = "AATGCTAATTTAATCG";
        result = findGene(dna);
        System.out.println("2 gene is :" + result);
        
        dna = "atggggtttaaataataatag";
        result = findGene(dna);
        System.out.println("3 gene is :" + result);
        
        dna = "atgcctag";
        result = findGene(dna);
        System.out.println("4 gene is :" + result);
        
        dna = "atgccctaa";
        result = findGene(dna);
        System.out.println("5 gene is :" + result);
    }
}
