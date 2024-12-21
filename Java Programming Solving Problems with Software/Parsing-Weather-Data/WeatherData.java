import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of WeatherData here.
 * 
 * @author (Ayten) 
 * @version (21/12/2024)
 */
public class WeatherData {
    //Part1
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow : parser){
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
        }
        return lowestSoFar;
    }
    public void testcoldestHourInFile(){
        FileResource fr =new FileResource();
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
         System.out.println("Coldest temp was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    }
    //Part2
    public String fileWithColdestTemperature(){
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String coldestFile = "";
        double smallest = 99.99;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            lowestSoFar = getLowestOfTwo(currentRow, lowestSoFar);
            if (Double.parseDouble(lowestSoFar.get("TemperatureF")) < smallest) {
                coldestFile = f.getPath();
            }
        }
        return coldestFile;
    }
    public void testfileWithColdestTemperature(){
        String coldestFileName = fileWithColdestTemperature();
        System.out.println("Coldest day from selected files: " + coldestFileName);
        FileResource fr = new FileResource(coldestFileName);
        CSVRecord smallestTemp = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was: " + smallestTemp.get("TemperatureF"));
        
        /*System.out.println("All of the temperatures on the coldest day were:");
        for (CSVRecord current : fr.getCSVParser()) {
            System.out.println(current.get("DateUTC") + ": " + current.get("TemperatureF"));
        }*/
    }
    //Part3
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRow = null;
        for (CSVRecord currentRow : parser) {
            lowestHumidityRow = getLowestHumidityOfTwo(currentRow, lowestHumidityRow);
        }
        return lowestHumidityRow;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public CSVRecord getLowestHumidityOfTwo(CSVRecord currentRow, CSVRecord lowestHumidityRow) {
        if (lowestHumidityRow == null) {
            lowestHumidityRow = currentRow;
        } else {
            if (!currentRow.get("Humidity").equals("N/A")) {
                int currentHumidity = Integer.parseInt(currentRow.get("Humidity"));
                int lowHumidity = Integer.parseInt(lowestHumidityRow.get("Humidity"));
                if (currentHumidity < lowHumidity) {
                    lowestHumidityRow = currentRow;
                }
            }
        }
        return lowestHumidityRow;
    }
    //Part4
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            if(lowestSoFar == null){
                lowestSoFar = current;
            }
            else{
                double currentH = Double.parseDouble(current.get("Humidity"));
                double lowestH = Double.parseDouble(lowestSoFar.get("Humidity"));
                
                if(currentH < lowestH){
                    lowestSoFar = current;
                }
            }
        }
        return lowestSoFar;
    }
    public void testlowestHumidityInManyFiles(){
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidity.get("Humidity") + " at " + lowestHumidity.get("DateUTC"));
    }
    //Part5
    public double averageTemperatureInFile(CSVParser parser){
        double sum = 0.0;
        int count = 0;
        for(CSVRecord current : parser){
            sum = sum + Double.parseDouble(current.get("TemperatureF"));
            count = count + 1;
        }
        return sum/count;
    }
    public void testaverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double avg = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + avg);
    }
    //Part 6
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum = 0.0;
        int count = 0;
        for(CSVRecord current : parser){
            if(Integer.parseInt(current.get("Humidity")) >= value){
                sum = sum + Double.parseDouble(current.get("TemperatureF"));
                count = count + 1;
            }
        }
        return sum/count;
    }
    public void testaverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double avg = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if(Double.isNaN(avg)){
             System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average temperature in file has humidity greater than 80 is " + avg);
        }
    }
    
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord lowestSoFar){
        if(lowestSoFar == null){
            lowestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            
            if(currentTemp < lowestTemp){
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }
}
