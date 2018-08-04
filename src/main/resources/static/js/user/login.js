/**
 * 登录方法
 */
$("#loginBtn").click(function(){
	loginFuc();
})
document.onkeydown = function(e){
	var ev = document.all ? window.event : e;
	if(ev.keyCode == 13){
		loginFuc();
	}
}
function loginFuc(){
	var account = $("#account").val();
	var pwd = $("#pwd").val();
	pwd = hex_md5(pwd);
	$.ajax({
		type:"post",
		url:"/userRest/login",
		data:{
			"po.account":account,
			"po.pwd":pwd
		},
		success:function(data){
			if(data.code == 0){
				layer.msg(data.msg, {icon: 6},function(){
					location.href = "/";
				});
			}
			else{
				layer.msg(data.msg, {icon: 5},function(){
				});
			}
		}
	});
}
