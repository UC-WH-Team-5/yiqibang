package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TUser;
import cn.uc.yiqibang.dao.TAdminMapper;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.dao.impl.adminMapperImpl;
import cn.uc.yiqibang.dao.impl.userMapperImpl;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	TAdminMapper adminDao=new adminMapperImpl();
 	TUserMapper userDao=new userMapperImpl();
/*	public void adminGetTypeById(HttpServletRequest request,HttpServletResponse response){
		int adminId=Integer.parseInt(request.getParameter("id"));
		Result result=adminDao.selectByPrimaryKey(adminId);

		WriteResultToClient.WriteMethod(response, result);		
	}*/
	
/*	public void adminGetAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = adminDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}*/
	
/*	public void getAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = adminDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}*/
	
	public void getAllAdminCount(HttpServletRequest request,HttpServletResponse response){
		Result result=adminDao.selectAll();
		List<TAdmin> adminlist=(List<TAdmin>) result.getRetData();
		int	count=adminlist.size();
		result.setRetData(count);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void getAdminByLike(HttpServletRequest request,HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=adminDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void deleteAdminById(HttpServletRequest request,HttpServletResponse response){
		int adminid=Integer.parseInt(request.getParameter("adminid"));
		Result result0=adminDao.selectByPrimaryKey(adminid);
		TAdmin admin=(TAdmin) result0.getRetData();
		Result rs=userDao.selectByPrimaryKey(admin.gettUId());
		TUser user=(TUser) rs.getRetData();
		Result rs1=userDao.deleteByPrimaryKey(user.getId());		
		Result result=adminDao.deleteByPrimaryKey(adminid);
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void InsertAdmin(HttpServletRequest request,HttpServletResponse response){
		
		
		
		int level=Integer.parseInt(request.getParameter("level"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		boolean state=Boolean.parseBoolean(request.getParameter("state"));
		
		
		
		TAdmin admin=new TAdmin();
		admin.settUId(userid);
		admin.setuLevel(level);
		admin.setuState(state);
		
		Result result=adminDao.insertSelective(admin);
		WriteResultToClient.WriteMethod(response, result);
		
		
	}
	
	public void adminUpdateAdmin(HttpServletRequest request,HttpServletResponse response){
		int adminid= Integer.parseInt(request.getParameter("adminid"));		
		int level=Integer.parseInt(request.getParameter("level"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		boolean state=Boolean.parseBoolean(request.getParameter("state"));
		
		
		
		TAdmin admin=new TAdmin();
		admin.settUId(userid);
		admin.setuLevel(level);
		admin.setuState(state);
		admin.setId(adminid);
		Result result=adminDao.updateByPrimaryKeySelective(admin);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void getPageAllData(HttpServletRequest request,HttpServletResponse response){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Result result=adminDao.selectAllByPage(pageNum);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void loginAdmin(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		String validateCode = request.getParameter("userValidate");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("ccode");
		Result result = new Result();
		if (validateCode.equals(code)) {
			TUser user = new TUser();
			user.setuUsername(userName);
			user.setuPassword(userPwd);
			Result result0 = userDao.loginUser(user);
			System.out.println(result0);
			if (result0.isRetMsg()) {
				TUser userLogin= (TUser) result0.getRetData();
				System.out.println(userLogin);
				result= adminDao.loginAdmin(userLogin.getId());
				TAdmin admin=(TAdmin) result.getRetData();
				System.out.println(result);
				if (result.isRetMsg()) {
						//使用session保存管理员登录id,识别状态
					request.getSession().setAttribute("adminId",admin.getId());
				}
			} else {
				result.setRetMsg(false);
				result.setRetCode(1002);
			}
		} else {
			result.setRetCode(1001);
			result.setRetMsg(false);
		}
		WriteResultToClient.WriteMethod(response, result);
	}
	

}
