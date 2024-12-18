function changeColor(){
    var c1 = document.getElementById("c1");
    var c2 = document.getElementById("c2");
    
    if(c1.className=="orangeback"){
        c1.className="blueback";
    }
    else if(c1.className=="blueback"){
        c1.className="fuchsiaback";
    }
    else{
        c1.className="orangeback";
    }

    if(c2.className=="orangeback"){
        c2.className="blueback";
    }
    else if(c2.className=="blueback"){
        c2.className="fuchsiaback";
    }
    else{
        c2.className="orangeback";
    }
}

function addSquare(){
    var c1 = document.getElementById("c1");
    var c2 = document.getElementById("c2");

    var ctx = c1.getContext("2d");

    ctx.fillStyle = "yellow";
    ctx.fillRect(10,10,60,60);
    ctx.fillRect(80,10,60,60);

    ctx.fillStyle = "black";
    ctx.font = "20px Arial";
    ctx.fillText("Hello", 15,45);
}
//able to draw a line
function addLine(){
    var c2 = document.getElementById("c2");

    var ctx = c2.getContext("2d");
    ctx.moveTo(0,0);
    ctx.lineTo(400,200);
    ctx.stroke();
}
//draw a circle
function drawCircle(){
    var c2 = document.getElementById("c2");

    var ctx = c2.getContext("2d");
    ctx.beginPath();
    ctx.arc(150,75,40,0,2*Math.PI);
    ctx.stroke();
}

/* function doyellow(){
    var dd1 = document.getElementById("c1");
    dd1.style.backgroundColor="white";
    var ctx = dd1.getContext("2d");
    ctx.fillStyle = "yellow";
    ctx.fillRect(10,10,40,40);
    ctx.fillRect(60,10,40,40);
    
    ctx.fillStyle = "black";
    ctx.font = "30px Arial";
    ctx.fillText("Hello",10,80);
}*/