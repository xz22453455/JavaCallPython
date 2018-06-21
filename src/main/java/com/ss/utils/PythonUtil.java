package com.ss.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/*
 * @Description:    PythonUtil
 * @Author:         wangcm
 * @CreateDate:     2018\6\16 0016 15:51
 * @UpdateUser:     wangcm
 * @UpdateDate:     2018\6\16 0016 15:51
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class PythonUtil {
    // 脚本地址
    private static String pythonPath = "";
    private static PythonUtil pyUtil = null;

    private static String getPythonPath() {
        return pythonPath;
    }

    private static void setPythonPath(String pythonPath) {
        PythonUtil.pythonPath = pythonPath;
    }

    public String callPythonScript(String algorithm, List<Map> args) throws Exception {
        /*
        * callPythonScript
        * @author      wangcm
        * @param algorithm
        * @param args
        * @return      java.lang.String
        * @exception
        * @date        2018\6\19 0019 9:39
        */
        String line;
        StringBuilder reStr = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (Map m : args) {
            Iterator<Map.Entry<String, String>> it = m.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, String> entry = it.next();
                String parameter = "," + entry.getKey() + "=" + entry.getValue();
                sb.append(parameter);
            }
        }
        String parameters = new String(sb);
        parameters = parameters.substring(1);
        // ["python","地址","公式","参数"]
        String[] str = new String[]{"python", pythonPath, algorithm, parameters};
        Process pr = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                reStr = reStr.append(line);
            }
            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        String returnStr = new String(reStr);
        return returnStr;
    }


    public static PythonUtil getInstance() throws IOException {
        /*
         * 单例获取脚本地址
         * @author      wangcm
         * @param
         * @return      com.ss.utils.PythonUtil
         * @exception
         * @date        2018\6\16 0016 15:48
         */
        String path = PythonUtil.class.getClassLoader().getResource("application.properties").getPath();
        FileInputStream in = new FileInputStream(path);
        try {
            if (pyUtil == null) {
                pyUtil = new PythonUtil();
                Properties prop = new Properties();
                prop.load(in);
                String pStr = prop.getProperty("python.url");
                setPythonPath(pStr);
            }
        } finally {
            in.close();
        }
        return pyUtil;
    }
}
