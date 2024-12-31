import java.util.*;

/**
 * Write a description of LogEntry here.
 * 
 * @author (Ayten) 
 * @version (25/12/2024)
 */
public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    
    public LogEntry(String ip, Date time, String req, int status, int bytes){
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }
    
    public String getIpAddress(){
        return ipAddress;
    }
    public Date getAccessTime(){
        return accessTime;
    }
    public String getrequest(){
        return request;
    }
    public int getstatus(){
        return statusCode;
    }
    public int getbytes(){
        return bytesReturned;
    }
    
    public String getLogInfo(){
        return ipAddress +" " + accessTime + " " + request + " " + statusCode + " " + + bytesReturned;
    }
}
