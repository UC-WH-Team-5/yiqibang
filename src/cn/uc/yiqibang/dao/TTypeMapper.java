package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.beans.TType;
import cn.uc.yiqibang.beans.TTypeExample;
import cn.uc.yiqibang.utils.Result;

import java.util.List;

public interface TTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int insert(TType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    Result selectAllByPage(int pageNum); 
    
    Result insertSelective(TType record);

    Result deleteByPrimaryKey(Integer id);
    
    Result selectAll();
    
    Result updateByPrimaryKeySelective(TType record);
    
    Result selectByLike(String likeStr);
    
    Result selectByPrimaryKey(Integer id);
    
    Result selectByCondition(TType record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    List<TType> selectByExample(TTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_type
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int updateByPrimaryKey(TType record);
}