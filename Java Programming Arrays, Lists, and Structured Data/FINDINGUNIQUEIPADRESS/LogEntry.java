import java.util.*;
/**
 * Write a description of LogEntry here.
 * 
 * @author (Ayten) 
 * @version (30/12/2024)
 */
public class LogEntry {
    private String ipAdress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    
    public LogEntry(String ip, Date time, String req, int status, int bytes){
        ipAdress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }
    
    public String getipAdress(){
        return ipAdress;
    }
    public Date gettime(){
        return accessTime;
    }
    public String getreq(){
        return request;
    }
    public int getstatus(){
        return statusCode;
    }
    public int getbytes(){
        return bytesReturned;
    }
    
    public String toString(){
        return ipAdress +" " + accessTime + " " + request + " " + statusCode + " " + bytesReturned; 
    }
}
