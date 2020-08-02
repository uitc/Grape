package com.swing.dao;

import com.swing.domain.WordsDO;

import java.util.List;

/**
 * @author swing
 */
public interface WordsDAO {
    /**
     * 插入
     *
     * @param t 内容
     * @return 影响行数
     */
    int insert(WordsDO t);

    /**
     * 默认匹配单词
     *
     * @param word 单词
     * @return 符合条件的集合
     */
    List<WordsDO> listByWord(String word);


    /**
     * 全匹配匹配单词
     *
     * @param word 单词
     * @return 符合条件的集合
     */
    List<WordsDO> listByWordAll(String word);

    /**
     * 匹配单词开始
     *
     * @param word 单词
     * @return 符合条件的集合
     */
    List<WordsDO> listByWordStart(String word);

    /**
     * 匹配单词结尾
     *
     * @param word 单词
     * @return 符合条件的集合
     */
    List<WordsDO> listByWordEnd(String word);

    /**
     * 默认匹配解释
     *
     * @param wordExplain 解释
     * @return 结果集
     */
    List<WordsDO> listByExplain(String wordExplain);
}