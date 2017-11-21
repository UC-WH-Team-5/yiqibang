package cn.uc.yiqibang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.TComment;
import cn.uc.yiqibang.beans.TCommentExample;
import cn.uc.yiqibang.beans.TNews;
import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class commMapperImpl implements TCommentMapper {


	@Override
	public Result deleteByCondition(TComment comm) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.commentMapper_deleteByCondition,comm);
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
		map.put("startIndex", Constants.typePageCounts*(pageNum-1));
		map.put("pageCounts", Constants.typePageCounts);
		List<TNews> news = session.selectList(Constants.commentMapper_selectAllByPage, map);
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
	public Result insertSelective(TComment record) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.insert(Constants.commentMapper_insertSelective,record);
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
	public Result deleteByPrimaryKey(Integer id) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.commentMapper_deleteByPrimaryKey,id);
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
	public Result selectAll() {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		List<TComment> commlist= session.selectList(Constants.commentMapper_selectAll);
		session.close();
		if(commlist!=null){
			result.setRetData(commlist);
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TComment record) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.commentMapper_updateByPrimaryKeySelective,record);
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
	public Result selectByLike(String likeStr) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<TComment> commList=session.selectList(Constants.commentMapper_selectByLike,likeStr);
		session.close();
		if(commList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(commList);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		TComment comm= session.selectOne(Constants.commentMapper_selectByPrimaryKey,id);
		session.close();
		if(comm!=null){
			result.setRetData(comm);
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public int insert(TComment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TComment> selectByExample(TCommentExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(TComment record) {
		// TODO Auto-generated method stub
		return 0;
	}



}
