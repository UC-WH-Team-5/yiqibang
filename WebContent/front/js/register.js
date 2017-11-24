$(function() {
		$("#tip2").text("");
		$('#registerBtn').click(function() {
			var code = $('#code1').val();
			var nickName = $("#nickname").val();
			var userName = $("#username1").val();
			var password = $("#password1").val();
			if (checkIpt()) {
				$.getJSON("/YiQiBang/UserServlet", {
					action : "registerUserByMobile",
					bindphone : $("#mobile").val(),
					nickname:nickName,
					username:userName,
					password:password,
					code:code
				}, function(data) {
					if (data.retCode == 0) {
						window.location.href = "login.html";
						alert("注册成功"); 
					} else if(data.retCode ==2004 ){
						$("#tip2").text("用户名已经存在，请重新输入");
					}else if(data.retCode ==2005){
						$("#tip2").text("验证码错误");
					}else{
						$("#tip2").text("注册失败");
					}
				});
			}

		});
		/*$("#sendCode1").click(function() {
			var mobile = $("#mobile").val();
			var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if (mobile == "" || !reg.test($("#mobile").val())) {
				$("#tip2").text("手机号格式不正确");
				return;
			} else {
				$("#tip2").text("");
				$("#sendCode").attr("disabled",true);
				$("#sendCode").val("发送中...");
				$.getJSON("/YiQiBang/VerificationcodeServlet", {
					action : "sendVerificationCode",
					mobile : mobile
				}, function(data) {
					if (data.retCode == 0) {
						var countdown = 60;
						//设置button效果，开始计时  
						$("#sendCode").text(countdown + "s");
						//启动计时器，1秒执行一次  
						var timer = setInterval(function() {
							if (countdown == 0) {
								clearInterval(timer); //停止计时器  
								$("#sendCode").removeAttr("disabled"); //启用按钮  
								$("#sendCode").text("重新发送");
							} else {
								countdown--;
								$("#sendCode").text(countdown + "s");
							}
						}, 1000);
						$("#tip2").text("验证码发送已成功");
					} else {
						$("#tip2").text("验证码发送失败"); 
					}
				});
			}
		});
	});*/

	function checkIpt() {
		var nickName = $("#nickname").val();
		var userName = $("#username1").val();
		var password = $("#password1").val();
		var mobile = $("#mobile1").val();
		var code = $('#code1').val();
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (nickName == "" || userName == "" || password == "") {
			$("#tip2").text("请填写昵称、用户名和密码");
			return false;
		}
		if (mobile == "" || !reg.test(mobile)) {
			$("#tip2").text("手机号格式有问题");
			return false;
		} else if (code == "") {
			$("#tip2").text("验证码不能为空");
			return false;
		} else {
			return true;
		}
	}
