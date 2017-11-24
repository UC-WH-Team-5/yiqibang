<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
<link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.min.css">
<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../js/date_util.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- eEditor -->
<!-- 配置文件 -->
<script type="text/javascript" src="js/uEditer/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
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
	font-family: 华文宋体;
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
	font-family: 华文宋体;
	font-size: 12px;
	color: #e9ebed;
	text-align: left;
}

/*正文部分*/
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
	font-family: 华文宋体;
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



.news_tr>td>div {
	height: 30px;
}

.news_tr td {
	max-width: 100px;
	text-over: ellipsis;
	white-space: nowrap;
	overflow: hidden;
	font-family: 华文宋体;
	font-size: 12px;
	color: #949494;
	text-align: center;
	height: 31px;
	line-height: 31px;
	border: 1px solid #ddd;
	padding: 0;
	vertical-align: middle !important;
}

.news_tr>td>div {
	height: 35px;
}

#content .right table {
	margin: 0;
}

#content .right table>thead>tr>* {
	font-family: 华文宋体;
	font-size: 12px;
	color: #676767;
	text-align: center;
	height: 36px;
	line-height: 36px; 
	border: 1px solid #ddd;
	padding: 0;

}

#pageBox {
	position: absolute;
	bottom: 0px;
	left: 270px;
}

#pageBox nav>ul{
	margin: 0;
}


#content .right .con_header {
	width: 781px;
	height: 50px;
	background: #ededed;
}

#content .right .con_header>* {
	float: left;
	height: 30px;
	margin-top: 10px;
}

#content .right .con_header>div {
	width: 210px;
}

#content .right .con_header>div>input {
	width: 170px;
	height: 30px;
}

#content>div.container-fluid.right>div>button {
	margin-left: 450px;
	width: 60px;
}

#content .right .con_header>div>span>button {
	width: 40px;
	height: 30px;
	padding: 0;
	border-left: none;
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
		getAllTypes();
		$(".aactive").css({"background":"#161D22","color":"#E1E2E3"});
		$(".aactive>img:last-child").css("display","block");

		showPageBox("/yiqibang/NewsServlet", "getAllNewsCount");
		
	});
	
	function getPageAllData(pageNum) {
		$('#myModal').modal('show');
		$.getJSON("/yiqibang/NewsServlet", {
			action : "getPageAllNews",
			pageNum:pageNum,
		}, function(data) {
			console.log(data);
			showAllNews(data,pageNum);
		});
	}
	


	function showAllNews(data,pageNum) {
		if (data.retMsg) {
			$("#newsList_body").html("");
			var newsList = data.retData;
			for (var i = 0; i < newsList.length; i++) {
				var news = newsList[i];

				$("#newsList_body")
						.append(
								'<tr align="center" class="news_tr">' + "<td>"
										+ ((pageNum-1)*pageSize+i+1)
										+ "</td>"
										+ "<td id='type"+i+"'></td>"
										+ "<td style='width: 100px' title='"+news.nTitle+"'>"
										+ news.nTitle
										+ "</td>"
										+ "<td>"
										+ news.nSource
										+ "</td>"
										+ "<td>"
										+ news.nAuthor
										+ "</td>"
										+ "<td style='width: 200px' id='content"+i+"'>"
										+ '<div>'
										+ news.nContent
										+ '</div>'
										+ "</td>"
										+ "<td>"
										+ getStrDate(news.nCreatetime.time)
										+ "</td>"
										+ "<td>"
										+ news.nCommcount
										+ "</td>"
										+ "<td>"
										+ news.nReadcount
										+ "</td>"
										+ "<td>"
										+ (news.nIfhot ? "是" : "否")
										+ "</td>"
										+ "<td>"
										+ (news.nIfreport ? "是" : "否")
										+ "</td>"


										+ '<td class="icon_row">'
										+ '<div class="row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-cog configBtn" id="configBtn'+i+'" ></span>'
										+ '</div>'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-trash" id="deleteBtn'
										+ i + '" onclick="deleteNew(' + news.id
										+ ')"></span>' + '</div>' + '</div>'
										+ '</td>' + "</tr>");
				$("#content"+i).attr("title",$("#content"+i).text());
				getTypeById(news.tTId, i);
			}
			$(".configBtn").each(function(index) {
				$("#configBtn" + index).click(function() {
					
					var news = newsList[index];
					$('#addNewsModal').modal('show');
					$("#myModalLabel").text("修改新闻");
					$('#addNewsModal #typeid').val(news.tTId);
					$('#addNewsModal #title').val(news.nTitle);
					$('#addNewsModal #source').val(news.nSource);
					$('#addNewsModal #author').val(news.nAuthor);
					$('#newsid').val(news.id);
					var ue = UE.getEditor('editor', {
						initialFrameWidth : 700,
						initialFrameHeight : 300
					});
					ue.setContent(news.nContent);
					console.log(news);
					if(news.ifhot){
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

	function getTypeById(typeId, index) {
		$.ajax({
			url : "/yiqibang/TypeServlet",
			data : {
				action : "adminGetTypeById",
				id : typeId
			},
			timeout : 5000,
			type : "get",
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var objData = JSON.parse(data);
				if (objData.retMsg) {
					$("#type" + index).text(objData.retData.tName);
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

	function getAllTypes() {
		$.ajax({
			url : "/yiqibang/TypeServlet",
			data : {
				action : "adminGetAllTypes"
			},
			type : "get",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var jsData = JSON.parse(data);
				$("#typeid").html("");
				for (var i = 0; i < jsData.retData.length; i++) {
					var type = jsData.retData[i];
					$("#typeid").append(
							"<option value='"+type.id+"'>" + type.tName
									+ '</option>');
				}
			},
			error : function(e) {
				/* alert("类型获取异常" + e); */
			},
			complet : function(e) {
				$('#myModal').modal('hide');
			}

		})
	}

	function addNewsBtn() {
		$('#addNewsModal').modal('show');
	}
	
	function searchNewsByLike(){
		var searchTv=$("#searchTv").val();
		if(searchTv==""){
			getPageAllData(1);
		}else{

			$.ajax({
				url:"/yiqibang/NewsServlet",
				data:{
					action:"adminGetNewsByLike",
					likeStr:searchTv
				},
				type:"get",
				timeout:5000,
				beforesend : function() {
					$('#myModal').modal('show');
				},
				success:function(data){
					var datas=JSON.parse(data);
					showAllNews(datas,1);
				},
				error:function(e){
					alert("上传失败");
				},
				complet:function(){
					$('#myModal').modal('hide');
				}
			})
			
		}
	}
	
	function deleteNew(newsId){
		$.ajax({
			url:"/yiqibang/NewsServlet",
			data:{
				action : "adminDeleteNewsById",
				newsid : newsId
			},
			type:"post",
			timeout:5000,
			beforesend:function(){
				$('#myModal').modal('show');
			},
			success:function(data){
				var jsData=JSON.parse(data);
				if(jsData.retMsg){
					alert("删除成功");
					location.reload();
				}else{
					alert("删除失败");
				};
			},
			error:function(e){
				alert("上传失败");
			},
			complet:function(){
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
					<a href="admin.jsp" class="list-group-item" > <img
						src="img/public/yonghuguanli.png"> 用户管理 <img
						src="img/public/cebianlan-sanjiaoxing.png" >
					</a> <a href="#" class="list-group-item aactive" > <img
						src="img/public/xinwenguuanli.png"> 新闻管理 <img
						src="img/public/cebianlan-sanjiaoxing.png" >
					</a> <a href="comment.jsp" class="list-group-item" > <img
						src="img/public/pinglunguanli.png"> 评论管理 <img
						src="img/public/cebianlan-sanjiaoxing.png" >
					</a> <a href="#" class="list-group-item" > <img
						src="img/public/xinwenpachong.png"> 新闻爬虫 <img
						src="img/public/cebianlan-sanjiaoxing.png" >
					</a> <a href="types.jsp" class="list-group-item" > <img
						src="img/public/xinwenguanlfenlei.png"> 新闻分类管理 <img
						src="img/public/cebianlan-sanjiaoxing.png" >
					</a>
				</div>
				<img src="../web/img/logo.png">
			</div>
			<div class="container-fluid right">
				<div class="container-fluid con_header clear">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="标题/内容/时间/来源" id="searchTv">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="searchNewsByLike()">
								<img src="img/public/fangdajing.png">
							</button>
						</span>
					</div>
					<button onclick="addNewsBtn()">
						<span class="glyphicon glyphicon-plus-sign"></span>添加
					</button>
				</div>
				<table class="table table-bordered table-stripted">
					<thead>
						<tr>
							<td>序号</td>
							<td>类型</td>
							<td>标题</td>
							<td>来源</td>
							<td>作者</td>
							<td>内容</td>
							<td>时间</td>
							<td>评论</td>
							<td>浏览</td>
							<td>热点</td>
							<td>被举报</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="newsList_body">



					</tbody>
				</table>
				<div id="pageBox">
				<nav aria-label="Page navigation">
				<ul class="pagination" id="pageBtn">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>
				</div>
			</div>
		</div>
	</div>
	</div>

	<div class="modal fade" id="addNewsModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title" id="myModalLabel">添加新闻</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" >
						<div class="form-group">
							<label class="col-sm-2 control-label">类型</label>
							<div class="col-sm-8">
								<select id="typeid" name="typeid" class="form-control"></select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">标题</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="标题" value=""><input type="hidden"
									id="newsid" value="0">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">来源</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="source"
									name="source" placeholder="来源" value="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">作者</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="作者" value="">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-9">
								<div>
									<script id="editor" type="text/plain"></script>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">是否为热点</label>
							<div class="col-sm-8">
								<label class="radio-inline"> <input type="radio"
									name="ifHot" id="yes" value="true" checked>是
								</label> <label class="radio-inline"> <input type="radio"
									name="ifHot" id="no" value="false"> 否
								</label>

							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="addNewsSure()">确定</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="progress.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$("#myModal").modal('show');

	//实例化编辑器
	var ue = UE.getEditor('editor', {
		//focus时自动清空初始化时的内容
		autoClearinitialContent : true,
		//关闭字数统计
		wordCount : false,
		//关闭elementPath
		elementPathEnabled : false,
		//默认的编辑区域高度
		initialFrameWidth : 700,
		initialFrameHeight : 300
	//更多其他参数，请参考ueditor.config.js中的配置项
	});
	//添加新闻按钮点击事件
	function addNewsSure() {
		ue.fireEvent('beforeinsertimage');
		var typeid = $("#typeid").val();
		var title = $("#title").val();
		var source = $("#source").val();
		var author = $("#author").val();
		var content = ue.getContent();
		var model_title = $("#myModalLabel").text();
		var ifhot = $("#yes").prop("checked") ? true : false;
		var data = {
			typeid : typeid,
			title : title,
			source : source,
			author : author,
			content : content,
			ifhot : ifhot
		};
		if (title == "" || author == "" || source == "" || content == "") {
			alert("请输入内容");
			return;
		}
		if (model_title == "修改新闻") {
				data.newsid=$("#newsid").val();
				data.action="adminUpdateNews";
		} else {
			data.action = "adminInsertNews";
		}

		$.ajax({
			url : "/yiqibang/NewsServlet",
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
				$('#addNewsModal').modal('hide');
			}

		})

	}
</script>
</html>