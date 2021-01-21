import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 邱道长
 * 2019/07/16
 */
public class test01 {

    // 测试用户表里面数据总量
    @Test
    public void testUserCount(){

        // 1 读取核心的配置文件
        String resource = "Mybatis_config.xml";
        // 2 提供了一个Resources工具类，将我们的文件转换为输入流对象，再去解析
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            // 3 我们使用SqlSessionFactoryBuilder来构建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 4 利用会话工厂来生产会话
            SqlSession session = sqlSessionFactory.openSession();
            // 5 利用会话完成数据库的操作
            Object o = session.selectOne("com.jiahui.pojo.User.SuiYi");
            // 写入mapper里的namespace + id
            System.out.println(o);
            // 6 记得提交事务，关闭资源
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
