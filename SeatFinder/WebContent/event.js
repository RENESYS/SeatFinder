
var id = ["당고개", "상계", "노원", "창동", "쌍문", "수유", "미아", "미아사거리", "길음", "성신여대입구", "한성대입구",
	          "혜화", "동대문", "동대문역사문화공원", "충무로", "명동", "회현", "서울역", "숙대입구", 
	          "삼각지", "신용산", "이촌", "동작", "이수", "사당"];
	var top = [200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 
	           200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 177, 133, 88];
	var left = [30, 69, 104, 143, 185, 223, 260, 295, 335, 375, 408,
	            447, 482, 521, 563, 598, 640, 680, 713, 750, 785, 817, 865, 885, 868];



function createButtons(){
	
	var map = document.getElementById("map");
	
	for(var i = 0; i < 25; i++){
		var btn = document.createElement("button");
	    btn.id = id[i];
	    document.body.appendChild(btn);
	    var btnClick = document.getElementById(id[i]);
	    
	    btnClick.style.position = "absolute";
	    btnClick.style.height = "20px";
	    btnClick.style.left = left[i] + map.offsetLeft - 10 + "px";
	    btnClick.style.top = top[i] + map.offsetTop - 7 + "px";
	    btnClick.style.opacity = "0.01";
	   
	    btnClick.addEventListener("click", fillForm, false);
	}
}

function resizeButtons(){
	var map = document.getElementById("map");
	
	for(var i = 0; i < 25; i++){
		var btn = document.getElementById(id[i]);
		btn.style.position = "absolute";
		btn.style.left = left[i] + map.offsetLeft - 10 + "px";
		btn.style.top = top[i] + map.offsetTop - 7 + "px";
	}
}

function fillForm(){
	var a = document.getElementById("hour");
	a.value = this.id;
}

function showCarInfo(){
	for(var i = 0; i < 10; i++){
		var car = document.getElementById(""+i);
		car.addEventListener("mousemove", infoStart, false);
		car.addEventListener("mouseout", infoEnd, false);
	}
}

function infoStart(event){
	var info = document.getElementById("passenger");
	info.style.visibilty = "visible";
	info.innerHTML = "현재 열차 칸 : " + (Number(this.id) + 1) + "량</br>예상 승객 수 : " + this.name;
	
	info.style.position = "absolute";
	info.style.left = event.x + "px";
	info.style.top = event.y + "px";
	info.style.border = "solid #0066ff";
	info.style.backgroundColor = "#cccccc";
	info.style.color = "#0066ff";
	info.style.fontSize = "18px";
	info.style.font = "bold";
}

function infoEnd(event){
	var info = document.getElementById("passenger");
	info.style.visibilty = "hidden";
}