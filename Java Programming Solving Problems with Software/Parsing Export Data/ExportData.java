import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of ExportData here.
 * 
 * @author (Ayten) 
 * @version (20/12/2024)
 */
public class ExportData {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        /*countryInfo(parser, "Germany");
        listExportersTwoProducts(parser, "gold", "diamonds");
        numberOfExporters(parser, "gold");*/
        bigExporters(parser, "$999,999,999" );
    }
    public void countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String countryname = record.get("Country");
            
            if(countryname.contains(country)){
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.print(country + " : ");
                System.out.print(export + " : ");
                System.out.println(value);
            }
        }
    }
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            
            if(export.contains(exportitem1) && export.contains(exportitem2)){
                String country = record.get("Country");
                
                System.out.println(country);
            }
        }
    }
    public void numberOfExporters(CSVParser parser, String exportitem){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            
            if(export.contains(exportitem)){
                String country = record.get("Country");
                String value = record.get("Value (dollars)");
                System.out.print(country + " ");
                System.out.println(value);
            }
        }
    }
    public void bigExporters(CSVParser parser, String amount){
        int al = amount.length();
        
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            
            if(value.length() > al){
                String country = record.get("Country");
                System.out.print(country + " ");
                System.out.println(value);
            }
        }
    }
}
