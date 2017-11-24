package cn.uc.yiqibang.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 
 *  Cookie工具�?
 */
public class CookieUtils {

	 //从cookie数组中获取指定key的cookie
    public static Cookie getCookieFromCookies(Cookie[] cookies,String target){
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals(target)){
                cookie = cookies[i];
            }
        }

        return cookie;
    }
    //删除�?有cookie
    public static void removeAllCookies(HttpServletRequest req,HttpServletResponse resp){
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie: cookies){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
    }
    //根据cookie名称移除cookie
    public static void removeCookieByName(String cookie_name,HttpServletRequest request,HttpServletResponse resp){
        Cookie cookie = null;
           Cookie[] cookies = null;
           // 获取当前域名下的cookies，是�?个数�?
           cookies = request.getCookies();
           if( cookies != null ){
              for (int i = 0; i < cookies.length; i++){
                 cookie = cookies[i];
                 if((cookie.getName()).compareTo(cookie_name) == 0 ){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                 }
              }
           }
    }
}
