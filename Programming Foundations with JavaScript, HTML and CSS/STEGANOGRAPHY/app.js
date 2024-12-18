var image = null;
var image2 = null;
var ans = null;
var c1 = document.getElementById("can1");
var c2 = document.getElementById("can2");
var c3 = document.getElementById("can3");
var c4 = document.getElementById("can4");
var c5 = document.getElementById("can5");

function upload(){
    var fimage = new SimpleImage(finput);
    image = fimage;

    image.drawTo(c1);
}
function upload2(){
    var fimage2 = new SimpleImage(finput2);
    image2 = fimage2;

    image2.drawTo(c2);
}
function Combinedo(){
    ans = makecombine(image2, image);
    ans.drawTo(c5);
}
function makecombine(image2, image){
    image2 = makevisible(image2);
    image2.drawTo(c3);

    image = makehide(image);
    image.drawTo(c4);

    for( var pixel of image2.values()){
        var x = pixel.getX();
        var y = pixel.getY();

        var image2pixel = image2.getPixel(x,y);
        var imagepixel = image.getPixel(x,y);

        pixel.setRed(image2pixel.getRed() + imagepixel.getRed());
        pixel.setGreen(image2pixel.getGreen() + imagepixel.getGreen());
        pixel.setBlue(image2pixel.getBlue() + imagepixel.getBlue());
    }

    return image2
}
function makevisible(image){
    for( var pixel of image.values()){
        pixel.setRed(pixel.getRed()/16);
        pixel.setGreen(pixel.getGreen()/16);
        pixel.setBlue(pixel.getBlue()/16);
    }
    return image;
}
function makehide(image){
    for( var pixel of image.values()){
        pixel.setRed(clearbits(pixel.getRed()));
        pixel.setGreen(clearbits(pixel.getGreen()));
        pixel.setBlue(clearbits(pixel.getBlue()));
    }
    return image;
}
function clearbits(pixval){
    var x = Math.floor(pixval/16) * 16;
    return x;
}
