package cn.uc.yiqibang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TAdminExample;
import cn.uc.yiqibang.dao.TAdminMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class adminMapperImpl implements TAdminMapper {

	@Override
	public Result selectAllByPage(int pageNum) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("startIndex", Constants.adminPageCounts*(pageNum-1));
		map.put("pageCounts", Constants.adminPageCounts);
		List<TAdmin> adminlist=session.selectList(Constants.adminMapper_selectAllByPage,map);
		session.close();
		if(adminlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(adminlist);
		}
		return result;
	}

	@Override
	public Result insertSelective(TAdmin record) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.adminMapper_insertSelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		
		return result;
	}

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.delete(Constants.adminMapper_deleteByPrimaryKey,id);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		
		return result;
	}

	@Override
	public Result selectAll() {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		List<TAdmin> adminlist=session.selectList(Constants.adminMapper_selectAll);
		session.close();
		if(adminlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(adminlist);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TAdmin record) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.update(Constants.adminMapper_updateByPrimaryKeySelective,record);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		
		return result;
	}

	@Override
	public Result selectByLike(String likeStr) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		List<TAdmin> adminlist=session.selectList(Constants.adminMapper_selectByLike,likeStr);
		session.close();
		if(adminlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(adminlist);
		}
		return result;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		TAdmin admin=session.selectOne(Constants.adminMapper_selectByPrimaryKey,id);
		session.close();
		if(admin!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(admin);
		}
		return result;
	}

	@Override
	public Result selectByCondition(TAdmin record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(TAdmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TAdmin> selectByExample(TAdminExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(TAdmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result loginAdmin(int userid) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		TAdmin admin=session.selectOne(Constants.adminMapper_selectByUserId,userid);
		if(admin!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(admin);
			result.setRetMsg(true);
		}
		return result;
		
	}

}
