package com.swing.domain;

import java.io.Serializable;

/**
 * :对象 words
 *
 * @author swing
 */
public class WordsDO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 单词
     */
    private String word;
    /**
     * 解释
     */
    private String wordExplain;

    /**
     * 无参构造函数
     */
    public WordsDO() {
    }

    /**
     * 全参构造函数
     */
    public WordsDO(String word, String wordExplain) {
        this.word = word;
        this.wordExplain = wordExplain;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getwordExplain() {
        return wordExplain;
    }

    public void setwordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    @Override
    public String toString() {
        return word + "\t\t" + wordExplain;
    }
}