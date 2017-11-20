package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import cn.uc.yiqibang.beans.TType;
import cn.uc.yiqibang.dao.TTypeMapper;
import cn.uc.yiqibang.dao.impl.newsMapperImpl;
import cn.uc.yiqibang.dao.impl.typeMapperImple;
import cn.uc.yiqibang.servlet.BaseServlet;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/TypeServlet")
public class TypeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	TTypeMapper typeDao=new typeMapperImple();
	
	public void adminGetTypeById(HttpServletRequest request,HttpServletResponse response){
		int typeId=Integer.parseInt(request.getParameter("id"));
		Result result=typeDao.selectByPrimaryKey(typeId);

		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void adminGetAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = typeDao.selectAllTypes();
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void getAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = typeDao.selectAllTypes();
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void getAllTypesCount(HttpServletRequest request,HttpServletResponse response){
		Result result=typeDao.selectAllTypes();
		List<TType> typelist=(List<TType>) result.getRetData();
		int	count=typelist.size();
		result.setRetData(count);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void adminGetTypesByLike(HttpServletRequest request,HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=typeDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void admindeleteTypesById(HttpServletRequest request,HttpServletResponse response){
	int typeid=Integer.parseInt(request.getParameter("typeid"));		
	
		
		Result result=typeDao.deleteByPrimaryKey(typeid);
		WriteResultToClient.WriteMethod(response, result);	
	}
	
	public void adminInsertTypes(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		TType type=new TType();
		type.settCreatetime(new Date());
		type.settName(name);
		Result result=typeDao.insertSelective(type);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void adminUpdateTypes(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		int typeid= Integer.parseInt(request.getParameter("typeid"));
		TType type=new TType();
		type.settCreatetime(new Date());
		type.settName(name);
		type.setId(typeid);
		Result result=typeDao.updateByPrimaryKeySelective(type);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void getPageAllData(HttpServletRequest request,HttpServletResponse response){
		
	}

}
