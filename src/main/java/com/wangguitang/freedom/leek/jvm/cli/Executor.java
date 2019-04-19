package com.wangguitang.freedom.leek.jvm.cli;

import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * 命令行工具，执行器
 * @author freedom wang
 * @date 2019-04-18 21:38:11
 */
public class Executor {
    private static Options options = new Options();

    static {
        // 创建选项对象，并添加一些选项
        options.addOption("v", false, "显示执行器版本");
        options.addOption("h", false, "显示帮助");
        options.addOption("cp", "classpath", true, "设置用户类路径");
    }

    public static void main(String[] args) {
        args = new String[]{"-h"};

        // 创建一个命令行解析器
        CommandLineParser parser = new DefaultParser();
        try {
            // 解析命令行参数
            CommandLine line = parser.parse(options, args);

            String[] cliAgs = line.getArgs();
            if (cliAgs != null && cliAgs.length > 0) {
                System.out.println("class运行了，参数为：" + Arrays.toString(cliAgs));
            } else if (line.hasOption("v")) {
                System.out.println("当前版本：1.0.0");
            } else if (line.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("exec", options);
            }
        } catch (ParseException exp) {
            exp.printStackTrace();
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }
}
