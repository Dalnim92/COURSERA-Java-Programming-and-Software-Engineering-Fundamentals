import java.util.*;
/**
 * Write a description of Tester here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class Tester {
    public void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        
        System.out.println(le.getLogInfo());
        
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request2", 300, 400);
        System.out.println(le2.getLogInfo());
    }
}
