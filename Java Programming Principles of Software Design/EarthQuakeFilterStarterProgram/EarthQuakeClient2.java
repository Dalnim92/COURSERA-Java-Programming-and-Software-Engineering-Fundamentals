import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        /*Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        }*/ 
        
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        Filter f1 = new MagnitudeFilter(3.5, 4.5);
        Filter f2 = new DepthFilter(-55000.0, -20000.0);
        
        ArrayList<QuakeEntry> list1 = eqc.filter(list, f1);
        ArrayList<QuakeEntry> list2 = eqc.filter(list1, f2);
        System.out.println(list2.size());
        
        /*for(QuakeEntry qe : list2){
           System.out.println(qe);
        }
        System.out.println(list2.size());*
        Location denver = new Location(39.7392, -104.99033);
        Filter f3 = new DistanceFilter(denver , 1000000.00);
        Filter f4 = new PhraseFilter("any", "a");
        
        ArrayList<QuakeEntry> list3 = eqc.filter(list, f3);
        ArrayList<QuakeEntry> list4 = eqc.filter(list3, f4);
        System.out.println(list4.size());
        
        ArrayList<QuakeEntry> list3 = eqc.filter(list, f3);
        int s = 0;
        for(QuakeEntry qe : list3){
            if(qe.getInfo().endsWith("Japan")){
                s++;
                System.out.println(qe);
            }
        }
        System.out.println(s);*/
    }
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("Total read " + list.size());
        
        /*for(QuakeEntry qe : list){
            System.out.println(qe);
        }System.out.println(list.size());*/
        
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1.0, 4.0));
        maf.addFilter(new DepthFilter(-180000.0 , -30000.0));
        maf.addFilter(new PhraseFilter("any", "o"));
        
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        
        ArrayList<QuakeEntry> list1 = eqc.filter(list, maf);
        for(QuakeEntry qe : list1){
            System.out.println(qe);
        }
        System.out.println(list1.size());
    }
    
    public void  testMatchAllFilter2 (){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("Total read " + list.size());
        
        /*for(QuakeEntry qe : list){
            System.out.println(qe);
        }System.out.println(list.size());*/
        
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0, 5.0));
        Location loc = new Location(55.7308, 9.1153);
        maf.addFilter(new DistanceFilter(loc, 3000000));
        maf.addFilter(new PhraseFilter("any", "e"));
        
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        
        ArrayList<QuakeEntry> list1 = eqc.filter(list, maf);
        for(QuakeEntry qe : list1){
            System.out.println(qe);
        }
        System.out.println(list1.size());
        System.out.println("Filter used: " + maf.getName());
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
