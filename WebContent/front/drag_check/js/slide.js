window.onload = function() {

	resetData();
	initClickFunction();
}
function initClickFunction(){
	var canSlide = true;
	var innerTv = document.getElementById("innerTv")
	var oDiv = document.getElementById("div1");
	var oParent = document.getElementById("parent");
	var disx = 0;
	oDiv.onmousedown = function(ev) {
		if (canSlide) {
			var oEvent = ev || event;
			disx = oEvent.clientX - oDiv.offsetLeft;
			document.onmousemove = function(ev) {
				var oEvent = ev || event;
				var l = oEvent.clientX - disx;
				if (l < 0) {
					l = 0;
				} else if (l = oParent.offsetWidth - oDiv.offsetWidth) {
					l = oParent.offsetWidth - oDiv.offsetWidth;
					document.onmousemove = null;
					document.onmouseup = null;
					innerTv.innerText = "验证成功!";
					innerTv.style.color = "white";
					oParent.style.background = "#7ac23c";
					oDiv.style.backgroundImage = "url('img/kkkk.png')";
					canSlide = false;
				}
				// 根据滑动的距离设置里面的滑块的位置
				oDiv.style.left = l + "px";
			}
			document.onmouseup = function(ev) {
				document.onmousemove = null;
				$("#div1").animate({
					left : "-1px"
				}, 200, "linear");

			}
			return false;
		}
	}
}

function resetData() {
	$("#parent").css("background","#e8e8e8");
	$("#innerTv").css("color","lightgray");
	$("#innerTv").html("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;按住滑块右移");
	$("#div1").css({"background-image":"url('/YiQiBang/font/drag_check/img/lllllll.png",
		"left":"-1px"});
	initClickFunction();
	
}