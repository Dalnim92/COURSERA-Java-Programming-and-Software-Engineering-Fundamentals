
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (Ayten) 
 * @version (05/01/2025)
 */
public class MagnitudeFilter implements Filter {
    private double min;
    private double max;
    
    public MagnitudeFilter(double min1, double max1){
        min = min1;
        max = max1;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(qe.getMagnitude() >= min && qe.getMagnitude() <= max){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return "Magnitude";
    }
}
