/**
 * 
 */

function setupEvents() {
	createButtons();
	
    
}

function createButtons(){
	//var id = ["409", "410", "411", "412", "413", "414", "415", "416", "417", "418", "419",
	//          "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430", "431", "432", "433"];
	var id = ["당고개", "상계", "노원", "창동", "쌍문", "수유", "미아", "미아사거리", "길음", "성신여대입구", "한성대입구",
	          "혜화", "동대문", "동대문역사문화공원", "충무로", "명동", "회현", "서울역", "숙대입구", 
	          "삼각지", "신용산", "이촌", "동작", "이수", "사당"];
	var top = [200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 
	           200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 177, 133, 88];
	var left = [27, 69, 104, 143, 185, 223, 260, 295, 335, 375, 405,
	            440, 475, 518, 560, 598, 633, 675, 713, 750, 785, 815, 860, 880, 863];
	for(var i = 0; i < 25; i++){
		var btn = document.createElement("button");
	    btn.id = id[i];
	    document.body.appendChild(btn);
	    var btnClick = document.getElementById(id[i]);
	    
	    btnClick.style.position = "absolute";
	    btnClick.style.height = "20px";
	    btnClick.style.left = left[i] +"px";
	    btnClick.style.top = top[i] + 113 + "px";
	    btnClick.style.opacity = "0.01";
	   
	    btnClick.addEventListener("click", aaa, false);
	}
}

function aaa(){
	var a = document.getElementById("aaa");
	a.value = this.id;
}