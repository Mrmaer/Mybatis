package com.sqlsession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class GetSqlsession {
    public static SqlSessionFactory sqlSessionFactory;
    private static void ceshi() {
        try {
            Reader reader = Resources.getResourceAsReader("dp.xml");
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        ceshi();
        return  sqlSessionFactory.openSession();
    }
}
