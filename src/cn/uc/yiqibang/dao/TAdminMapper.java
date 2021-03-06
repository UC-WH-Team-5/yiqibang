package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.beans.TAdmin;
import cn.uc.yiqibang.beans.TAdminExample;
import cn.uc.yiqibang.beans.TType;
import cn.uc.yiqibang.utils.Result;

import java.util.List;

public interface TAdminMapper {
	
	Result loginAdmin(int userid);
    
	Result selectAllByPage(int pageNum); 
    
    Result insertSelective(TAdmin record);

    Result deleteByPrimaryKey(Integer id);
    
    Result selectAll();
    
    Result updateByPrimaryKeySelective(TAdmin record);
    
    Result selectByLike(String likeStr);
    
    Result selectByPrimaryKey(Integer id);
    
    Result selectByCondition(TAdmin record);
	
	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int insert(TAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    List<TAdmin> selectByExample(TAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int updateByPrimaryKey(TAdmin record);
}