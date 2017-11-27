package cn.uc.yiqibang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.dao.IVerificationCodeBiz;
import cn.uc.yiqibang.dao.impl.VerificationCodeImpl;
import cn.uc.yiqibang.utils.BaseException;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;



@WebServlet("/VerificationcodeServlet")
public class VerificationcodeServlet extends BaseServlet {
	
	private static final long serialVersionUID = 8147354908110750232L;
	IVerificationCodeBiz biz = new VerificationCodeImpl();
	
	public void searchVerificationcode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mobile = req.getParameter("mobile");

		Result result;
		try {
			result = biz.searchBaseVerificationcode(mobile);
			WriteResultToClient.WriteMethod(resp, result);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void sendVerificationCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mobile = req.getParameter("mobile");
		System.out.println(mobile);
		System.out.println("发�?�验证码---------------------------");
//		Integer type = Integer.valueOf(mobile);
		Result result;
		try {
			result = biz.addBaseVerificationcode(mobile, 1);
			WriteResultToClient.WriteMethod(resp, result);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
