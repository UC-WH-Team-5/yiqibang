package cn.uc.yiqibang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.dao.impl.userMapperImpl;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	TUserMapper userDao=new userMapperImpl();
	
	public void adminGetUserById(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		Result result=userDao.selectByPrimaryKey(id);
		WriteResultToClient.WriteMethod(response, result);
		
	}
	
	public void GetAllUser(HttpServletRequest request, HttpServletResponse response){
		Result result=userDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void getUserById(HttpServletRequest request, HttpServletResponse response){
		int userid=Integer.parseInt(request.getParameter("userid"));
		Result result=userDao.selectByPrimaryKey(userid);
		WriteResultToClient.WriteMethod(response, result);		
	}

}
