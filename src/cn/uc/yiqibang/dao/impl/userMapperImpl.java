package cn.uc.yiqibang.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TUser;
import cn.uc.yiqibang.beans.TUserExample;
import cn.uc.yiqibang.dao.TAdminMapper;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;


public class userMapperImpl implements TUserMapper {
	
	TAdminMapper adminDao=new adminMapperImpl();
	
	@Override
	public Result selectAllByPage(int pageNum) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("startIndex", Constants.userPageCounts*(pageNum-1));
		map.put("pageCounts", Constants.userPageCounts);
		List<TAdmin> adminlist=session.selectList(Constants.userMapper_selectAllByPage,map);
		session.close();
		if(adminlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(adminlist);
		}
		return result;
	}

	@Override
	public Result insertSelective(TUser record) {
		
		
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.insert(Constants.userMapper_insertSelective,record);
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
		TAdmin admin=new TAdmin();
		admin.settUId(id);
		Result result0=adminDao.selectByCondition(admin);
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		if(result0.getRetData()!=null){
			result.setRetCode(11);
		}else {
			
			SqlSession session=MyBatisUtils.openSession();
			int row=session.delete(Constants.userMapper_deleteByPrimaryKey,id);
			session.commit();
			session.close();
			if(row>0){
				result.setRetCode(Constants.RETCODE_SUCCESS);
				result.setRetMsg(true);
			}
			
		}
		
		return result;
		
	}

	@Override
	public Result selectAll() {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		List<TUser> userlist=session.selectList(Constants.userMapper_selectAll);
		session.close();
		if(userlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(userlist);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectByLike(String likeStr) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		List<TUser> userlist=session.selectList(Constants.userMapper_selectByLike,likeStr);
		session.close();
		if(userlist!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(userlist);
		}
		return result;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		TUser user=session.selectOne(Constants.userMapper_selectByPrimaryKey,id);
		session.close();
		if(user!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(user);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public int insert(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TUser> selectByExample(TUserExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result loginUser(TUser user) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		TUser user0=session.selectOne(Constants.userMapper_selectByNameAndPwd,user);
		session.close();
		if(user0!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(user0);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result findUserByUserName(String username) {
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		TUser user0=session.selectOne(Constants.userMapper_selectByUsername,username);
		session.close();
		if(user0!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(user0);
			result.setRetMsg(true);
		}
		return result;
	}


}
