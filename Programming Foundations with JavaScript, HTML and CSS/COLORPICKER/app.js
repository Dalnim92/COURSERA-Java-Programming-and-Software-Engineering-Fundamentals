function docolor(){
    var cc1 = document.getElementById("c1");
    var colorinput = document.getElementById("clr");

    var color = colorinput.value;
    cc1.style.backgroundColor = color;
}
function dosquare(){
    var c1 = document.getElementById("c1");
    var sizeinput = document.getElementById("sldr");

    var size = sizeinput.value;
    var ctx = c1.getContext("2d");
    ctx.clearRect(0,0,c1.width, c1.height);
    ctx.fillStyle = "yellow";
    ctx.fillRect(10,10,size,size);
}