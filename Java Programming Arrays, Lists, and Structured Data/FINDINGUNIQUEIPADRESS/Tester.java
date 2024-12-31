import java.util.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog3-short_log");
        read.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println("There are " + la.countUniqueIps() + " different IPs");
    }
    
    public void testprintAllHigherNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testuniqueIPVisitsonDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        la.countUniqueIps();
        ArrayList al = la.uniqueIPVisitsonDay("Mar 17");
        System.out.println(al.size());
    }
    public void testcountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
}
