package com.swing.util;

import com.swing.dao.WordsDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author swing
 */
public class WordUtils {
    public static WordsDAO wordsDAO;

    /**
     * 获取SqlSession
     *
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        // 读取mybatis-config.xml文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 初始化mybatis，创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建Session实例
        return sqlSessionFactory.openSession();
    }

    public static void init() {
        wordsDAO = getWordsDAO();
    }

    /**
     * 获取DAO对象
     */
    public static WordsDAO getWordsDAO() {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(WordsDAO.class);
    }

    /**
     * 忽略大小写获取可匹配的字符串
     */
    public static List<String> getContainStrIgnoreCase(CharSequence str, CharSequence testStr) {
        List<String> strings = new ArrayList<>();
        //预定义忽略大小写模式
        Pattern pattern = Pattern.compile(testStr.toString(), Pattern.CASE_INSENSITIVE);
        String targetString = str.toString();
        Matcher matcher = pattern.matcher(targetString);
        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }
}