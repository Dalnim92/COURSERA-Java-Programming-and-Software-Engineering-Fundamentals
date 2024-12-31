import edu.duke.*;
import java.util.*;
import java.io.File;

/**
 * Write a description of WordsInFiles here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class WordsInFiles {
    private HashMap<String, ArrayList> wordsMap;
    
    public WordsInFiles(){
        wordsMap = new HashMap<String, ArrayList>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String word : fr.words()){
            if(!wordsMap.containsKey(word)){
                ArrayList<String> sourceF = new ArrayList<String>();
                sourceF.add(f.getName());
                wordsMap.put(word, sourceF);
            }
            else{
                ArrayList<String> sourceF = new ArrayList<String>();
                sourceF = wordsMap.get(word);
                if(!sourceF.contains(f.getName())){
                    sourceF.add(f.getName());
                }
            }
        }
    }
    
    public void buildWordFileMap(){
        wordsMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){
        int max = 0;
        for(ArrayList list : wordsMap.values()){
            if(list.size() > max){
                max = list.size();
            }
        }
        return max;
    }
    
    public ArrayList wordsInNumFiles(int number){
        ArrayList list = new ArrayList<String>();
        int count =0;
        for(String word : wordsMap.keySet()){
            int counts = wordsMap.get(word).size();
            if(counts == number){
                list.add(word);
                count++;
            }
        }
        System.out.println("total of words repeated" + number + "times: " + count);
        return list;
    }
    
    public void printFilesIn(String word){
        for(String s : wordsMap.keySet()){
            if(s.equals(word)){
                //System.out.println(s);
                ArrayList wordAndFiles = wordsMap.get(s);
                for (int i=0; i< wordAndFiles.size(); i++){
                    System.out.println(wordAndFiles.get(i));
                }
            }
        }
    }
    
    public void tester(){
        buildWordFileMap();
        ArrayList words = wordsInNumFiles(4);
        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
        System.out.println("\n Maximum number of words in all the files given =" + maxNumber());
        printFilesIn("\n");
        System.out.println("\n");
        for(String s : wordsMap.keySet()){
            System.out.println(s + wordsMap.get(s));
        }
    }
}
