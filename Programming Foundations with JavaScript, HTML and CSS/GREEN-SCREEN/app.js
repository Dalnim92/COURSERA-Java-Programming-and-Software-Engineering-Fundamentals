var fgImage = null;
var bgImage = null;
var canvas1 = document.getElementById("can1");
var ctx1 = canvas1.getContext("2d");
var canvas2 = document.getElementById("can2");
var ctx2 = canvas2.getContext("2d");
var canvas3 = document.getElementById("can3");
var ctx3 = canvas3.getContext("2d");
var greenThreshold = 200;

function uploadfg(){
    var foreinput = document.getElementById("fgfile");
    fgImage = new SimpleImage(foreinput);
    fgImage.drawTo(canvas1);
}
function uploadbg(){
    var backinput = document.getElementById("bgfile");
    bgImage = new SimpleImage(backinput);
    bgImage.drawTo(canvas2);
}
function greenScreen(){
    if(fgImage == null || !fgImage.complete()){
        alert("foreground not loaded");
        return;
    }
    if(bgImage == null || !bgImage.complete()){
        alert("background not loaded");
        return;
    }
    var output = new SimpleImage(fgImage.getWidth(),fgImage.getHeight());
    for(var pixel of fgImage.values()){
        var x = pixel.getX();
        var y = pixel.getY();
        if(pixel.getGreen() > greenThreshold){
            var bgPixel = bgImage.getPixel(x, y);
            output.setPixel(x, y, bgPixel);
        }
        else{
            output.setPixel(x,y,pixel);
        }
    }
    output.drawTo(canvas3);

}
function clearCanvas(){
    ctx1.clearRect(0, 0, canvas1.width, canvas1.height);
    ctx2.clearRect(0, 0, canvas2.width, canvas2.height);
    ctx3.clearRect(0, 0, canvas3.width, canvas3.height);
}