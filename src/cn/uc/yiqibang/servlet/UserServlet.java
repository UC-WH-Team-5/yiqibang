package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TUser;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.dao.impl.userMapperImpl;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.CookieUtils;
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
	
	public void getAllUser(HttpServletRequest request, HttpServletResponse response){
		Result result=userDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}

	
	public void getUserById(HttpServletRequest request, HttpServletResponse response){
		int userid=Integer.parseInt(request.getParameter("userid"));
		Result result=userDao.selectByPrimaryKey(userid);
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void loginUser(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		
		String password=request.getParameter("password");
		TUser user=new TUser();
		user.setuUsername(username);
		user.setuPassword(password);
		Result result = userDao.loginUser(user);
		if(result.getRetCode()==0){
			// 新建cookie 客户浏览器端保存当前用户的id
			// key-value格式 key-loginuser value-当前用户的id
			Cookie cookie = new Cookie("loginuser", ((TUser)result.getRetData()).getId() + "");
			// 设置客户端cookie
			response.addCookie(cookie);
		}
		
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void logoutUser(HttpServletRequest request, HttpServletResponse response){

		CookieUtils.removeCookieByName("loginuser", request, response);
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_SUCCESS);
		result.setRetMsg(true);
		WriteResultToClient.WriteMethod(response, result);
		
	}
	
	public void registerUserByMobile(HttpServletRequest request, HttpServletResponse response){
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		
		String username = request.getParameter("username");
		Result result0 = userDao.findUserByUserName(username);
		if(result0.getRetCode()==0){
			WriteResultToClient.WriteMethod(response, result);
		}else {
			String bindphone = request.getParameter("bindphone");
			    	TUser user = new TUser();
					user.setuUsername(username);
					user.setuBindtel(bindphone);															
					String nickname = request.getParameter("nickname");
					user.setuNickname(nickname);										
					String password = request.getParameter("password");
					user.setuPassword(password);
					String headimg=request.getParameter("headimg");
					user.setuHeading(headimg);
					boolean sex=Boolean.parseBoolean(request.getParameter("sex"));
					user.setuSex(sex);
					String remark=request.getParameter("remark");
					user.setuState(true);				
					user.setuCreatetime(new Date());	
					user.setuUpdate(new Date());
					user.setuBirthday(new Date());
					result = userDao.insertSelective(user);					
					WriteResultToClient.WriteMethod(response, result);
			    }	
	}
	
	public void getPageAllData(HttpServletRequest request,HttpServletResponse response){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Result result=userDao.selectAllByPage(pageNum);
		WriteResultToClient.WriteMethod(response, result);
	}
	public void userGetAdminByLike(HttpServletRequest request,HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=userDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);	
	}
	public void deleteUserById(HttpServletRequest request,HttpServletResponse response){
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		Result result=userDao.deleteByPrimaryKey(userid);
		
		WriteResultToClient.WriteMethod(response, result);	
	}
	public void getAllUserCount(HttpServletRequest request,HttpServletResponse response){
		Result result=userDao.selectAll();
		List<TUser> userlist=(List<TUser>) result.getRetData();
		int	count=userlist.size();
		result.setRetData(count);
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void findUserByUserName(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		Result result=userDao.findUserByUserName(username);

		WriteResultToClient.WriteMethod(response, result);	
	}
	

	
		

	
	
	
}
