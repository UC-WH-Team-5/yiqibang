$(function() {
	
	
		$("#tip2").text("");		
		$('#registerBtn').click(function() {
			var code = $('#code1').val();
			var nickName = $("#nickname").val();
			var userName = $("#username1").val();
			var password = $("#password1").val();
			var phone = $("#mobile1").val();
			var sex=	$("#sex_yes").prop("checked") ? true : false;
			var remark=$("#remark").val();
			var model_title = $("#myModalLabel").text();
			var headimg=$("#headimg").val();
			if (checkIpt()) {
				$.getJSON("/yiqibang/UserServlet", {
					action : "registerUserByMobile",
					bindphone : phone,
					nickname:nickName,
					username:userName,
					password:password,
					headimg:headimg,
					sex:sex,
					remark:remark,
					password:password

				}, function(data) {
					if (data.retCode == 0) {
						window.location.href = "index.html";
						
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
		
	/*	$("#updateBtn").click(function(){
			alert("我进来了");
			$('#registerModal').modal('show');
			$.ajax({
				url:"yiqibang/UserServlet",
				data:{
					action:findUserByUserName,
					username:userName
				},
				timeout : 5000,
				beforesend : function() {
					$('#myModal').modal('show');
				},
				success : function(data) {
					var jsonData = JSON.parse(data);
					var user=data.retData;
					console.log(jsonData.retMsg);
					if (jsonData.retMsg) {
						$("#myModalLabel").text("修改用户资料");
						
						$("#nickname").val(user.uNickname);
						$("#username1").val(user.uUsername);
						$("#mobile1").val(user.uBindtel);
						if(user.uSex){
							$("#sex_yes").attr("checked", true);
							$("#sex_no").removeAttr("checked");
						} else {
							$("#sex_no").attr("checked", true);
							$("#sex_yes").removeAttr("checked");
						}
						$("#myhead").attr("src",user.uHeading);
						$("#remark").val(user.uRemark);
						$('#userid').val(user.id);

					}
				},
				error : function(e) {
					alert("上传失败");
				},
				complete : function() {
					$('#myModal').modal('hide');
					$('#registerModal').modal('hide');
				}
										
			})
		})*/

});



	function checkIpt() {
		var nickName = $("#nickname").val();
		var userName = $("#username1").val();
		var password = $("#password1").val();
		var mobile = $("#mobile1").val();
		/*var code = $('#code1').val();*/
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (nickName == "" || userName == "" || password == "") {
			$("#tip2").text("请填写昵称、用户名和密码");
			return false;
		}
		if (mobile == "" || !reg.test(mobile)) {
			$("#tip2").text("手机号格式有问题");
			return false;
		} /*else if (code == "") {
			$("#tip2").text("验证码不能为空");
			return false;
		}*/ else {
			return true;
		}
	}
