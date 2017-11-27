<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.min.css">
<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../js/date_util.js"></script>
<script src="../js/area.ui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="js/uEditer/ueditor.config.js"></script>

<script type="text/javascript" src="js/uEditer/ueditor.all.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
}

ul, li {
	list-style: none;
}

.clear {
	overflow: hidden;
	zoom: 1;
}

#page {
	width: 920px;
	height: 580px;
	margin-bottom: 0;
	margin-left: auto;
	margin-right: auto;
}

#header {
	background: #1e324b;
	width: 920px;
	height: 60px;
	padding: 0;
	position: relative;
}

#header .navbar-header {
	height: 60px;
	line-height: 60px;
	margin-left: 20px;
}

#header .navbar-header a {
	font-family: 微软雅黑;
	font-size: 12px;
	color: #e9ebed;
	text-align: left;
}

#header .navbar-header a img {
	margin-right: 5px;
	width: 40px;
	height: 40px;
}

#header ul {
	position: absolute;
	width: 90px;
	height: 32px;
	top: 22px;
	right: 0px;
}

#header ul li button {
	border: none;
	background: none;
	font-family: 微软雅黑;
	font-size: 12px;
	color: #e9ebed;
	text-align: left;
}

/*姝ｆ枃閮ㄥ垎*/
#content {
	width: 920px;
	height: 520px;
	float: left;
	padding: 0;
}

#content .left {
	height: 520px;
	width: 139px;
	margin: 0;
	padding: 0;
	float: left;
	background: #343434;;
}

#content .left div a {
	height: 32px;
	line-height: 32px;
	background: none;
	border: none;
	font-family: 微软雅黑;
	font-size: 12px;
	color: #ffffff;
	text-align: left;
	padding: 0;
	margin: 0;
	position: relative;
}

#content .left div a img:first-child {
	width: 19px;
	height: 19px;
	margin: 8px 16px;
}

#content>div.container-fluid.left>div>a>img:last-child {
	top: 5px;
	right: -4px;
	position: absolute;
	display: none;
}

#content .right {
	width: 781px;
	height: 520px;
	margin: 0;
	padding: 0;
	float: left;
	background: white;
	position: relative;
}

#content .left>img {
	width: 105px;
	height: 35px;
	margin: 275px 13.5px 0 13.5px;
}

.user_tr>td>div {
	height: 30px;
}

.user_tr td {
	max-width: 75px;
	text-over: ellipsis;
	white-space: nowrap;
	overflow: hidden;
	font-family: 微软雅黑;
	font-size: 12px;
	color: #949494;
	text-align: center;
	height: 31px;
	line-height: 31px;
	border: 1px solid #ddd;
	padding: 0;
	vertical-align: middle !important;
}

.user_tr>td>div {
	height: 35px;
}

#content .right table {
	margin: 0;
}

#content .right table>thead>tr>* {
	font-family: 微软雅黑;
	font-size: 12px;
	color: #676767;
	text-align: center;
	height: 36px;
	line-height: 36px;
	border: 1px solid #ddd;
	padding: 0;
}

.pagebox nav {
	position: absolute;
	bottom: 0px;
	left: 320px;
}

#content .right nav>ul {
	margin: 0;
}

#content .right .con_header {
	width: 781px;
	height: 50px;
	background: #ededed;
}

#content .right .con_header>div>ul>li>a {
	margin-left: 11px;
}

#content .right .con_header>* {
	float: left;
	height: 30px;
	margin-top: 10px;
}

#content .right .con_header>div {
	width: 500px;
	height: 50px;
	position: relative;
	margin: 0;
}

#content .right .con_header>div>input {
	width: 170px;
	height: 30px;
	position: absolute;
	top: 10px;
	left: 300px;
}

#content>div.container-fluid.right>div>button {
	margin-left: 160px;
	width: 60px;
}

#content .right .con_header>div>span {
	position: absolute;
	left: 470px;
	top: 10px;
}

#content .right .con_header>div>span>button {
	width: 40px;
	height: 30px;
	border-left: none;
	padding: 0;
}

#content>div.container-fluid.right>div>div>ul {
	position: absolute;
	height: 40px;
	left: 50px;
	top: 10px;
}

#content>div.container-fluid.right>div>div>ul>li {
	float: left;
	width: 50px;
}

#content>div.container-fluid.right>div>div>ul>li>a {
	height: 40px;
	line-height: 40px;
}

#addNewsModal {
	padding-bottom: 100px;
	overflow: scroll;
}

@media ( min-width :768px) {
	#addNewsModal .modal-dialog {
		width: 70%;
	}
}

.icon_row .row {
	margin: 0;
}

.icon_row .row>div {
	padding: 22px 0;
}

.icon_row .row span {
	font-size: 16px;
}

.icon_row .row span:hover {
	color: red;
}

#table_head>tr>td {
	height: 35px;
}
</style>
<script>
	$(function() {
		getPageAllData(1);

		$(".aactive").css({
			"background" : "#161D22",
			"color" : "#E1E2E3"
		});
		$(".aactive>img:last-child").css("display", "block");
		$(".uactive").css("background", "#FFA705")
		$(document).area("s_province", "s_city", "s_county");
		showPageBox("/yiqibang/UserServlet", "getAllUserCount");
		
		$("#uploadBtn").click(
				function() {
					var result = checkImg();
					if (result) {
						//表单数据
						var formData = new FormData(document.getElementById("headForm"));
						$.ajax({
									url : "/yiqibang/FileUploadServlet?action=addUserPhoto",
									type : "post",
									data : formData,
									processData : false,
									contentType : false,
									success : function(data) {
										console.log(data);
										//将json字符串转化为js的对象
										var result = JSON.parse(data);
										if (result.retMsg) {
											console.log(result.imgName);
											  $("#myhead").attr("src","/yiqibang/img/"+result.imgName);
											  $("#headimg").attr("value","/yiqibang/img/"+result.imgName);
										} else {
											alert("上传失败");
										}

									},
									error : function(e) {
										console.log(data);
									}
								});
					}
				});
	});

	function getPageAllData(pageNum) {
		$('#myModal').modal('show');
		$.getJSON("/yiqibang/UserServlet", {
			action : "getPageAllData",
			pageNum : pageNum,
		}, function(data) {

			showAllData(data, pageNum);
		});
	}

	function showAllData(data, pageNum) {
		if (data.retMsg) {
			$("#userList_body").html("");
			var userList = data.retData;
			for (var i = 0; i < userList.length; i++) {
				var user = userList[i];
				console.log(user);
				$("#userList_body")
						.append(
								'<tr align="center" class="user_tr">' + "<td>"
										+ ((pageNum - 1) * pageSize + i + 1)
										+ "</td>"
										+ "<td>"
										+ user.uUsername
										+ "</td>"
										+ "<td>"
										+ user.uNickname
										+ "</td>"
										+ "<td>"
										+ user.uPassword
										+ "</td>"
										+ "<td>"
										+ (user.uSex ? "男" : "女")
										+ "</td>"
										+ "<td>"
										+ getStrDate(user.uBirthday.time)
										+ "</td>"
										+ "<td>"
										+ user.uProvinceid
										+ user.uCityid
										+ +"</td>"
										+ "<td>"
										+ user.uBindtel
										+ "</td>"
										+ "<td>"
										+ (user.uState ? "可用" : "不可用")
										+ "</td>"
										+ "<td>"
										+ getStrDate(user.uCreatetime.time)
										+ "</td>"
										+ "<td>"
										+ getStrDate(user.uUpdate.time)
										+ "</td>"
										+ "<td>"
										+ '<img src="" id="myhead" style="width:50px;height:50px;">'
										+ "</td>"
										+ "<td>"
										+ user.uRemark
										+ "</td>"
										+ '<td class="icon_row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-user" id="adminBtn" onclick="lvlUp('
										+ user.id
										+ ')"></span>'
										+ '</div>'
										+ '</td>'
										+ '<td class="icon_row" style="width:50px">'
										+ '<div class="row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-cog configBtn" id="configBtn'+i+'" ></span>'
										+ '</div>'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-trash" id="deleteBtn'
										+ i + '" onclick="deleteUser('
										+ user.id + ')"></span>' + '</div>'
										+ '</div>' + '</td>' + "</tr>");

			}
			$(".configBtn").each(function(index) {
				$("#configBtn" + index).click(function() {
					var user = userList[index];
					$('#addUserModal').modal('show');
					/* $("#myModalLabel").text("修改管理员"); */
					$("#nickname").val(user.uNickname);
					$("#username").val(user.uUsername);
					$("#mobile1").val(user.uBindtel);
					if (user.uSex) {
						$("#sex_yes").attr("checked", true);
						$("#sex_no").removeAttr("checked");
					} else {
						$("#sex_no").attr("checked", true);
						$("#sex_yes").removeAttr("checked");
					}
					$("#myhead").attr("src", user.uHeading);
					$("#remark").val(user.uRemark);
					$('#userid').val(user.id);

				})
			});
			$('#myModal').modal('hide');
		}
	}

	function addAdminBtn() {
		$('#addUserModal').modal('show');
	}

	function searchAdminByLike() {
		var searchTv = $("#searchTv").val();
		if (searchTv == "") {
			getPageAllData(1);
		} else {

			$.ajax({
				url : "/yiqibang/UserServlet",
				data : {
					action : "userGetAdminByLike",
					likeStr : searchTv
				},
				type : "get",
				timeout : 5000,
				beforesend : function() {
					$('#myModal').modal('show');
				},
				success : function(data) {
					var datas = JSON.parse(data);
					showAllData(datas, 1);
				},
				error : function(e) {
					alert("上传失败");
				},
				complet : function() {
					$('#myModal').modal('hide');
				}
			})

		}
	}

	function deleteAdmin(userId) {
		$.ajax({
			url : "/yiqibang/UserServlet",
			data : {
				action : "deleteUserById",
				userid : userId
			},
			type : "post",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var jsData = JSON.parse(data);
				if (jsData.retMsg) {
					alert("删除成功");
					location.reload();
				} else if (jsData.retCode == 11) {
					alert("该账户为管理员账户，没有删除权限");
				} else {
					alert("删除失败");
				}
				;
			},
			error : function(e) {
				alert("上传失败");
			},
			complet : function() {
				$('#myModal').modal('hide');
			}

		})
	}

	function lvlUp() {

		var userid = $("#userid").val();
		var level = $("#level").val();
		var state = $("#admin_yes").prop("checked") ? true : false;
		var data = {
			level : level,
			state : state,
			userid : userid
		};
		$.ajax({
			url : "/yiqibang/AdminServlet",
			data : {
				action : "InsertAdmin",
				data : data

			},
			type : "post",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var jsData = JSON.parse(data);
				if (jsData.retMsg) {
					alert("添加成功");
					location.reload();
				} else {
					alert("添加失败");
				}
				;
			},
			error : function(e) {
				alert("上传失败");
			},
			complet : function() {
				$('#myModal').modal('hide');
			}

		})
	}
</script>
</head>

<body>
	<div id="page">
		<div class="container-fluid clear" id="header">
			<div class="navbar-header">
				<a> <img src="img/public/touxiang.png"> 刘老师
				</a>
			</div>
			<ul class="clear">
				<li>
					<button>注销</button>
				</li>
			</ul>
		</div>

		<div class="container-fluid clear" id="content">
			<div class="container-fluid left">
				<div class="list-group">
					<a href="#" class="list-group-item  aactive"> <img
						src="img/public/yonghuguanli.png"> 用户管理 <img
						src="img/public/cebianlan-sanjiaoxing.png">
					</a> <a href="news.jsp" class="list-group-item"> <img
						src="img/public/xinwenguuanli.png"> 新闻管理 <img
						src="img/public/cebianlan-sanjiaoxing.png">
					</a> <a href="comment.jsp" class="list-group-item"> <img
						src="img/public/pinglunguanli.png"> 评论管理 <img
						src="img/public/cebianlan-sanjiaoxing.png">
					</a> <a href="#" class="list-group-item"> <img
						src="img/public/xinwenpachong.png"> 新闻爬虫 <img
						src="img/public/cebianlan-sanjiaoxing.png">
					</a> <a href="types.jsp" class="list-group-item "> <img
						src="img/public/xinwenguanlfenlei.png"> 新闻分类管理 <img
						src="img/public/cebianlan-sanjiaoxing.png">
					</a>
				</div>
				<img src="../web/img/logo.png">
			</div>
			<div class="container-fluid right">
				<div class="container-fluid con_header clear">
					<div class="input-group">
						<ul class="clear">
							<li class="uactive"><a>用户</a></li>
							<li><a href="admin.jsp">管理员</a></li>
						</ul>
						<input type="text" class="form-control" placeholder="内容"
							id="searchTv"> <span class="input-group-btn">
							<button class="btn btn-default" type="button"
								onclick="searchAdminByLike()">
								<img src="img/public/fangdajing.png">
							</button>
						</span>
					</div>
					<button onclick="addAdminBtn()">
						<span class="glyphicon glyphicon-plus-sign"></span>添加
					</button>
				</div>

				<table class="table table-bordered table-stripted">
					<thead id="table_head">
						<tr>
							<td>序号</td>
							<td>用户名</td>
							<td>昵称</td>
							<td>密码</td>
							<td>性别</td>
							<td>生日</td>
							<td>地址</td>
							<td>手机号码</td>
							<td>状态</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td>头像</td>
							<td>备注</td>
							<td>设为管理员</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="userList_body">



					</tbody>
				</table>
				<div class="pagebox" id="pageBox"></div>
			</div>
		</div>
	</div>
	</div>

	<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title" id="myModalLabel">修改用户资料</h4>
				</div>
				<div class="modal-body" style="position: relative;">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="nickname" class="col-sm-3 control-label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="nickname"
									name="nickname" placeholder="请输入昵称">
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">用&nbsp;&nbsp;户&nbsp;名:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="username1"
									name="username" placeholder="请输入用户名"> <input
									type="hidden" name="action">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别</label>
							<div class="col-sm-9">
								<label class="radio-inline"> <input type="radio"
									name="state" id="sex_yes" value="true" checked>男
								</label> <label class="radio-inline"> <input type="radio"
									name="state" id="sex_no" value="false"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="bindphone" class="col-sm-3 control-label">手&nbsp;&nbsp;机&nbsp;号:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="mobile1"
									name="bindphone" placeholder="请输入手机号"> <input
									type="hidden" name="action">
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="password1"
									name="password" placeholder="6-16位英文（区分大小写）、数字或常用字符"> <input
									type="hidden" id="newsid" value="0">
							</div>
						</div>
						<div class="form-group">
							<label for="sure_password" class="col-sm-3 control-label">确认密码:</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="sure_password1"
									placeholder="请再次输入密码">
							</div>
						</div>

						<div class="form-group" style="height: 130px;">
							<label class="col-sm-3 control-label">头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像:</label>
							<input type="hidden" id="headimg" value="0">
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="remark"
									name="remark" placeholder="备注" value="">
							</div>
						</div>

						<div class="form-group">
							<p id="tip2" class="col-sm-offset-4" style="color: red"></p>
						</div>

					</form>
					<div class="col-sm-9 col-sm-offset-3"
						style="position: absolute; top: 290px; padding: 0; height: 70px; border: none;">
						<form id="headForm" style="border: none;">
							<div class="caption">
								<img src="" id="myhead" style="width: 50px; height: 50px;">
								<div class="caption">

									<input type="file" name="myfile" id="fileIpt">
									<button type="button" id="uploadBtn">上传头像</button>

								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="addUserSure()">确定</button>
				</div>
			</div>
		</div>
	</div>

	</div>
	</div>
	</div>
	<jsp:include page="progress.jsp"></jsp:include>
</body>

<script type="text/javascript">
	$("#myModal").modal('show');
	function addUserSure() {
		var nickname = $("#nickname").val();
		var username = $("#username1").val();
		var phone = $("#mobile1").val();
		var sex=	$("#sex_yes").prop("checked") ? true : false;
		var remark=$("#remark").val();
		var password=$("#password1").val();
		var model_title = $("#myModalLabel").text();

		var data = {
				sex:sex,
				level : level,
				state : state,
				userid : userid,
				remark:remark,
				password:password
		};
		if (userid == "" || newsid == "" || thumbcount == "" || userid == "" || newsid == "" || thumbcount == "" || remark=="" ||password=="") {
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
				$('#addUserModal').modal('hide');
			}

		})

	}

	function addAdminSure() {
		var userid = $("#userid1").val();
		var level = $("#level").val();
		var state = $("#admin_yes").prop("checked") ? true : false;

		var model_title = $("#myModalLabel1").text();

		var data = {
			level : level,
			state : state,
			userid : userid
		};
		if (userid == "" || level == "") {
			alert("请输入内容");

		} else {
			data.action = "InsertAdmin";
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
					alert("设置成功");
					location.reload();
				}
			},
			error : function(e) {
				alert("上传失败");
			},
			complete : function() {
				$('#myModal').modal('hide');
				$('#addUserModal').modal('hide');
			}

		})
	}
</script>
</html>