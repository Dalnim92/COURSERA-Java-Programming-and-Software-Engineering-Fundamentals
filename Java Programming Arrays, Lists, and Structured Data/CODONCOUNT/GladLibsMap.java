import edu.duke.*;
import java.util.*;
/**
 * Write a description of GladLibsMap here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class GladLibsMap {
    private HashMap<String , ArrayList<String>> wordsMap;
    
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    private ArrayList<String> alreadyList;
    private int countReplaced;
    
    public GladLibsMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        wordsMap = new HashMap<String, ArrayList<String>>();
    }
    
    public GladLibsMap(String source){
        initializeFromSource(source);
        myRandom = new Random(0);
    }
    
    public void initializeFromSource(String source){
        String[] labels = {"country", "noun", "animal",
                           "adjective", "name", "color",
                           "timeframe", "verb", "fruit"};
        for(String s : labels){
            ArrayList<String> list = readIt(source + "/" + s + ".txt");
            wordsMap.put(s,list);
        }
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        
        if(first == -1 || last == -1){
            return w;
        }
        
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1, last));
        int indexcounts = 0;
        
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if(source.startsWith("http")){
            URLResource rc = new URLResource(source);
            for(String line : rc.lines()){
                list.add(line);
            }
        }
        else{
            FileResource rc = new FileResource(source);
            for(String line : rc.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private String getSubstitute(String label){
        if(label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(wordsMap.get(label));
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    public int  totalWordsInMap (){
        int size= 0;
        for(ArrayList list : wordsMap.values()){
            size = size+ list.size();
        }
        return size;
    }
    
    public int totalWordsConsidered(){
        int total = 0;
        for(String s : wordsMap.keySet()){
            total = total + wordsMap.get(s).size();
        }
        return total;
    }
    
    public void makeStory(){
        alreadyList.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate3.txt");
        printOut(story, 60);
        System.out.println("\n");
        System.out.println("Total words replaced = " + countReplaced);
        totalWordsInMap();
        System.out.println("Number of words in all the Arraylists in the HashMap = " + totalWordsInMap());
    }
}
