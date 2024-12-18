var paintcanvas = document.getElementById("canvas1");
var context = paintcanvas.getContext("2d");
let color = 'black';
var radius = 50;
// only paint if mouse is  being dragged (moved while the button is pressed)
var isPainting = false;

function setWidth(value){
    const canvas = document.getElementById('canvas1');
    if(isNumeric(value)){
        canvas.width = value;
    }else{
        alert("Please enter a valid number.");
    }
}
function setHeight(value){
    const canvas1 = document.getElementById('canvas1');
    if(isNumeric(value)){
        canvas1.height = value;
    }else{
        alert("Please enter a valid number.");
    }
}
function clearCanvas () {
    context.clearRect(0, 0, paintcanvas.width, paintcanvas.height);
}

function startPaint(){
    isPainting = true;
}
function endPaint(){
    isPainting = false;
}
function doPaint(x,y){
    if(isPainting == true){
        paintCircle(x,y);
    }
}
function setColor(){
    var newcolor = document.getElementById("clr").value;
    color = newcolor;
}
function resizeBrush(){
    var newsize = document.getElementById("sizeOutput").value;
    radius = newsize;
}  
function paintCircle (x, y) {
      // make sure to start a new circle each time
      context.beginPath();
      // draw circle using a complete (2*PI) arc around given point
      context.arc(x, y, radius, 0, Math.PI * 2, true);
      context.fillStyle = color;
      context.fill();
}
  // verify the given value is actually a number
function isNumeric (value) {
    // standard JavaScript function to determine whether a string is an illegal number (Not-a-Number)
    return !isNaN(value);
}
  