package com.swing.command;

import com.swing.Main;
import com.swing.domain.WordsDO;
import com.swing.util.WordUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author swing
 */
public class CommandRouter {
    public static final String COMMAND_PREFIX = "-";

    /**
     * 本轮查询失败或者无效，返回null
     */
    public static void router(String input) throws IOException, InterruptedException {
        //清空终端
        if (input.startsWith(CommandConstants.CLEAR)) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        //退出程序
        if (input.startsWith(CommandConstants.QUIT)) {
            System.exit(1);
        }
        //帮助文档
        if (input.startsWith(CommandConstants.HELP)) {
            System.out.println("\u001B[35m葡萄翻译命令提示:\n\t-c   清空\n\t-q   退出\n\t-h   帮助\n\t-s   以字符串开始的单词\n\t-e   以字符串结尾的单词\n\t-a   与该字符串全匹配的单词\n\t-p   在单词解释中搜索该字符串");
        }
        //如果不带命令，默认查询规则
        if (!input.startsWith(COMMAND_PREFIX)) {
            defaultQuery(input);
        }
        //全匹配
        if (input.startsWith(CommandConstants.ALL)) {
            input = input.replace(CommandConstants.ALL, "").trim();
            Main.input = input;
            matcherAllQuery(input);
        }
        //匹配开头
        if (input.startsWith(CommandConstants.START)) {
            input = input.replace(CommandConstants.START, "").trim();
            Main.input = input;
            matcherStartQuery(input);
        }
        //匹配结尾
        if (input.startsWith(CommandConstants.END)) {
            input = input.replace(CommandConstants.END, "").trim();
            Main.input = input;
            matcherEndQuery(input);
        }
        //匹配注释
        if (input.startsWith(CommandConstants.EXPLAIN)) {
            input = input.replace(CommandConstants.EXPLAIN, "").trim();
            Main.input = input;
            matcherWithExplain(input);
        }
    }

    /**
     * 默认规则查询
     */
    public static void defaultQuery(String input) {
        List<WordsDO> list = WordUtils.wordsDAO.listByWord(input);
        list.addAll(WordUtils.wordsDAO.listByExplain(input));
        show(list);
    }

    /**
     * 从注释中查询查询
     */
    public static void matcherWithExplain(String input) {
        List<WordsDO> list = WordUtils.wordsDAO.listByExplain(input);
        show(list);
    }

    /**
     * 全匹配查询
     */
    public static void matcherAllQuery(String input) {
        List<WordsDO> list = WordUtils.wordsDAO.listByWordAll(input);
        show(list);
    }

    /**
     * 匹配开头查询
     */
    public static void matcherStartQuery(String input) {
        List<WordsDO> list = WordUtils.wordsDAO.listByWordStart(input);
        show(list);
    }

    /**
     * 匹配结尾查询
     */
    public static void matcherEndQuery(String input) {
        List<WordsDO> list = WordUtils.wordsDAO.listByWordEnd(input);
        show(list);
    }

    /**
     * 高亮展示
     */
    public static void show(List<WordsDO> list) {
        if (list.size() > 0) {
            list.forEach(Main::highlightHandler);
        } else {
            System.out.println("\u001B[35m未检索到相关数据 '> - <'  !!!");
        }
    }
}






























