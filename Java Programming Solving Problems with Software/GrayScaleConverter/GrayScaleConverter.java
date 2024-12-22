import edu.duke.*;
import java.io.*;
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (Ayten) 
 * @version (22/12/2024)
 */
public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel px : outImage.pixels()){
            //look at the corresponding pixel in inImage
            Pixel inpx = inImage.getPixel(px.getX(), px.getY());
            
            int avg = (inpx.getRed() + inpx.getGreen() + inpx.getBlue())/ 3;
            
            px.setRed(avg);
            px.setGreen(avg);
            px.setBlue(avg);
        }
        return outImage;
    }
    public void testmakeGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeGray(ir);
            gray.draw();
        }
    }
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeGray(ir);
            String filename = "grayscale-" + ir.getFileName();
            gray.setFileName(filename);
            gray.save();
        }
    }
}
