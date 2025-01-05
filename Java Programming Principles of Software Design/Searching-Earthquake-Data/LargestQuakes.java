import java.util.*;
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (Ayten) 
 * @version (05/01/2025)
 */
public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser =new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+ list.size());
        /*for(QuakeEntry qe: list){
           System.out.println(qe); 
        }
        */
        ArrayList<QuakeEntry> ans = getLargest(list, 5);
        for(QuakeEntry qe : ans){
            System.out.println(qe);
        }
    }
    
    public int indexOfLarges(ArrayList<QuakeEntry> data){
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(data);
        double  max = 0.0;
        int ans = 0;
        for(int k =0; k< copy.size(); k++){
            QuakeEntry entry = copy.get(k);
            double mag = entry.getMagnitude();
            if(mag > max){
                ans = k;
                max = mag;
            }
        }
        return ans;
    }
    
    public ArrayList<QuakeEntry>  getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(int i =0; i <howMany; i++){
            double  max = 0.0;
            int ans =0;
            for(int j =0; j< copy.size(); j++){
                QuakeEntry entry = copy.get(j);
                double mag = entry.getMagnitude();
                if(mag > max){
                    max = mag;
                    ans =j;
                }
            }
            answer.add(copy.get(ans));
            copy.remove(ans);
        }
        return answer;
    }
}
