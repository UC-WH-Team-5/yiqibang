package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TUser;
import cn.uc.yiqibang.dao.TAdminMapper;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.dao.impl.adminMapperImpl;
import cn.uc.yiqibang.dao.impl.userMapperImpl;
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
	
/*	public void adminGetAdminByLike(HttpServletRequest request,HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=adminDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);	
	}
	*/
	public void admindeleteAdminById(HttpServletRequest request,HttpServletResponse response){
		int adminid=Integer.parseInt(request.getParameter("adminid"));					
		Result result=adminDao.deleteByPrimaryKey(adminid);
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void adminInsertAdmin(HttpServletRequest request,HttpServletResponse response){
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
	

}
