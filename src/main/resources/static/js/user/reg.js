/**
 * 注册方法
 */
$("#regBtn").click(function(){
	regFuc();
})
document.onkeydown = function(e){
	var ev = document.all ? window.event : e;
	if(ev.keyCode == 13){
		regFuc();
	}
}

function regFuc(){
	layer.msg("注册", {icon: 6},function(){});
}
