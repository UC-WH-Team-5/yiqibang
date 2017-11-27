package cn.uc.yiqibang.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.uc.yiqibang.beans.BaseVerificationCode;
import cn.uc.yiqibang.dao.IVerificationCodeBiz;
import cn.uc.yiqibang.utils.BaseException;
import cn.uc.yiqibang.utils.Result;



public class VerificationCodeImpl implements IVerificationCodeBiz {

	@Override
	public Result addBaseVerificationcode(String mobile,int type) throws BaseException {
		 Result result = new Result();
//		Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(new Date());
//        rightNow.set(Calendar.MINUTE,rightNow.get(Calendar.MINUTE)+10);
//        Date expirationtime=rightNow.getTime();
//        
//        BaseVerificationCode code = new BaseVerificationCode();
//        code.setMobile(mobile);
//        //生成验证码的随机�?
//        String vCode = Utils.getRandomVCode();
//        code.setCode(vCode);
//        code.setType((short) type);
//        code.setCreatetime(new Date());
//        code.setExpirationtime(expirationtime);
//        //给手机发送短�?
//        SmsHelper.sendMessage(mobile, vCode);
//        
//        long id = JDBCUtils.insert(Mapping.baseVerificationCodeMapper_insert, code);
//        
//       
//        if (id>0) {
//			result.setRetCode(Constant.CODE_0);
//			result.setRetMsg(true);
//			result.setRetData(code);
//		}else{
//			result.setRetCode(Constant.CODE_2000);
//			result.setRetMsg(false);
//		}
        return result;
	}

	@Override
	public Result searchBaseVerificationcode(String mobile) throws BaseException {
		Result result = new Result();
		/*List<BaseVerificationCode> list = JDBCUtils.selectList(Mapping.baseVerificationCodeMapper_selectByMobile,mobile);
		if (list==null) {
			result.setRetCode(Constant.CODE_1200);
			result.setRetMsg(false);
		}else if (list!=null && list.size()==0) {
			result.setRetCode(Constant.CODE_2100);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constant.CODE_0);
			result.setRetMsg(true);
			result.setRetData(list.get(0));
		}*/
		return result;
	}

}
