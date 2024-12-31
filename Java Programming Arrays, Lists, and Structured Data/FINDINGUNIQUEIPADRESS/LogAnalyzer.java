import java.util.*;
import edu.duke.*;
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (Ayten) 
 * @version (30/12/2024)
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    int index;
    
    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
    }
    
    public void readFile(String fileName){
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            LogEntry entry = WebLogParser.parseEntry(line);
            records.add(entry);
        }
    }
    public void printAll(){
        for(LogEntry le : records){
            System.out.println(le);
        }
    }
    
    public int countUniqueIps(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le : records){
            String ipAddr = le.getipAdress();
            if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    
    public void printAllHigherThanNum(int num){
        for(LogEntry le : records){
            int statusCode = le.getstatus();
            if(statusCode > num){
                System.out.println(le);
            }
        }
    }
    
    public ArrayList uniqueIPVisitsonDay(String someday){
        ArrayList<String> uniqIPs = new ArrayList<String>();
        ArrayList<String> uniqIpsDate = new ArrayList<String>();
        
        for(LogEntry le : records){
            Date d = le.gettime();
            String str = d.toString();
            String substr = str.substring(4,10);
            String ipAddr = le.getipAdress();
            if(substr.equals(someday) && !uniqIPs.contains(ipAddr)){
                uniqIPs.add(ipAddr);
                uniqIpsDate.add(substr);
            }
        }
        
        return uniqIPs;
    }
    
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqIPs = new ArrayList<String>();
        ArrayList<Integer> uniqIpsstatus = new ArrayList<Integer>();
        
        for(LogEntry le: records){
            int status = le.getstatus();
            String ipAddr = le.getipAdress();
            if(status >= low && status <= high && !uniqIPs.contains(ipAddr)){
                uniqIPs.add(ipAddr);
                uniqIpsstatus.add(status);
            }
        }
        
        return uniqIpsstatus.size();
    }
}
