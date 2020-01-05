package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {
    public static SqlSession getSqlSession() throws IOException {
        Reader reader= Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        //能够执行配置文件中的sql语句
        SqlSession sqlSession=factory.openSession();
        return sqlSession;
    }
}
