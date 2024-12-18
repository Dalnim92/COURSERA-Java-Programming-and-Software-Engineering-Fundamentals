import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon,String stopCodon) {
        char ch =(char)dna.charAt(0);
        if(dna=="ATGTAA")
        return dna.toLowerCase();
        dna = dna.toUpperCase();
        int start = dna.indexOf(startCodon);
        if (start == -1)
            return "";

        int stop = dna.indexOf(stopCodon);
        if ((stop - start) % 3 == 0)
        { if(Character.isUpperCase(ch))
            return dna.substring(start, stop + 3);
            else
            { 
                String dna1=dna.substring(start, stop + 3);
            return dna1.toLowerCase();
            }
        }
        else
            return "";
    }

    public void testSimpleGene() {
        String startCodon="ATG";
        String stopCodon="TAA";
        String dna = "cccatggggtttaaataataataggagagagagagagagttt";
        System.out.println("DNA strand is = " + dna);
        String gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is = " + gene);
    
        String ap = "atggggtttaaataataatag";
        System.out.println("DNA strand is = " + ap);
        gene = findSimpleGene(ap,startCodon,stopCodon);
        System.out.println("Gene is = " + gene);
        
        String a = "atgcctag";
        System.out.println("DNA strand is = " + a);
        gene = findSimpleGene(a,startCodon,stopCodon);
        System.out.println("Gene is = " + gene);
        
        String b = "";
        System.out.println("DNA strand is = " + b);
        gene = findSimpleGene(b,startCodon,stopCodon);
        System.out.println("Gene is = " + gene);
        
        String c = "atgccctaa";
        System.out.println("DNA strand is = " + c);
        gene = findSimpleGene(c,startCodon,stopCodon);
        System.out.println("Gene is = " + gene);
    }

    public static void main(String args[]) {
        Part2 p = new Part2();
        p.testSimpleGene();

    }

}