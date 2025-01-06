import java.util.*;
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (Ayten) 
 * @version (06/01/2025)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String q1last = q1.getInfo().substring(q1.getInfo().lastIndexOf(" ") +1 );
        String q2last = q2.getInfo().substring(q2.getInfo().lastIndexOf(" ") + 1);
        
        if(q1last.compareTo(q2last) > 0){
            return 1;
        }
        else if(q1last.compareTo(q2last) < 0){
            return -1;
        }
        else{
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
    }
}
