import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of BabyBirths here.
 * 
 * @author (Ayten) 
 * @version (21/12/2024)
 */
public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
        }
    }
    
    public void totalBirths(CSVParser parser){
        int totalUniqueNames = 0;
        int totalUniqueBoys = 0;
        int totalUniqueGirls = 0;
        int totalBirths = 0;
        int totalBoys = 0;
	int totalGirls = 0;
	for (CSVRecord rec : parser ){
		int numBorn = Integer.parseInt(rec.get(2));
		totalBirths += numBorn;
		if (rec.get(1).equals("M")) {
			totalBoys += numBorn;
			totalUniqueBoys += 1;
		}
		else {
			totalGirls += numBorn;
			totalUniqueGirls += 1;
		}
	}
	totalUniqueNames = totalUniqueBoys + totalUniqueGirls;
	System.out.println("total births = " + totalBirths);
	System.out.println("total girls = " + totalGirls);
	System.out.println("total boys = " + totalBoys);
        System.out.println("unique boys Names = " + totalUniqueBoys);
	System.out.println("unique girls Names = " + totalUniqueGirls);
	System.out.println("unique total Names = " + totalUniqueNames);
    }
    
    public void testtotalBirths(){
        FileResource fr = new FileResource();
	totalBirths(fr.getCSVParser(false));
    }
    
    public int getRank(int year, String name, String gender){
        String fileName = "yob" + year + ".csv";
        FileResource fr = new FileResource("testing/"+fileName);
        int rank = 0;
        boolean found = false;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name)){
                    rank += 1;
                    found = true;
                    break;
                }
                else{
                    rank += 1;
                }
            }
        }
        if(found == true){
            return rank;
        }
        else{
            return -1;
        }
    }
    public void testGetRank(){
        int rank = getRank(1971,"Frank","M");
        System.out.println("Rank =" + rank);
    }
    
    public String getName(int year, int rank, String gender){
        String fileName = "yob" + year + ".csv";
        FileResource fr = new FileResource("testing/us_babynames_by_year/"+fileName);
        int r = 0;
        String name = null;
        boolean found = false;
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                r += 1;
                if(r == rank){
                    name = rec.get(0);
                    found = true;
                    break;
                }
            }
        }
        if(found == true){
            return name;
        }
        else{
            return "NO NAME";
        }
    }
    public void testgetName(){
        String name = getName(1982,450,"M");
        System.out.println("Name =" + name);
    }
    
    public void whatIsNameInYear(String name, int bornyear, int newyear, String gender){
        int rank = getRank(bornyear, name, gender);
        String newName = getName(newyear, rank, gender);
        System.out.println(name + "born in " + bornyear + " would be " + newName + " in " + newyear);
        
    }
    public void testwhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public int yearOfHighestRank(String name, String gender){
        double inf = Double.POSITIVE_INFINITY;
        int highestRank = (int)inf;
        int highestYear = -1;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for(File f : dr.selectedFiles()){
            String year = f.getName().substring(3,7);
            int rank = getRank(Integer.parseInt(year), name, gender);
            if(rank != -1 && rank <= highestRank){
                highestRank = rank;
                highestYear = Integer.parseInt(year);
            }
        }
        
        return highestYear;
    }
    public void testYearOfHighestRank(){
        int highestRankedYear = yearOfHighestRank("Mich", "M");
	 System.out.println("Highest Rank is " + highestRankedYear);
    }
    
    public double getAverageRank(String name, String gender){
        double avrrank = -1;
        int sumrank = 0;
        int count = 0;
        boolean found = false;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            String year = f.getName().substring(3,7);
            int rank = getRank(Integer.parseInt(year), name, gender);
            if(rank != -1){
                found = true;
                count += 1;
                sumrank += rank;
            }
        }
        if(found){
            avrrank = 1.0 * sumrank / count;
        }
        else{
            avrrank = -1;
        }
        return avrrank;
    }
    public void testgetAverageRank(){
        double avg = getAverageRank("Robert", "M");
        if(avg != 0){
            System.out.println("The average rank is : " + avg);
        }
        else{
            System.out.println("The name is not in the files");
        }
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
         int rank = getRank(year,name, gender);
	 int r = 0;
	 int totalBirths = 0;
	 String fileName = "yob" + year + ".csv";
	    
	 FileResource fr = new FileResource();
	 for (CSVRecord rec : fr.getCSVParser(false)) {
	     if (rec.get(1).equals(gender)){
	         int numBorn = Integer.parseInt(rec.get(2));
	         r = getRank(year,rec.get(0), gender);
	         if (r < rank){totalBirths += numBorn;}
	       }
	   }
	 if(totalBirths > 0) return totalBirths;
	 else return -1;
    }
    
    public void testgetTotalBirthsRankedHigher(){
        int totalbirth = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println("Total births : " + totalbirth);
    }
        
}

