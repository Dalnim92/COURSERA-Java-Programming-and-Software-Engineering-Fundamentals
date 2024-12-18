var image = null;
var image1 = null;
var canvas = document.getElementById("can1");
var canvas2 = document.getElementById("can2");

function upload(){
    var fimage = new SimpleImage(finput);
    image = fimage;
    image.drawTo(canvas);
}

function DoRainbow(){
    var h = image.getHeight();

    for( var pixel of image.values()){
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
        if(pixel.getY() <= h/7){
            if(avg < 128){
                pixel.setRed(255);
            }else{
                pixel.setRed(255);
                pixel.setGreen(2 * avg - 255);
                pixel.setBlue(2 * avg - 255);
            }
        }
        else if(pixel.getY() > h/7 && pixel.getY() <= 2*h/7){
            if(avg < 128){
                pixel.setRed(2*avg);
                pixel.setGreen(0.8*avg);
            }else{
                pixel.setRed(255);
                pixel.setGreen(1.2 * avg - 51);
                pixel.setBlue(2 * avg - 255);
            }
        }
        else if(pixel.getY() > 2*h/7 && pixel.getY() <= 3*h/7){
            if(avg < 128){
                pixel.setRed(2*avg);
                pixel.setGreen(2*avg);
            }else{
                pixel.setRed(255);
                pixel.setGreen(255);
                pixel.setBlue(2*avg-255);
            }
        }
        else if(pixel.getY() > 3*h/7 && pixel.getY() <= 4*h/7){
            if(avg < 128){
                pixel.setGreen(2*avg);
            }else{
                pixel.setRed(2*avg-255);
                pixel.setGreen(255);
                pixel.setBlue(2*avg-255);
            }
        }
        else if(pixel.getY() > 4*h/7 && pixel.getY() <= 5*h/7){
            if(avg < 128){
                pixel.setBlue(2*avg);
            }else{
                pixel.setRed(2*avg-255);
                pixel.setGreen(2*avg-255);
                pixel.setBlue(255);
            }
        }
        else if(pixel.getY() > 5*h/7 && pixel.getY() <= 6*h/7){
            if(avg < 128){
                pixel.setRed(0.8*avg);
                pixel.setBlue(2*avg);
            }else{
                pixel.setRed(1.2*avg - 51);
                pixel.setGreen(2*avg - 255);
                pixel.setBlue(255);
            }
        }
        else{
            if(avg < 128){
                pixel.setRed(1.6*avg);
                pixel.setBlue(1.6*avg);
            }else{
                pixel.setRed(0.4*avg+153);
                pixel.setGreen(2*avg-255);
                pixel.setBlue(0.4*avg+153);
            }
        }
    }
    image.drawTo(canvas2);
}