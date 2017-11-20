package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.TPic;
import cn.uc.yiqibang.beans.TPicExample;
import cn.uc.yiqibang.dao.TPicMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class picMapperImpl implements TPicMapper {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TPic> selectByExample(TPicExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPic selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TPic record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result deleteByCondition(TPic pic) {
		
		Result result=new Result();
		result.setRetCode(Constants.RETCODE_FAIL);
		result.setRetMsg(false);
		SqlSession session=MyBatisUtils.openSession();
		int row=session.delete(Constants.picMapper_deleteByCondition,pic);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

}
