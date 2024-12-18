var image = null;
var canvas = document.getElementById("can1");
var canvas2 = document.getElementById("can2");

function upload(){
    var img = new SimpleImage(finput);
    image = img;
    image.drawTo(canvas);
}

function makeBlur() {
    canvas2.className ="blur";

    image.drawTo(canvas2);
}