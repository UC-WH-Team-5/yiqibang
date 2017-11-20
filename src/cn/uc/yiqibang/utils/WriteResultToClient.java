package cn.uc.yiqibang.utils;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class WriteResultToClient {

	public static void WriteMethod(HttpServletResponse response,Object obj){
		
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonObj=JSONObject.fromObject(obj).toString();
		out.println(jsonObj);
		out.flush();
		out.close();
		
	}
}
