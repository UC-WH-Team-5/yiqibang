var path="/YiQiBang";


/**
 * 用户登录
 * @returns {Boolean}
 */
function checkLoginUser(){
	var username=$("#userName").val();
	var password=$("#userPwd").val();
	var validateCode=$("#userValidate").val();
	if(username==""||password==""){
		$("#tip").text("用户名或密码不能为空");
		return false;
	}else if(validateCode==""){ 
		$("#tip").text("请输入验证码");
		return false;
	}else{
		$('#ProgressModal').modal('show');
		// 获取用户列表
		$.getJSON(
			path + "/AdminServlet",
			{
				action : "loginAdmin",
				username:username,
				password:password,
				userValidate:validateCode
			},
			function(data) {
				if (data.retCode == 0) {
					window.location.href="index.jsp";
				}else if(data.retCode==1001){
					$("#userValidate").val("");
					$("#tip").text("验证码错误");
				}else if(data.retCode==1002){
					$("#tip").text("用户名或者密码错误");
				}else if(data.retCode==1003){
					$("#tip").text("该用户不是管理员，请联系其他管理员");
				}else{
					$("#tip").text("登录失败");
				}
				refreshCode();
				$('#ProgressModal').modal('hide');
				
		});
	}
}

