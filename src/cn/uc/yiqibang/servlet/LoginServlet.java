package cn.uc.yiqibang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.beans.TUser;




/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username+password);
		boolean result="小明".equals(username)&&"123456".equals(password);
		if(result){
			System.out.println("登陆成功");
			response.sendRedirect("/project/index.jsp");
			TUser user=new TUser(username,password);
			request.getSession().setAttribute("loginUser", user);
		}else{
			System.out.println("登录失败");
			response.sendRedirect("/project/login.jsp");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
