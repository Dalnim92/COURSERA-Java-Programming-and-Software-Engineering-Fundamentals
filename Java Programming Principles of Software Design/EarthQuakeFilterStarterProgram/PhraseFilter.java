
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (Ayten) 
 * @version (05/01/2025)
 */
public class PhraseFilter implements Filter {
    private String type;
    private String phrase;
    
    public  PhraseFilter(String s1, String s2){
        type = s1;
        phrase = s2;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(type.equals("start") && qe.getInfo().startsWith(phrase)){
            return true;
        }
        if(type.equals("end") && qe.getInfo().endsWith(phrase)){
            return true;
        }
        if(type.equals("any") && qe.getInfo().contains(phrase)){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return "Phrase Filter";
    }
}
