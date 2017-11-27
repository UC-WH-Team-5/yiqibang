package cn.uc.yiqibang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.TComment;
import cn.uc.yiqibang.beans.TNews;
import cn.uc.yiqibang.beans.TNewsExample;
import cn.uc.yiqibang.beans.TPic;
import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.dao.TNewsMapper;
import cn.uc.yiqibang.dao.TPicMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;


public class newsMapperImpl implements TNewsMapper {


	TCommentMapper commDao= new commMapperImpl();
	
	@Override
	public Result selectAll() {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<TNews> newsList=session.selectList(Constants.newsMapper_selectAll);
		session.close();
		if(newsList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(newsList);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
		
	}

	@Override
	public Result deleteByPrimaryKey(Integer id) {

		TComment comment=new TComment();
		comment.settNId(id);
		commDao.deleteByCondition(comment);
		
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.delete(Constants.newsMapper_deleteByPrimaryKey,id);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		
		return result;
	}

	@Override
	public Result insert(TNews news) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.newsMapper_insert,news);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(news);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		
		return result;
	}

	@Override
	public Result insertSelective(TNews record) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.newsMapper_insertSelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(record);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public List<TNews> selectByExampleWithBLOBs(TNewsExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TNews> selectByExample(TNewsExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		TNews news=session.selectOne(Constants.newsMapper_selectByPrimaryKey,id);
		session.close();
		if(news!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TNews record) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.update(Constants.newsMapper_updateByPrimaryKeySelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(record);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(TNews record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TNews record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result selectByLike(String likeStr) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<TNews> newsList=session.selectList(Constants.newsMapper_selectByLike,likeStr);
		session.close();
		if(newsList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(newsList);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result selectNewsByTypeid(int typeid) {
		Result result= new Result();
		result.setRetMsg(false);
		result.setRetCode(Constants.RETCODE_FAIL);
		SqlSession session = MyBatisUtils.openSession();
		List<TNews> news = session.selectList(Constants.newsMapper_selectByTypeId, typeid);
		session.close();
		if (news!=null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}
		return result;
	}

	@Override
	public Result deleteByCondition(TNews news) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.delete(Constants.newsMapper_deleteByCondition,news);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);

			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		
		return result;
	}

	@Override
	public Result selectAllByPage(int pageNum) {
		Result result=new Result();
		
		SqlSession session=MyBatisUtils.openSession();
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("startIndex", Constants.newsPageCounts*(pageNum-1));
		map.put("pageCounts", Constants.newsPageCounts);
		List<TNews> news = session.selectList(Constants.newsMapper_selectAllByPage, map);
		session.close();
		if (news!=null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}else {
			result.setRetMsg(false);
			result.setRetCode(Constants.RETCODE_FAIL);
		}
		return result;
	}

	@Override
	public Result updateByCondition(TNews record) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.update(Constants.newsMapper_updateByCondition,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(record);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result updateNewsViewCount(TNews record) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row=session.update(Constants.newsMapper_updateNewsViewCount,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(record);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	



}
