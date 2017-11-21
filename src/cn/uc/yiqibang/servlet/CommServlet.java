package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.beans.TComment;
import cn.uc.yiqibang.beans.TNews;
import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.dao.impl.commMapperImpl;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;



/**
 * Servlet implementation class CommServlet
 */
@WebServlet("/CommServlet")
public class CommServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       TCommentMapper commDao=new commMapperImpl();
	
	
	public void getAllCommCount(HttpServletRequest request,HttpServletResponse response){
		Result result=commDao.selectAll();
		List<TComment> commlist=(List<TComment>) result.getRetData();
		int commCount=commlist.size();
		result.setRetData(commCount);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void getPageAllData(HttpServletRequest request,HttpServletResponse response){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Result result=commDao.selectAllByPage(pageNum);
		WriteResultToClient.WriteMethod(response, result);			
	}
	
	public void adminGetCommByLike(HttpServletRequest request, HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=commDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void admindeleteCommById(HttpServletRequest request, HttpServletResponse response){
		int commid=Integer.parseInt(request.getParameter("commid"));					
		Result result=commDao.deleteByPrimaryKey(commid);
		WriteResultToClient.WriteMethod(response, result);		
	}
}
