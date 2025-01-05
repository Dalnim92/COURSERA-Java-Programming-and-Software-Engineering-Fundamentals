
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (Ayten) 
 * @version (05/01/2025)
 */
public class DistanceFilter implements Filter {
    private Location Loc;
    private double distance;
    
    public DistanceFilter(Location where, double dist){
        Loc = where;
        distance = dist;
    }
    
    public boolean  satisfies(QuakeEntry qe){
        if(qe.getLocation().distanceTo(Loc) < distance){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return "Distance Filter";
    }
}
