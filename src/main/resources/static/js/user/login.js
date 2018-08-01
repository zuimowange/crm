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
	$.ajax({
		type:"post",
		url:"/userRest/login",
		data:{
			"po.account":account,
			"po.pwd":pwd
		},
		success:function(data){
			CookieUtil.set("token",data.token);
			if(data.msgCode == 1){
				layer.msg(data.msg, {icon: 6},function(){
					//location.href = "/user/register";
					location.href = "/";
				});
			}
			else{
				layer.msg(data.msg, {icon: 5},function(){
					//location.href = "/user/register";
				});
			}
		}
	});
}
