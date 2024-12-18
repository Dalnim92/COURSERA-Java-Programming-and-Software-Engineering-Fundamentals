var image = null;
var image1 = null;
var image2 = null;
var text = document.getElementById("text");
var imageinput = document.getElementById("finput");
var canvas = document.getElementById("can1");
var ctx = canvas.getContext("2d");

function upload(){
    var newimage = new SimpleImage(imageinput);
    image = newimage;
    var h = image.getHeight();
    var w = image.getWidth();
    text.innerHTML = h + "x" + w;
    image.drawTo(canvas);
}
function grayScale(){
    var image1 = image;
    for( var pixel of image1.values()){
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
        pixel.setRed(avg);
        pixel.setGreen(avg);
        pixel.setBlue(avg);
    }
    var h = image1.getHeight();
    var w = image1.getWidth();
    text.innerHTML = h + "x" + w;
    image1.drawTo(canvas);
}
function dored(){
    var image2 = image;
    for(var pixel of image2.values()){
        pixel.setRed(255);
    }
    var h = image2.getHeight();
    var w = image2.getWidth();
    text.innerHTML = h + "x" + w;
    image2.drawTo(canvas);
}
function makeSquare(){
    var image3 = image;
    var h = image3.getHeight();
    var w = image3.getWidth();
    text.innerHTML = h + "x" + w;


    for(let i=1; i < 8; i++){
        var a = Math.round(w / 8) * i;
        var b = Math.round(h / 8) * i;

        for(let x=0; x<w; x++){
            image3.getPixel(x,b).setRed(255);
            image3.getPixel(x,b).setGreen(235);
            image3.getPixel(x,b).setBlue(205);
        }

        for(let y=0; y<h; y++){
            image3.getPixel(a,y).setRed(255);
            image3.getPixel(a,y).setGreen(235);
            image3.getPixel(a,y).setBlue(205);
        }
    }
    image3.drawTo(canvas);

}
function makeRainbow(){
    var image4 = image;
    var h = image4.getHeight();

    for( var pixel of image4.values()){
        if( pixel.getY() <= h/3){
            pixel.setRed(255);
        }
        else if(pixel.getY() > h/3 && pixel.getY() < 2*h/3){
            pixel.setGreen(255);
        }
        else{
            pixel.setBlue(255);
        }
    }
    image4.drawTo(canvas);

}
function ClearImage(){
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}
function ResetImage(){
    var newimage = new SimpleImage(imageinput);
    image = newimage;
    image.drawTo(canvas);
}