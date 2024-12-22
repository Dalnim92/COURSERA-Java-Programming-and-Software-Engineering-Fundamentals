import edu.duke.*;
import java.io.*;

/**
 * Write a description of InvertedImages here.
 * 
 * @author (Ayten) 
 * @version (22/12/2024)
 */
public class InvertedImages {
    public ImageResource ConvertToInverted(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel px : outImage.pixels()){
            Pixel inpx = inImage.getPixel(px.getX(), px.getY());
            
            px.setRed(255 - inpx.getRed());
            px.setGreen(255 - inpx.getGreen());
            px.setBlue(255 - inpx.getBlue());
        }
        return outImage;
    }
    public void testConvertToInverted(){
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            ImageResource ir = new ImageResource(f);
            ImageResource inverted =  ConvertToInverted(ir);
            String filename = "inverted-" + ir.getFileName();
            inverted.setFileName(filename);
            inverted.save();
            inverted.draw();
        }
    }
}
