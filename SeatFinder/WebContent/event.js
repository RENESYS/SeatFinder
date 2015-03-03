
	var onTop = [200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 
	           200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 177, 133, 88];
	var left = [30, 69, 104, 143, 185, 223, 260, 295, 335, 375, 408,
	            447, 482, 521, 563, 598, 640, 680, 713, 750, 785, 817, 865, 885, 868];
	var stationNum = 409;

function createButtons(){
	var map = document.getElementById("map");

	for(var i = 0; i < 25; i++){
		var btn = document.createElement("button");
		var div = document.getElementById("buttonPosition");
	    btn.id =stationNum + i;
	    document.body.appendChild(btn);
	    var btnClick = document.getElementById(stationNum + i);
	    
	    btnClick.style.position = "absolute";
	    btnClick.style.height = "20px";
	    btnClick.style.left = left[i] + map.offsetLeft - 10 + "px";
	    btnClick.style.top = onTop[i] + map.offsetTop - 7 + "px";
	    btnClick.style.opacity = "0.01";
	   
	    btnClick.addEventListener("click", fillForm, false);
	}
}

function resizeButtons(){
	var map = document.getElementById("map");
	
	for(var i = 0; i < 25; i++){
		var btn = document.getElementById(stationNum + i);
		btn.style.position = "absolute";
		btn.style.left = left[i] + map.offsetLeft - 10 + "px";
		btn.style.top = onTop[i] + map.offsetTop - 7 + "px";
	}
}

function fillForm(){
	var input = document.getElementById("station");
	input.value = this.id;
	
	var image = document.getElementById("sta");
	image.src = "img/sta/"+ this.id +".png";
}

function showCarInfo(){
	for(var i = 0; i < 10; i++){
		var car = document.getElementById(""+i);
		car.addEventListener("click", infoStart, false);
	}
}

function infoStart(event){
	var info = document.getElementById("passenger");
	info.style.visibility = "visible";
	info.innerHTML = "현재 열차 : " + (Number(this.id) + 1) + "량</br>예상 승객 수 : " + this.name;
	
	info.style.position = "absolute";
	info.style.left = event.x + "px";
	info.style.top = event.y + "px";
	info.style.border = "solid #0066ff";
	info.style.backgroundColor = "#cccccc";
	info.style.color = "#0066ff";
	info.style.fontSize = "18px";
	info.style.font = "bold";
}
