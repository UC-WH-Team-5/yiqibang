package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sun.corba.se.pept.transport.ContactInfo;

import cn.uc.yiqibang.beans.TNews;
import cn.uc.yiqibang.beans.TType;
import cn.uc.yiqibang.beans.TTypeExample;
import cn.uc.yiqibang.dao.TNewsMapper;
import cn.uc.yiqibang.dao.TTypeMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class typeMapperImple implements TTypeMapper {
	TNewsMapper newsDao=new newsMapperImpl();

	@Override
	public
	Result deleteByPrimaryKey(Integer id) {
		TNews news=new TNews();
		news.settTId(id);
		newsDao.deleteByCondition(news);
		
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.delete(Constants.typeMapper_deleteByPrimaryKey,id);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public
	int insert(TType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result insertSelective(TType record) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.typeMapper_insertSelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public List<TType> selectByExample(TTypeExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public	Result selectByPrimaryKey(Integer id) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		TType type=session.selectOne(Constants.typeMapper_selectByPrimaryKey,id);
		
		if(type!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(type);
			result.setRetMsg(true);
		}else {
			result.setRetCode(Constants.RETCODE_FAIL);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TType record) {
	
		
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.update(Constants.typeMapper_updateByPrimaryKeySelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public int updateByPrimaryKey(TType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result selectAllTypes() {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<TType> typeList=session.selectList(Constants.typeMapper_selectAll);
		session.close();
		if(typeList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(typeList);
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
		List<TNews> newsList=session.selectList(Constants.typeMapper_selectByLike,likeStr);
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

}
