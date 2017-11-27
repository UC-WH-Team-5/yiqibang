package cn.uc.yiqibang.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.uc.yiqibang.beans.TNews;

import cn.uc.yiqibang.dao.TNewsMapper;
import cn.uc.yiqibang.dao.impl.newsMapperImpl;
import cn.uc.yiqibang.utils.ImgUtil;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	TNewsMapper newsDao=new newsMapperImpl();
	
	public void getAllNews(HttpServletRequest request, HttpServletResponse response){
		Result result=newsDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void adminGetAllNews(HttpServletRequest request, HttpServletResponse response){
		Result result=newsDao.selectAll();
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	
	public void adminInsertNews(HttpServletRequest request, HttpServletResponse response){
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		String title=request.getParameter("title");
		String source=request.getParameter("source");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String editorValue=request.getParameter("editorValue");
		boolean ifhot=Boolean.parseBoolean(request.getParameter("ifhot"));
		TNews record=new TNews();
		 List<String> list = ImgUtil.getImageSrc(content);  
		 if (list.size() > 0) {
		 String picturePath = ImgUtil.listToString(list, ',');
		 record.setnPics(picturePath);
		 }
		record.settTId(typeid);
		record.setnTitle(title);
		record.setnContent(editorValue);
		record.setnSource(source);
		record.setnAuthor(author);
		record.setnContent(content);
		record.setnCreatetime(new Date());
		record.setnIfhot(ifhot);
		Result result=newsDao.insertSelective(record);
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void adminUpdateNews(HttpServletRequest request, HttpServletResponse response){
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		String title=request.getParameter("title");
		String source=request.getParameter("source");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String editorValue=request.getParameter("editorValue");
		boolean ifhot=Boolean.parseBoolean(request.getParameter("ifhot"));
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		
		TNews record=new TNews();
		
		//��content�����ȡͼƬ�б�
		 List<String> list = ImgUtil.getImageSrc(content); 
			if (list.size() > 0) {
		 String picturePath = ImgUtil.listToString(list, ',');
		 record.setnPics(picturePath);
			}
		
		record.settTId(typeid);
		record.setnTitle(title);
		
		record.setnContent(editorValue);
		record.setnSource(source);
		record.setnAuthor(author);
		record.setnContent(content);
		record.setnCreatetime(new Date());
		record.setnIfhot(ifhot);
		record.setId(newsid);
		Result result=newsDao.updateByPrimaryKeySelective(record);
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void adminGetNewsByLike(HttpServletRequest request, HttpServletResponse response){
		String likeStr=request.getParameter("likeStr");
		Result result=newsDao.selectByLike("%"+likeStr+"%");
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void adminDeleteNewsById(HttpServletRequest request, HttpServletResponse response){
		int newsid=Integer.parseInt(request.getParameter("newsid"));		
	
		
		Result result=newsDao.deleteByPrimaryKey(newsid);
		WriteResultToClient.WriteMethod(response, result);		
	}
	
	public void getNewsByTypeId(HttpServletRequest request,HttpServletResponse response){
		int typeid=Integer.parseInt(request.getParameter("typeid"));
		Result result = newsDao.selectNewsByTypeid(typeid);
		WriteResultToClient.WriteMethod(response, result);
		
	}
	
	public void getPageAllNews(HttpServletRequest request,HttpServletResponse response){
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Result result=newsDao.selectAllByPage(pageNum);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void getAllNewsCount(HttpServletRequest request,HttpServletResponse response){
		Result result=newsDao.selectAll();
		List<TNews> newslist=(List<TNews>) result.getRetData();
		int newsCount=newslist.size();
		result.setRetData(newsCount);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void adminGetNewsById(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		Result result=newsDao.selectByPrimaryKey(id);
		WriteResultToClient.WriteMethod(response, result);
	}
	
	public void updateNewsViewCount(HttpServletRequest request,HttpServletResponse response){
		int newId = Integer.parseInt(request.getParameter("id"));
		String viewCount = request.getParameter("viewCount");
		
		TNews news = new TNews();
		news.setId(newId);
		news.setnReadcount(Integer.parseInt(viewCount));
		Result result = newsDao.updateNewsViewCount(news);
		if (result.isRetMsg()) {
			// �½�cookie �ͻ�������˱��浱ǰ�û���id
			// key-value��ʽ key-loginuser value-��ǰ�û���id
			Cookie cookie = new Cookie("isFirst","1");
			// ���ÿͻ���cookie
			response.addCookie(cookie);
		}
		WriteResultToClient.WriteMethod(response, result);
	}

	


}
