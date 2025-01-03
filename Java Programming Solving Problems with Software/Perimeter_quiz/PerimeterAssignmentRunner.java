import edu.duke.*;
import java.io.File;
/**
 * 
 * @author (Ayten) 
 * @version (16/12/2024)
 */
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int i = 0;
        for(Point currnt: s.getPoints()){
            i = i + 1;
        }
        return i;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double large = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist > large){
                large = currDist;
            }
            prevPt = currPt;
        }
        return  large;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        for(Point currPt: s.getPoints()){
            double currX = currPt.getX();
            if(currX > largestX){
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestperm = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape snew = new Shape(fr);
            double per = getPerimeter(snew);
            if(per > largestperm){
                largestperm = per;
            }
        }
        return largestperm;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestperm = 0.0;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s= new Shape(fr);
            if(getPerimeter(s) > largestperm){
                largestperm = getPerimeter(s);
                temp = f;
            }
        }
           // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int num = getNumPoints(s);
        System.out.println("Number of points = " + num);
        double avg = getAverageLength(s);
        System.out.println("Average = " + avg);
        double largestside = getLargestSide(s);
        System.out.println("Largest side length is = " + largestside);
        double largestXPt = getLargestX(s);
        System.out.println("Largest X point is = " + largestXPt);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("The largest Perimeter =" + getLargestPerimeterMultipleFiles());
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("The largest perimeter file name is =" + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
