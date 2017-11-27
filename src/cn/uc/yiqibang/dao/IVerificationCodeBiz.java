package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.utils.BaseException;
import cn.uc.yiqibang.utils.Result;

public interface IVerificationCodeBiz {
	/**
	 * 根据手机号码和验证码类类别发送验证信�?
	 * @param mobile手机号码
	 * @param type验证码类�?
	 * @return
	 */
	public Result addBaseVerificationcode(String mobile,int type)throws BaseException;
	
	/**
	 * 根据手机号查询最近生成的验证码信�?
	 * @param mobile
	 * @return
	 */
	public Result searchBaseVerificationcode(String mobile)throws BaseException;
}
