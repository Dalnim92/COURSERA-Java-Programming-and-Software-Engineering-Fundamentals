import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (Ayten) 
 * @version (23/12/2024)
 */
public class WordLengths {
    public void countWordLengths(FileResource rc, int[] counts){
        for(String word : rc.words()){
            int wordLength = 0;
            for(int i =0; i <word.length(); i++){
                if(Character.isLetter(word.charAt(i))){
                    wordLength ++;
                }
            }
            if(wordLength >= counts.length){
                counts[counts.length - 1]++;
            }
            else if(wordLength >0){
                counts[wordLength] ++;
            }
        }
    }
    public void  testCountWordLengths(){
        FileResource rc = new FileResource();
        int[] counts = new int[31];
        countWordLengths(rc, counts);
        
        for(int i=0; i<counts.length; i++){
            if(counts[i] >0){
                if(i == counts.length -1){
                    System.out.println("Words of length 30 or more :" +counts[i]);
                }
                else{
                    System.out.println(counts[i] +" Words of length " +i );
                }
            }
        }
        
        
        System.out.println(indexOfMax(counts));
    }
    public int indexOfMax(int[] values){
        int max = 0;
        for(int i=0; i<values.length;i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
    }
}
