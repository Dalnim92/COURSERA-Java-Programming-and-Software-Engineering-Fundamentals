import edu.duke.*;
import java.io.*;
import java.util.Scanner;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int pos = stringb.indexOf(stringa);
        int l = stringa.length();
        if(stringb.indexOf(stringa,pos+1) > 0){
            return true;
        }
        else{
            return false;
        }
    }
    void testing(){
        String a = "zoo";
        String b = "Forest";
        boolean result = twoOccurrences(a,b);
        System.out.println("1. Soru : " + result);
        String result2 = lasPart(a,b);
        System.out.println("2. Soru : " + result2);
    }
    String lasPart(String stringa, String stringb){
        int pos = stringb.indexOf(stringa);
        int l = stringa.length();
        if(stringb.indexOf(stringa, pos+l) > 0){
            return stringb.substring(pos+l,(stringb.length()));
        }
        else{
            return stringb;
        }
    }
}
