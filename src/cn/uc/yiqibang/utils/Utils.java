package cn.uc.yiqibang.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Utils {
	private static final double EARTH_RADIUS = 6378137;// 赤道半径(单位m)

	/**
	 * 格式化并输出json到流
	 * 
	 * @param request
	 * @param response
	 * @param jsonMap
	 *            返回输出json
	 * @return
	 */
	public static void outputJson(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> jsonMap) {
		try {
			response.setContentType("text/plain");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());

			JSONObject resultJSON = JSONObject.fromObject(jsonMap, jsonConfig); // 根据�?要拼装json
			// String jsonpCallback = request.getParameter("jsonpCallback");//
			// 客户端请求参�?
			String result = resultJSON.toString();
			result = result.replaceAll("\n", "");
			PrintWriter out = response.getWriter();
			out.println(result);// 返回jsonp格式数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getHour(double mm) {
		double hour = 60;

		return (int) Math.ceil(mm / hour);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(int yyyy, int mm, int dd, int HH) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			String strdate = yyyy + "-" + mm + "-" + dd + " " + HH + ":00:00";
			date = format.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String outputString(Map<String, Object> jsonMap) {

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());

		JSONObject resultJSON = JSONObject.fromObject(jsonMap, jsonConfig); // 根据�?要拼装json
		// String jsonpCallback = request.getParameter("jsonpCallback");//
		// 客户端请求参�?
		String result = resultJSON.toString();
		result = result.replaceAll("\n", "");

		return result;
	}

	

	public static Date getNextMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 3);
		return calendar.getTime();
	}

	public static Date getNextMonth6() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 6);
		return calendar.getTime();
	}

	public static Date getDateByDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * 创建随机�?
	 * 
	 * @return
	 */
	public static String getRandomVCode() {
		String str = "";
		str += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);
		}
		return str;
	}

	public static Integer getAmount() {
		String str = "";
		str += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 1; i++) {
			str += (int) (Math.random() * 10);
		}

		Integer amount = Integer.parseInt(str);

		if (amount < 10) {
			return (10 - amount) + amount;
		} else {
			return Integer.parseInt(str);
		}

	}
	/**
	 * 获取未来的日�?
	 * 1为明天的日期2为后天日期以此类�?
	 * @return
	 */
	public static String getFutureDay(int days) {

		if (days == 0) {
			return "";
		}

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);

		return sf.format(c.getTime());
	}
	/**
	 * 获取未来的日�?
	 * 1为今天的日期2为明天日期以此类�?
	 * @return
	 */
	public static String getFutureDay2(int days) {

		if (days == 0) {
			return "";
		}

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days-1);

		return sf.format(c.getTime());
	}
	
	public static List<String> getFutureDays(int days) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMdd");

		List<String> futureDays = new ArrayList<String>();

		for (int i = 0; i < days; i++) {

			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, i + 1);
			futureDays.add(sf.format(c.getTime()));
		}

		return futureDays;
	}

	/**
	 * 判断验证码是否超�?
	 * 
	 * @param expirationtime
	 * @return true：超�?
	 */
	public static boolean checkVCodeDate(Date expirationtime) {

		long between = (expirationtime.getTime() - new Date().getTime()) / 1000;// 除以1000是为了转换成�?
		long minute = between % 3600 / 60;
		if (minute > 10) {
			return true;
		}

		return false;
	}

	public static String getYYYYMMDDhhmmss() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 获取年份
		int month = cal.get(Calendar.MONTH) + 1;// 获取月份
		int day = cal.get(Calendar.DATE);// 获取�?
		int hour = cal.get(Calendar.HOUR);// 小时
		int minute = cal.get(Calendar.MINUTE);// �?
		int second = cal.get(Calendar.SECOND);// �?

		return "" + year + month + day + hour + minute + second;

	}

	public static String getYYYYMMDD() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 获取年份
		int month = cal.get(Calendar.MONTH) + 1;// 获取月份
		int day = cal.get(Calendar.DATE);// 获取�?

		return "" + year + month + day;

	}

	public static boolean checkNull(Object val) {

		if (null == val || val.toString().length() == 0) {
			return true;
		}
		return false;
	}

	public static String dateConvertString(Date date) {
		if (null == date) {
			return "";
		}

		String sdate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
				.format(date);
		return sdate;
	}

	public static String dateToString(Date date) {

		if (null == date) {
			return "";
		}

		String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
		return sdate;
	}
	
	/**
	 * 转化为弧�?(rad)
	 * */
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 基于余弦定理求两经纬度距�?
	 * 
	 * @param lon1
	 *            第一点的精度
	 * @param lat1
	 *            第一点的纬度
	 * @param lon2
	 *            第二点的精度
	 * @param lat3
	 *            第二点的纬度
	 * @return 返回的距离，单位km
	 * */
	public static String LantitudeLongitudeDist(double lon1, double lat1,
			double lon2, double lat2) {
		String result = "-1";
		try {
			double radLat1 = rad(lat1);
			double radLat2 = rad(lat2);

			double radLon1 = rad(lon1);
			double radLon2 = rad(lon2);

			if (radLat1 < 0)
				radLat1 = Math.PI / 2 + Math.abs(radLat1);// south
			if (radLat1 > 0)
				radLat1 = Math.PI / 2 - Math.abs(radLat1);// north
			if (radLon1 < 0)
				radLon1 = Math.PI * 2 - Math.abs(radLon1);// west
			if (radLat2 < 0)
				radLat2 = Math.PI / 2 + Math.abs(radLat2);// south
			if (radLat2 > 0)
				radLat2 = Math.PI / 2 - Math.abs(radLat2);// north
			if (radLon2 < 0)
				radLon2 = Math.PI * 2 - Math.abs(radLon2);// west
			double x1 = EARTH_RADIUS * Math.cos(radLon1) * Math.sin(radLat1);
			double y1 = EARTH_RADIUS * Math.sin(radLon1) * Math.sin(radLat1);
			double z1 = EARTH_RADIUS * Math.cos(radLat1);

			double x2 = EARTH_RADIUS * Math.cos(radLon2) * Math.sin(radLat2);
			double y2 = EARTH_RADIUS * Math.sin(radLon2) * Math.sin(radLat2);
			double z2 = EARTH_RADIUS * Math.cos(radLat2);

			double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
					+ (z1 - z2) * (z1 - z2));
			// 余弦定理求夹�?
			double theta = Math.acos((EARTH_RADIUS * EARTH_RADIUS
					+ EARTH_RADIUS * EARTH_RADIUS - d * d)
					/ (2 * EARTH_RADIUS * EARTH_RADIUS));
			DecimalFormat df = new DecimalFormat("######0.00");
			// �?
			String dist = df.format(theta * EARTH_RADIUS);
			// 千米
			double km = Double.parseDouble(dist) / 1000;
			// 四舍五入
			BigDecimal cut = new BigDecimal(km).setScale(0,
					BigDecimal.ROUND_HALF_UP);
			result = cut.toString();
			// 如果小于1，显�?<1
			if (Integer.parseInt(cut.toString()) < 1) {
				result = "<1";
			}
		} catch (Exception e) {
			result = "-1";
		}
		return result;
	}

	public static String intToString(int val) {
		return String.valueOf(val);
	}

	public static String floatToString(float val) {
		return String.valueOf(val);
	}

	public static String floatToString(double val) {
		return String.valueOf(val);
	}

	/**
	 * 根据传入的年月日，返回固定格式的日期格式（yyyy-MM-dd�?
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static String formatDateString(String year, String month, String day)
			throws Exception {
		if (month.length() == 1) {
			month = "0" + month;
		}
		if (day.length() == 1) {
			day = "0" + day;
		}
		return year + "-" + month + "-" + day;

	}

	/**
	 * 判断当前日期是星期几
	 * 
	 * @param pTime
	 *            �?要判断的时间
	 * @return dayForWeek 判断结果
	 * @Exception 发生异常
	 */
	public static String dayForWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int week = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			week = 7;
		} else {
			week = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		String dayForWeek = "";
		switch (week) {
		case 1:
			dayForWeek = "周一";
			break;
		case 2:
			dayForWeek = "周二";
			break;
		case 3:
			dayForWeek = "周三";
			break;
		case 4:
			dayForWeek = "周四";
			break;
		case 5:
			dayForWeek = "周五";
			break;
		case 6:
			dayForWeek = "周六";
			break;
		case 7:
			dayForWeek = "周日";
			break;
		default:
			break;
		}
		return dayForWeek;
	}

	/**
	 * 字符串转时间
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date stringToDate(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateString);

			return date;
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 格式化并输出json到流
	 * 
	 * @param request
	 * @param response
	 * @param json
	 *            返回输出json
	 * @return
	 */
	public static void outputResult(HttpServletRequest request,
			HttpServletResponse response, String json) {
		try {
			response.setContentType("text/plain");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			// JsonConfig jsonConfig = new JsonConfig();
			// jsonConfig.registerJsonValueProcessor(Date.class, new
			// JsonDateValueProcessor());
			// JSONObject resultJSON = JSONObject.fromObject(json, jsonConfig);
			// // 根据�?要拼装json
			String result = json.toString();
			result = result.replaceAll("\n", "");
			result = result.replaceAll("'", "\"");
			PrintWriter out = response.getWriter();
			out.println(result);// 返回jsonp格式数据
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取分享优惠券金额随机�??
	 * 
	 * @param ShareCouponMin
	 *            分享优惠券金额最小�??
	 * @param ShareCouponMax
	 *            分享优惠券金额最大�??
	 * @return
	 */
	public static int getShareCouponRandom(int ShareCouponMin,
			int ShareCouponMax) {
		if (ShareCouponMin == ShareCouponMax) {
			return ShareCouponMin;
		}
		Random rand = new Random();
		int value = ShareCouponMax - ShareCouponMin;
		int randNum = rand.nextInt(value) + ShareCouponMin;
		return randNum;
	}

	// BASE64 加密  
    public static String getBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
  
    // BASE64 解密  
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    /**
     * 判断是否是空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断是否不是�?
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if((str!=null)&&!"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }
	/**
	 * 测试用主方法
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String str = "";
		str += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);
		}
	}
	
}
