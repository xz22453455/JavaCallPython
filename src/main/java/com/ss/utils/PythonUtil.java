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

import org.apache.ibatis.javassist.expr.NewArray;

import com.sun.tools.doclets.internal.toolkit.MemberSummaryWriter;

/**
 * @ClassName: PyUtil
 * @Description: python计算引擎
 * @author wangcm
 * @date 2018年6月6日 下午4:34:20
 */

public class PythonUtil {
	// pythonPath:python地址
	private static String pythonPath = "";
	private static PythonUtil pyUtil = null;

	private static String getPythonPath() {
		return pythonPath;
	}

	private static void setPythonPath(String pythonPath) {
		PythonUtil.pythonPath = pythonPath;
	}

	/**
	 * @Title: callPythonScript
	 * @Description: 调用脚本传参
	 * @param algorithm
	 *            算法
	 * @param args
	 *            参数
	 * @return reStr 结果
	 * @throws Exception
	 *             String
	 * @throws:
	 * @date: 2018年6月6日下午4:40:44
	 */

	public String callPythonScript(String algorithm, List<Map> args) throws Exception {
		String line = "";
		String reStr = "";
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
		String[] str = new String[] { "python", pythonPath, algorithm, parameters };
		Process pr = Runtime.getRuntime().exec(str);
		BufferedReader In = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		try {
			while ((line = In.readLine()) != null) {
				System.out.println(line);
				reStr = reStr + line;
			}
			pr.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			In.close();
		}
		return reStr;
	}

	/**
	 * @Title: getInstance
	 * @Description: 获取pythonPaht
	 * @return
	 * @throws IOException
	 *             PyUtil
	 * @throws:
	 * @date: 2018年6月6日下午4:41:04
	 */
	public static PythonUtil getInstance() throws IOException {
		String path = PythonUtil.class.getClassLoader().getResource("application.properties").getPath();
		FileInputStream in = new FileInputStream(path);
		try {
			if (pyUtil == null) {
				pyUtil = new PythonUtil();
				Properties prop = new Properties();
				prop.load(in);
				String pStr = prop.getProperty("python.url");
				pyUtil.setPythonPath(pStr);
			}
		} finally {
			in.close();
		}
		return pyUtil;
	}
}
