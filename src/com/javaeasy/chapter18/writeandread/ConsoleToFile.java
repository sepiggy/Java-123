package com.javaeasy.chapter18.writeandread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ConsoleToFile.java
 * 2016-12-28 14:06:03 
 * @author JiaMingsheng
 * p559
 */
public class ConsoleToFile {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		File datafile = prepareFile("c:\\javaeasy\\consoleFile.txt");
		
		PrintWriter pw = null;
		if (datafile == null) {
			System.out.println("创建数据文件出错，程序退出。");
			return;
		}
		try {
			pw = new PrintWriter(datafile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String content = null;
		String endMark = "end";
		
		try {
			System.out.println("请输出要写入文件的内容，以end结束：");
			while ((content = br.readLine()) != null) {
				if (content.equalsIgnoreCase(endMark)) {
					break;
				}
				pw.write(content + "\r\n");
			}
			pw.close();
			br.close();
			System.out.println("输入结束。");
		} catch (IOException e) {
			e.printStackTrace();
		}
		printFileContent(datafile);
	}

	private static File prepareFile(String filePath) {
		File dataFile = new File(filePath);
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("使用已经存在的" + filePath + "文件");
		} else {
			try {
				dataFile.createNewFile();
				System.out.println("创建" + filePath + "文件。");
			} catch (IOException e) {
				System.out.println("创建" + filePath + "文件失败，错误信息：" + e.getMessage()); 
				return null;
			}
		}
		return dataFile;
	}
	
	private static void printFileContent(File file) {
		System.out.println("文件中的内容为：");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}