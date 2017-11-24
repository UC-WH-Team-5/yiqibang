package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.TUser;
import cn.uc.yiqibang.beans.TUserExample;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class userMapperImpl implements TUserMapper {

	@Override
	public Result selectAllByPage(int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result insertSelective(TUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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

}
