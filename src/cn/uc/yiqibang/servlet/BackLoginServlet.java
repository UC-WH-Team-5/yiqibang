package cn.uc.yiqibang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackLoginServlet
 */
@WebServlet("/BackLoginServlet")
public class BackLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void login(HttpServletRequest request, HttpServletResponse response){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String code=request.getParameter("code");
		
//		if(
	}
	

}
