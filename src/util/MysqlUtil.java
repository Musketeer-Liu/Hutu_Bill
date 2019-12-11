package util;

import java.io.*;

public class MysqlUtil {
    public static void backup(String mysqlPath, String backupfile) throws IOException {
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p %s -hlocalhot -P%d %s -r \"%s\"";
        String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port, DBUtil.database, backupfile);
        Runtime.getRuntime().exec(command);
    }

    public static void recover(String mysqlPath, String recoverfile) {
        try {
            String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p %s -hlocalhot -P%d %s -r \"%s\"";
            String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port, DBUtil.database);
            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String mysqlPath = "D:/tools/MYSQL/mysql-5.1.57-win32";
        String file = "~/butubill.sql";

//        backup(mysqlPath, file);
//        restore();
//        recover(mysqlPath, file);
//        recover(file);
        recover(mysqlPath, file);
    }
}
