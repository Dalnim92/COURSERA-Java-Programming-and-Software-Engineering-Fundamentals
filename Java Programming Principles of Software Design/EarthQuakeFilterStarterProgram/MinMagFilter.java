
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (Ayten) 
 * @version (05/01/2025)
 */
public class MinMagFilter implements Filter{
    private double magMin; 
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 

}
