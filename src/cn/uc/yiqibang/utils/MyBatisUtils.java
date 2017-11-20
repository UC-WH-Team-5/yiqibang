package cn.uc.yiqibang.utils;


import java.io.InputStream;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MyBatisUtils {
	
	static SqlSessionFactory factory=null;
	static String config="config.xml";
	private static SqlSessionFactory factory(){				
		if(factory==null){
			InputStream is=MyBatisUtils.class.getClassLoader().getResourceAsStream(config);
			factory=new SqlSessionFactoryBuilder().build(is);			
		}					
		return factory;
	}
	
	public static SqlSession openSession(){
		
		
		return factory().openSession();
	}
	
}
