package com.swing;

import cn.hutool.core.util.StrUtil;
import com.swing.command.CommandRouter;
import com.swing.domain.WordsDO;
import com.swing.util.WordUtils;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author swing
 */
public class Main {
    public static String input;

    public static void main(String[] args) throws IOException, InterruptedException {
        //初始化mybatis
        WordUtils.init();
        // 清屏命令
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        int i = 1000;
        while (i > 0) {
            AnsiConsole.systemInstall();
            System.out.println();
            System.out.println("\u001B[0m^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.print("Grape_> ");
            input = scanner.nextLine();
            System.out.println();
            if (input == null || "".equalsIgnoreCase(input)) {
                System.out.println("\u001B[35m请输入查询信息");
                continue;
            }
            input = input.trim();
            CommandRouter.router(input);
            i--;
        }
        scanner.close();
    }

    /**
     * 对输出信息进行高亮标注
     */
    public static void highlightHandler(WordsDO wordsDO) {
        System.out.print("     ");
        String word = wordsDO.getWord();
        if (word != null) {
            word = word.trim();
            word = "\u001B[36m" + word;
            if (StrUtil.containsIgnoreCase(word, input)) {
                //"\u001B[34m"算五个字符，在输出中会占位
                for (String str : WordUtils.getContainStrIgnoreCase(word, input)) {
                    word = word.replaceAll(str, "\u001B[33m" + str + "\u001B[36m");
                }
                System.out.printf("%-45s", word);
            } else {
                System.out.printf("%-35s", word);
            }
        }
        String wordExplain = wordsDO.getwordExplain();
        if (wordExplain != null) {
            wordExplain = wordExplain.trim();
            wordExplain = "\u001B[36m" + wordExplain;
            if (StrUtil.containsIgnoreCase(wordExplain, input)) {
                for (String str : WordUtils.getContainStrIgnoreCase(wordExplain, input)) {
                    wordExplain = wordExplain.replaceAll(str, "\u001B[33m" + str + "\u001B[36m");
                }
            }
        }
        AnsiConsole.systemInstall();
        System.out.printf("%-100s", wordExplain);
        System.out.println();
    }


}