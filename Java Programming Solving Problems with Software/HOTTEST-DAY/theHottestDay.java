import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of theHottestDay here.
 * 
 * @author (Ayten) 
 * @version (21/12/2024)
 */
public class theHottestDay {
    public void testhottestDay(){
        FileResource fr = new FileResource("data/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestDay(fr.getCSVParser());
        System.out.println("Hottest Temperature was: " + largest.get("TemperatureF") +
                            " at " + largest.get("TimeEST"));
        
    }
    public CSVRecord hottestDay(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser) {
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
    public void testhottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("Hottest Temperature was: " + largest.get("TemperatureF") +
                            " at " + largest.get("DateUTC"));
    }
    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestDay(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if(largestSoFar == null){
            largestSoFar = currentRow;
        }
        else{
            double currentTemp= Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            
            if(currentTemp > largestTemp){
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }
}
