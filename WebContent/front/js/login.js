var wait = 60;
function time(o) {
	if (wait == 0) {
		o.removeAttribute("disabled");
		o.value = "免费获取验证码";
		wait = 60;
	} else {

		o.setAttribute("disabled", true);
		o.value = "重新发送(" + wait + ")";
		wait--;
		setTimeout(function() {
			time(o)
		}, 1000)
	}
}

function loginOut() {
	delCookie("loginuser");
	$.getJSON("/yiqibang/UserServlet", {
		action : "logoutUser"
	}, function(data) {
		if (data.retCode == 0) {
			location.reload();
		}
	});
}

function getUserByIdIndex(userId) {
	if (userId != null) {
		$.getJSON(
						"/yiqibang/UserServlet",
						{
							action : "getUserById",
							userid : userId
						},
						function(data) {
							if (data.retCode == 0) {
								$("#loginBtn")
										.html(
												'<li class="dropdown"><a href="#" class="dropdown-toggle"'
														+ 'data-toggle="dropdown" role="button" aria-haspopup="true"'
														+ 'aria-expanded="false">'
														+ data.retData.uNickname
														+ '<span class="caret"></span></a>'
														+ '<ul class="dropdown-menu">'
														+ '<li class="text-center"><a style="color:gray">修改资料</a></li>'
														+ '<li class="text-center"><a onclick="loginOut()" style="color:gray">注销</a></li>'
														+ '</ul>');
							}
						});
	}
}

/* function updateUserSure() {
var nickname = $("#nickname").val();
var username = $("#username1").val();
var password=$("#password1").val();
var phone = $("#mobile1").val();
var sex=	$("#sex_yes").prop("checked") ? true : false;
var remark=$("#remark").val();
var model_title = $("#myModalLabel").text();

var data = {
	sex:sex,
	level : level,
	state : state,
	userid : userid,
	remark:remark,
	password:password
};
if (userid == "" || newsid == "" || thumbcount == "" || remark=="" ||password="") {
	alert("请输入内容");
	return;
}
if (model_title == "修改用户") {
	data.userid = $("#userid").val();
	data.action = "userUpdateAdmin";
} else {
	data.action = "userInsertAdmin";
}

$.ajax({
	url : "/yiqibang/UserServlet",
	data : data,
	timeout : 5000,
	beforesend : function() {
		$('#myModal').modal('show');
	},
	success : function(data) {
		var jsonData = JSON.parse(data);
		if (jsonData.retMsg) {
			location.reload();
		}
	},
	error : function(e) {
		alert("上传失败");
	},
	complete : function() {
		$('#myModal').modal('hide');
		$('#addAdminModal').modal('hide');
	}

})

} */

$(function() {
	//设置记住密码框是否选中
	if(getCookieValue("autologin")=="true"){
		$("#auto_login").prop("checked",true);
	}
	if(getCookieValue("rmbUser")=="true"){
		$("#remember_pwd").prop("checked",true);
		$("#username").val(getCookieValue("username"));
		$("#password").val(getCookieValue("password"));
	}
	
	$("#tip").text("");
	$("#tip1").text("");
	$('#login_phone').click(function() {
		var mobile = $("#mobile").val();
		var code = $('#code').val();
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (mobile == "" || !reg.test($("#mobile").val())) {
			$("#tip1").text("手机号格式有问题");
		} else if (code == "") {
			$("#tip1").text("验证码不能为空");
		} else {
			$.getJSON("/yiqibang/VerificationcodeServlet", {
				action : "searchVerificationcode",
				mobile : mobile
			}, function(data) {
				if (data.retCode == 0) {
					if (code == data.retData.code) {
						$("#loginModal").modal('hide');
					} else {
						$("#tip1").text("验证码错误");
					}
				} else if (data.retCode == 2100) {
					$("#tip1").text("未发送验证码");
				} else {
					$("#tip1").text("服务器异常");
				}
			});
		}

	});
	$("#sendCode").click(function() {
		var mobile = $("#mobile").val();
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (mobile == "" || !reg.test($("#mobile").val())) {
			$("#tip1").text("手机号格式有问题");
			return;
		} else {
			$("#tip1").text("");
			$.getJSON("/yiqibang/VerificationcodeServlet", {
				action : "sendVerificationCode",
				mobile : mobile
			}, function(data) {
				if (data.retCode == 0) {
					var countdown = 60;
					// 设置button效果，开始计时
					$("#sendCode").attr("disabled", "true");
					$("#sendCode").val(countdown + "秒后重新获取");
					// 启动计时器，1秒执行一次
					var timer = setInterval(function() {
						if (countdown == 0) {
							clearInterval(timer); // 停止计时器
							$("#sendCode").removeAttr("disabled"); // 启用按钮
							$("#sendCode").val("重新发送验证码");
						} else {
							countdown--;
							$("#sendCode").val(countdown + "秒后重新获取");
						}
					}, 1000);
					$("#tip1").text("验证码发送已成功");
				} else {
					$("#tip1").text("验证码发送失败");
				}
			});
		}
	});

	$("#loginUserSure").click(function() {	
						var userName = $("#username").val();
						var password = $("#password").val();
						if (userName == "" || password == "") {
							$("#tip").text("请填写用户名和密码");
							return;
						} else if ($("#innerTv").text().trim() != "验证成功!") {
							$("#tip").text("请进行验证");
							return;
						} else {						
							$("#tip").text("");
							$.getJSON("/yiqibang/UserServlet",
											{
												action : "loginUser",
												username : userName,
												password : password
											},
											function(data) {
												if (data.retCode == 0) {

													autoLogin(data.retData.userid);
													savePwd();
													$("#loginModal").modal(
															'hide');
													$("#loginBtn")
															.html(
																	'<li class="dropdown"><a href="#" class="dropdown-toggle"'
																			+ 'data-toggle="dropdown" role="button" aria-haspopup="true"'
																			+ 'aria-expanded="false">'
																			+ data.retData.uNickname
																			+ '<span class="caret"></span></a>'
																			+ '<ul class="dropdown-menu">'
																			+ '<li class="text-center"><a style="color:gray" onclick="updateUserSure()">修改资料</a></li>'
																			+ '<li class="text-center"><a onclick="loginOut()">注销</a></li>'
																			+ '</ul>');
												} else {
													$("#tip").text("用户名或密码错误");
												}
												
											});
						}
					});

	//sha1  MD5
	//记住密码
	function savePwd(){
		if($("#remember_pwd").is(":checked")){
			var username=$("#username").val();
			var password=$("#password").val();
			setCookie("rmbUser", "true","d7");
			setCookie("username",username,"d7");
			setCookie("password",password,"d7");//该操作可以建议用户只在私人电脑使用
		}else{
			delCookie("rmbUser");
			delCookie("username");
			setCookie("password","","s0");
			delCookie("password");
		}
	}
	//十天内自动登录
	function autoLogin(id){
		
		if($("#auto_login").is(":checked")){
			var username=$("#username").val();
			setCookie("autologin","true","d10");
			setCookie("loginuser",id,"d10")
		}else{
			delCookie("autologin");
			delCookie("loginuser");
		}
	}
	
	$("#registerUser").click(function() {
		$("#loginModal").modal('hide');
		$("#registerModal").modal('show');
	});
});



