package com.anbo.util;
import java.io.InputStream;  
import org.apache.ibatis.io.Resources;  
import org.apache.ibatis.session.SqlSession;  
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder; 
public class MybatisFactory {
	/** 
     * SqlSessionFactory对象可以看成DataSource（数据库连接池） 
     * 在应用执行期间，应该只创建一次，建议使用单例模式 
     * 通过SqlSessionFactoryBuilder来获得数据库配置参数并创建  
     */  
    private static SqlSessionFactory sqlSessionFactory;  
      
    /** 
     * SqlSession对象可以理解成对Connection的封装，即一个数据连接会话 
     * 它同时也封装了连接和断开过程，提供sql语句的映射 
     * SqlSession实例不能被共享，它不是线程安全的。 
     * 所以应该一次性用完后要确保使用finally块来关闭它，关闭时会被收回SqlSessionFactory所管理的连接池中 
     */  
    //private static SqlSession session;  
    static  
    {  
        try {  
            String resource = "MyBatisConfig.xml";  
            InputStream is = Resources.getResourceAsStream(resource); //或者用Reader  Reader read=Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);  
           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    //  
    public static SqlSession getSqlSession()  
    {  
        return sqlSessionFactory.openSession();  
    }  
    //  
    public static void close(SqlSession session)  
    {  
        if(session != null)  
            session.close();  
    }  
}
