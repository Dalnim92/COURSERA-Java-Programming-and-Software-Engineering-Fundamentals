
/**
 * Write a description of class MagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if(q1.getMagnitude() > q2.getMagnitude()){
            return 1;
        }
        else if(q1.getMagnitude() < q2.getMagnitude()){
            return -1;
        }
        else{
            if(q1.getDepth() > q2.getDepth()){
                return 1;
            }
            else if(q1.getDepth() < q2.getDepth()){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
