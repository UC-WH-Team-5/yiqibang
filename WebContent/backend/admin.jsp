<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.min.css">
<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../js/date_util.js"></script>
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

.admin_tr>td>div {
	height: 30px;
}

.admin_tr td {
	max-width: 100px;
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

.admin_tr>td>div {
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
</style>
<script>
	$(function() {
		getPageAllData(1);
		getAllUser();

		$(".aactive").css({
			"background" : "#161D22",
			"color" : "#E1E2E3"
		});
		$(".aactive>img:last-child").css("display", "block");
		$(".uactive").css("background","#FFA705")

		showPageBox("/yiqibang/AdminServlet", "getAllAdminCount");

	});

	function getPageAllData(pageNum) {
		$('#myModal').modal('show');
		$.getJSON("/yiqibang/AdminServlet", {
			action : "getPageAllData",
			pageNum : pageNum,
		}, function(data) {

			showAllData(data, pageNum);
		});
	}

	function showAllData(data, pageNum) {
		if (data.retMsg) {
			$("#adminList_body").html("");
			var adminList = data.retData;
			for (var i = 0; i < adminList.length; i++) {
				var admin = adminList[i];
				console.log(admin);
				$("#adminList_body")
						.append(
								'<tr align="center" class="admin_tr">' + "<td>"
										+ ((pageNum - 1) * pageSize + i + 1)
										+ "</td>"
										+ "<td id='user"+i+"'></td>"
										+ "<td>"
										+ admin.uLevel
										+ "</td>"
										+ "<td>"
										+ (admin.uState?"可用":"不可用")
										+ "</td>"
										+ "<td id='usertime"+i+"'></td>"										
										+ '<td class="icon_row">'
										+ '<div class="row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-cog configBtn" id="configBtn'+i+'" ></span>'
										+ '</div>'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-trash" id="deleteBtn'
										+ i + '" onclick="deleteAdmin('
										+ admin.id + ')"></span>' + '</div>'
										+ '</div>' + '</td>' + "</tr>");
				$("#content" + i).attr("title", $("#content" + i).text());
				getUserById(admin.tUId, i);
				
			}
			$(".configBtn").each(function(index) {
				$("#configBtn" + index).click(function() {
					var admin = adminList[index];
					$('#addAdminModal').modal('show');
					$("#myModalLabel").text("修改管理员");
					$('#addAdminModal #userid').val(admin.tUId);
					$('#addAdminModal #level').val(admin.uLevel);
					$('#adminid').val(admin.id);
					if(admin.uState){
						$("#yes").attr("checked",true);
						$("#no").removeAttr("checked");
					}else{
						$("#no").attr("checked",true);
						$("#yes").removeAttr("checked");
					}
					

				})
			});
			$('#myModal').modal('hide');
		}
	}

	function getUserById(userId, index) {
		$.ajax({
			url : "/yiqibang/UserServlet",
			data : {
				action : "adminGetUserById",
				id : userId
			},
			timeout : 5000,
			type : "get",
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {

				var objData = JSON.parse(data);
				if (objData.retMsg) {
					$("#user" + index).text(objData.retData.uUsername);
					$("#usertime"+index).text(getStrDate(objData.retData.uCreatetime.time));
				}
			},
			error : function(e) {
				alert("类型获取异常" + e);
			},
			complet : function(e) {
				$('#myModal').modal('hide');
			}
		})
	}



	function getAllUser() {
		$.ajax({
			url : "/yiqibang/UserServlet",
			data : {
				action : "getAllUser"
			},
			type : "get",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var jsData = JSON.parse(data);
				console.log(jsData)
				$("#userid").html("");
				for (var i = 0; i < jsData.retData.length; i++) {
					var user = jsData.retData[i];
					$("#userid").append(
							"<option value='"+user.id+"'>" + user.uUsername
									+ '</option>');
				}
			},
			error : function(e) {
				alert("类型获取异常" + e); 
			},
			complet : function(e) {
				$('#myModal').modal('hide');
			}

		})
	}

	function addAdminBtn() {
		$('#addAdminModal').modal('show');
	}

	function searchAdminByLike() {
		var searchTv = $("#searchTv").val();
		if (searchTv == "") {
			getPageAllData(1);
		} else {

			$.ajax({
				url : "/yiqibang/AdminServlet",
				data : {
					action : "getAdminByLike",
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

	function deleteAdmin(adminId) {
		$.ajax({
			url : "/yiqibang/AdminServlet",
			data : {
				action : "deleteAdminById",
				adminid : adminId
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
							<li ><a href="user.jsp">用户</a></li>
							<li class="uactive"><a>管理员</a></li>
						</ul>
						<input type="text" class="form-control" placeholder="内容" id="searchTv">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="searchAdminByLike()">
								<img src="img/public/fangdajing.png">
							</button>
						</span>
					</div>
					<button onclick="addAdminBtn()">
						<span class="glyphicon glyphicon-plus-sign"></span>添加
					</button>
				</div>

				<table class="table table-bordered table-stripted">
					<thead>
						<tr>
							<td>序号</td>
							<td>用户名</td>
							<td>等级</td>
							<td>状态</td>
							<td>创建时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="adminList_body">



					</tbody>
				</table>
				<div class="pagebox" id="pageBox"></div>
			</div>
		</div>
	</div>
	</div>

	<div class="modal fade" id="addAdminModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title" id="myModalLabel">添加管理员</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
					 <div class="form-group">
							<label class="col-sm-2 control-label">用户</label>
							<div class="col-sm-8">
								<select id="userid" name="userid" class="form-control"></select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">等级</label>
							<div class="col-sm-8">
								<select id="level" name="level" class="form-control">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select><input
									type="hidden" id="adminid" value="0">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">是否可用</label>
							<div class="col-sm-8">
								<label class="radio-inline"> <input type="radio"
									name="state" id="yes" value="true" checked>可用
								</label> <label class="radio-inline"> <input type="radio"
									name="state" id="no" value="false"> 不可用
								</label>

							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="addAdminSure()">确定</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="progress.jsp"></jsp:include>
</body>

<script type="text/javascript">
	$("#myModal").modal('show');	
	function addAdminSure() {
		var userid = $("#userid").val();
		var level= $("#level").val();
		var state = $("#yes").prop("checked") ? true : false;
		var model_title = $("#myModalLabel").text();
		
		var data = {
				level : level,
				state : state,
				userid: userid
		};
		if (userid == "" || level == "") {
			alert("请输入内容");
			return;
		}
		if (model_title == "修改管理员") {
			data.adminid = $("#adminid").val();
			data.action = "adminUpdateAdmin";
		} else {
			/* data.action = "adminInsertAdmin"; */
			alert("请先注册用户");
		}

		$.ajax({
			url : "/yiqibang/AdminServlet",
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

	}
</script>
</html>