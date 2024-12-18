var image = null;
var c1 = document.getElementById("can1");
var c2 = document.getElementById("can2");

function upload(){
    var fimage = new SimpleImage(finput);
    image = fimage;

    var w = image.getWidth();
    var h = image.getHeight();

    
    var l1 = document.getElementById("label1");
    l1.innerHTML = w + "x" + h;

    image.drawTo(c1);

}
function docrop(){
    var ans = new SimpleImage(200, 200);

    for ( var px of ans.values()){
        var x = px.getX();
        var y = px.getY();

        var imagepx = image.getPixel(x, y);

        px.setRed(imagepx.getRed());
        px.setGreen(image.getGreen());
        px.setBlue(image.getBlue());
    }

    ans.drawTo(c2);
}