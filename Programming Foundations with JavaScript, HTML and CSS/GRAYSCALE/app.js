var image;

function upload(){
    var imgcanvas = document.getElementById("can1");
    var fileinput = document.getElementById("finput");
    image = new SimpleImage(fileinput);

    image.drawTo(imgcanvas);
}

function makeGray(){
    for( var pixel of image.values()){
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
        pixel.setRed(avg);
        pixel.setGreen(avg);
        pixel.setBlue(avg);
    }
    var imggray = document.getElementById("can2");
    image.drawTo(imggray);
}