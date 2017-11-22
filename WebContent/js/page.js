    var pageNo = 1; //当前页
	var pageSize = 5;//每页显示数据条数
	var pageCount = 1; //总页数
	var itemCount = 0; //总记录数
	var midPage = 3;//中间页
	
	$(function() {
		//初始化页码标签盒
		$("#pageBox").html('<nav aria-label="Page navigation">'
				+'<ul class="pagination" id="pageBtn">'
				+'<li class="first_page"><a href="#" aria-label="Previous">'
						+'<span aria-hidden="true">首页</span>'
				+'</a></li>'
				+'<li class="nav_btn first_nav"><a href="#"'
					+'aria-label="Previous"> <span aria-hidden="true">&laquo;</span>'
				+'</a></li>'
				+'<li class="nav_number active"><a href="#">1</a></li>'
				+'<li class="nav_number"><a href="#">2</a></li>'
				+'<li class="nav_number"><a href="#">3</a></li>'
				+'<li class="nav_number"><a href="#">4</a></li>'
				+'<li class="nav_number"><a href="#">5</a></li>'
				+'<li class="nav_btn last_nav"><a href="#" aria-label="Next">'
					+'<span aria-hidden="true">&raquo;</span>'
				+'</a></li>'
				+'<li class="last_page"><a href="#" aria-label="Next"> <span'
						+'aria-hidden="true">尾页</span>'
				+'</a></li>'
			+'</ul>');
		// 首页点击事件
		$(".first_page").click(function() {
			pageNo = 1;
			midPage = 3;
			changePage();
			getPageAllData(pageNo);
			showPageView($(".nav_number").first());
		});
		// 尾页点击事件
		$(".last_page").click(function() {
			pageNo = pageCount;
			if (pageCount > 5) {
				midPage = pageCount - 2;
			} else {
				midPage = 3;
			}
			changePage();
			getPageAllData(pageNo);
			showPageView($(".nav_number").last());
		});
		// 点击前一页按钮事件
		$(".first_nav").click(function() {
			if (pageNo > 1) {
				pageNo--;
				if (midPage - 2 > 1) {
					midPage--;
					changePage();
				}
				getPageAllData(pageNo);
				var prevBox = $(".nav_number.active").prev();
				showPageView(prevBox);
			}
		});
		// 点击后一页按钮事件
		$(".last_nav").click(function() {
			if (pageNo < pageCount) {
				pageNo++;
				if (midPage + 2 < pageCount) {
					midPage++;
					changePage();
				}
				getPageAllData(pageNo);
				var nextBox = $(".nav_number.active").next();
				showPageView(nextBox);
			}
		});
		//页码数点击事件
		$(".nav_number").click(function() {
			pageNo = Number($(this).text());
			if (pageNo <= 3) {
				midPage = 3;
			} else if (pageNo >= pageCount - 2) {
				midPage = pageCount - 2;
			} else {
				midPage = pageNo;
			}
			changePage();
			getPageAllData(pageNo);
			showPageView($(this));
		});
	});
	
	
	function showPageView(showDiv) {
		if (showDiv != null) {
			$(".nav_number").removeClass("active");
			$(".nav_number").each(function(index) {
				if ($(".nav_number").eq(index).text() == pageNo) {
					$(".nav_number").eq(index).addClass("active");
				}
			})

		}
	}
	
	
/*	function showPageView(showDiv) {
		if (showDiv != null) {
			$(".nav_number").removeClass("active");
			$(".nav_number").each(function(index) {
				if ($(".nav_number").eq(index).text() == pageNo) {
					$(".nav_number").eq(index).addClass("active");
				}
			})

		}
	}
*/
	function showPageBox(url,action) {
		$.ajax({
			url : url,//请求url地址
			data : { //请求参数对象
				action : action
			},
			timeout : 5000,//请求超时时间，以ms为单位
			type : "get",//请求方式
			beforesend : function() { //请求开始发送之前的回掉方法
				$('#MyModal').modal('show');
			},
			success : function(data) {//请求成功回掉函数
				var objData = JSON.parse(data);
				itemCount = objData.retData;
				pageCount = Math.ceil(Number(itemCount) / pageSize);
				/*$("#page_count").text(pageCount);*/
				//设置中间页
				if (pageCount < 5) {
					$(".nav_number").each(function(index) {
						if ((index + 1) > pageCount) {
							$(".nav_number").eq(index).css("display", "none");
						}
					});
				}
				if (pageNo < 3) {
					midPage = 3;
				} else if (midPage + 2 > pageCount) {
					midPage = midPage;
				} else {
					midPage = pageNo;
				}
				changePage();
			},
			error : function(e) {//请求失败回掉函数
				/*alert("类型获取异常" + e);*/
			},
			complete : function() {//请求完成时候的回调函数
				$('#MyModal').modal('hide');
			}
		});
	}
	//重置页码函数
	//改变底部页码导航
	function changePage() {
		$(".nav_number").eq(0).find("a").text(midPage - 2);
		$(".nav_number").eq(1).find("a").text(midPage - 1);
		$(".nav_number").eq(2).find("a").text(midPage);
		$(".nav_number").eq(3).find("a").text(midPage + 1);
		$(".nav_number").eq(4).find("a").text(midPage + 2);
	}