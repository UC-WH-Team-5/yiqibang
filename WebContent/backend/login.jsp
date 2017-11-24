<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%
	String appPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<link href="../bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<script src="../jquery/jquery-3.2.1.min.js"></script>
<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
<script src="login.js"></script>
<link href="login.css" rel="stylesheet">
<script type="text/javascript">
	var path = "/yiqibang";

	/**
	 * 用户登录
	 * @returns {Boolean}
	 */
	function checkLoginUser() {
		var username = $("#userName").val();
		var password = $("#userPwd").val();
		var validateCode = $("#userValidate").val();
		if (username == "" || password == "") {
			$("#tip").text("用户名或密码不能为空");
			return false;
		} else if (validateCode == "") {
			$("#tip").text("请输入验证码");
			return false;
		} else {
			$('#ProgressModal').modal('show');
			// 获取用户列表
			$.getJSON(path + "/AdminServlet", {
				action : "loginAdmin",
				username : username,
				password : password,
				userValidate : validateCode
			}, function(data) {
				if (data.retCode == 0) {
					window.location.href = "admin.jsp";
				} else if (data.retCode == 1001) {
					$("#userValidate").val("");
					$("#tip").text("验证码错误");
				} else if (data.retCode == 1002) {
					$("#tip").text("用户名或者密码错误");
				} else if (data.retCode == 1003) {
					$("#tip").text("该用户不是管理员，请联系其他管理员");
				} else {
					$("#tip").text("登录失败");
				}
				refreshCode();
				$('#ProgressModal').modal('hide');

			});
		}
	}

	var nameNameRel = "";
	//用户名检测
	function sureUserName() {
		var nameName = $("#usernameIpt").val();
		if (nameName == "") {
			$("#tip_l").text("请输入用户名！");
		} else {
			$.ajax({
				url : "/YiQiBang/UserServlet",
				data : {
					action : "findUserByUserName",
					username : nameName
				},
				type : "get",
				timeout : 5000,
				success : function(data1) {
					var data = JSON.parse(data1);
					if (data.retCode == 0) {
						nameNameRel = nameName;
						$("#tip_l").text("验证码不能为空");
						$('#sureNameModal').modal('hide');
						$('#fgtPwdModal').modal('show');
					} else {
						$("#tip_l").text("用户名输入错误或不存在！");
					}
				}

			});
		}
	}

/* 	//发送手机验证码
	function sendCodeM() {
		var tel = $("#mobile_m").val();
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (tel == "") {
			$("#tip_m").text("请输入手机号码");
			return;
		} else if (!reg.test(tel)) {
			$("#tip_m").text("手机号格式有问题");
		} else {
			$("#sendCode_m").attr("disabled", true);
			$("#sendCode_m").val("发送中...");
			$.getJSON("/YiQiBang/VerificationcodeServlet", {
				action : "sendVerificationCode",
				mobile : tel
			}, function(data) {
				if (data.retCode == 0) {
					var countdown = 60;
					//设置button效果，开始计时  
					$("#sendCode_m").val(countdown + "s");
					//启动计时器，1秒执行一次  
					var timer = setInterval(function() {
						if (countdown == 0) {
							clearInterval(timer); //停止计时器  
							$("#sendCode_m").removeAttr("disabled"); //启用按钮  
							$("#sendCode_m").val("重新发送");
						} else {
							countdown--;
							$("#sendCode_m").val(countdown + "s");
						}
					}, 1000);
					$("#tip_m").text("验证码已发送");
				} else {
					$("#tip_m").text("验证码发送失败");
					$("#sendCode_m").removeAttr("disabled"); //启用按钮
				}
			});
		}
	}

	//手机验证码提交
	function checkCode() {
		$("#tip_m").text("");
		var mobilem = $("#mobile_m").val();
		var codem = $('#code_m').val();
		var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (mobilem == "" || !reg.test(mobilem)) {
			$("#tip_m").text("手机号格式有问题");
		} else if (codem == "") {
			$("#tip_m").text("验证码不能为空");
		} else {
			$.ajax({
				url : "/YiQiBang/VerificationcodeServlet",
				data : {
					action : "searchVerificationcode",
					mobile : mobilem
				},
				type : "post",
				timeout : 5000,
				success : function(data1) {
					var data = JSON.parse(data1);
					if (data.retCode == 0) {
						if (codem == data.retData.code) {
							$("#tip_m").text("");
							$('#fgtPwdModal').modal('hide');
							$("#setPwdModal").modal('show');
						} else {
							$("#tip_m").text("验证码错误");
						}
					} else if (data.retCode == 2100) {
						$("#tip_m").text("未发送验证码");
					} else {
						$("#tip_m").text("服务器异常");
					}
				}

			});
		}
	}
 */
	//密码重置
	function resetPwd() {
		$("#tip_n").text("");
		var newPwd = $("#pwdIpt").val();
		var surePwd = $("#surePwdIpt").val();
		if (newPwd == "" || surePwd == "") {
			$("#tip_n").text("请进行密码填写和确认！");
			return;
		} else if (newPwd != surePwd) {
			$("#tip_n").text("两次密码输入不一致！");
			return;
		} else {
			$("#tip_n").text("");
			$.ajax({
				url : "/YiQiBang/UserServlet",
				data : {
					action : "updatePassword",
					username : nameNameRel,
					password : newPwd
				},
				type:"post",
				timeout:5000,
				success:function(data1){
					var data=JSON.parse(data1);
					if(data.retCode==0){
						alert("修改成功，请登录！");
						$("#setPwdModal").modal('hide');
					}else{
						$("#tip_n").text("服务异常，请重试！");
					}
				}
			});
		}
	}
</script>
</head>
<body>
	<div>
		<h2></h2>
		<form id="form2">
			<img src="img/logo_blue.png" id="right_img">
			<div class="form-group first">
				<label for="userName">用户名：</label> <input type="text"
					class="form-control" id="userName" name="userName"
					placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<label for="userPwd">密&nbsp;&nbsp;&nbsp;码：</label> <input
					type="password" class="form-control" id="userPwd" name="userPwd"
					placeholder="请输入密码">
			</div>
			<!--验证码-->
			<div class="form-grup" id="validate_box">
				<label for="userName">验证码：</label>
				<div class="media">
					<div class="media-left">
						<img onclick="refreshCode()" src="../validate.jsp" id="123"
							alt="图片看不清？点击刷新重新得到验证码" style="cursor: hand;">
					</div>
					<div class="media-body">
						<input type="text" class="form-control" id="userValidate"
							name="userValidate" placeholder="验证码">
					</div>
				</div>
			</div>
			<p id="tip"></p>
			<div class="btn_box">
				<button type="button" class="btn btn-default btn-sm"
					onclick="checkLoginUser()">登录</button>
				<button type="button" class="btn btn-default btn-sm left_margin"
					onclick="$('#sureNameModal').modal('show')">忘记密码</button>
			</div>
		</form>

	</div>
	<jsp:include page="progress.jsp"></jsp:include>

	<!-- 用户名验证框 -->
	<div class="modal fade" id="sureNameModal" tabindex="-1"
		data-backdrop="false" role="dialog"
		aria-labelledby="exampleModalLabel"
		style="background: rgba(0, 0, 0, 0.5); color: gray">
		<div class="modal-dialog" role="document" style="margin-top: 150px">
			<div class="modal-content col-md-10 col-md-offset-1">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">输入用户名</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="usernameIpt"
									placeholder="请输入用户名">
							</div>
						</div>
						<p id="tip_l" style="color: red; margin-top: 20px;"
							class="col-md-offset-4"></p>
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-2">
								<button type="button" class="btn btn-primary"
									onclick="sureUserName()">确定</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 手机验证框 -->
	<div class="modal fade" id="fgtPwdModal" tabindex="-1"
		data-backdrop="false" role="dialog"
		aria-labelledby="exampleModalLabel"
		style="background: rgba(0, 0, 0, 0.5); color: gray">
		<div class="modal-dialog" role="document" style="margin-top: 150px">
			<div class="modal-content col-md-10 col-md-offset-1">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">手机验证</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="bindphone" class="col-sm-3 control-label">手&nbsp;&nbsp;机&nbsp;号:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="mobile_m"
									placeholder="请输入手机号"> <input type="hidden"
									name="action">
							</div>
						</div>
						<div class="form-group">
							<label for="code" class="col-sm-3 control-label">验&nbsp;&nbsp;证&nbsp;码:</label>
							<div class="col-sm-5">
								<div class="input-group">
									<input type="text" class="form-control" id="code_m"
										placeholder="验证码"> <span class="input-group-btn">
										<input class="btn btn-default" type="button"
										onclick="sendCodeM()" id="sendCode_m" value="发送">
									</span>
								</div>
							</div>
						</div>
						<p id="tip_m" style="color: red; margin-top: 20px;"
							class="col-md-offset-4"></p>
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-2">
								<button type="button" class="btn btn-primary"
									onclick="checkCode()">下一步</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 重置密码框 -->
	<div class="modal fade" id="setPwdModal" tabindex="-1"
		data-backdrop="false" role="dialog"
		aria-labelledby="exampleModalLabel"
		style="background: rgba(0, 0, 0, 0.5); color: gray">
		<div class="modal-dialog" role="document" style="margin-top: 150px">
			<div class="modal-content col-md-10 col-md-offset-1">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">重置密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-3 control-label">新&nbsp;&nbsp;密&nbsp;&nbsp;码:</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="pwdIpt"
									placeholder="请输入密码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">确认密码:</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="surePwdIpt"
									placeholder="请确认密码">
							</div>
						</div>
						<p id="tip_n" style="color: red; margin-top: 20px;"
							class="col-md-offset-4"></p>
						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-2">
								<button type="button" class="btn btn-primary"
									onclick="resetPwd()">确定</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	function refreshCode() {
		$("#123").attr("src", "validate.jsp?abc=" + Math.random());
	}
</script>
</html>
