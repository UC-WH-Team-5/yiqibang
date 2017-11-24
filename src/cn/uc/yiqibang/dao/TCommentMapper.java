package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.beans.TComment;
import cn.uc.yiqibang.beans.TCommentExample;
import cn.uc.yiqibang.beans.TType;
import cn.uc.yiqibang.utils.Result;

import java.util.List;

public interface TCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
	Result getLastCommByNewid(int newsid);
	
    Result getAllCountByNewid(int newsid);
	
	 Result selectAllByPage(int pageNum); 
	    
	 Result insertSelective(TComment record);

	 Result deleteByPrimaryKey(Integer id);
	    
	 Result selectAll();
	    
	 Result updateByPrimaryKeySelective(TComment record);
	    
	 Result selectByLike(String likeStr);
	    
	 Result selectByPrimaryKey(Integer id);
	
	
    
    Result deleteByCondition(TComment comm);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int insert(TComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    List<TComment> selectByExample(TCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbggenerated Fri Nov 10 16:23:26 CST 2017
     */
    int updateByPrimaryKey(TComment record);
}