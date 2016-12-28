package com.javaeasy.chapter18.writeandread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ReadDataFromFileUsingStream.java
 * 2016-12-28 15:08:15 
 * @author JiaMingsheng
 * p562
 */
public class ReadDataFromFileUsingStream {

	public static void main(String[] args) {
		File dataFile = prepareFile("c:\\javaeasy\\DataFileForOutputStream.txt");
		readData(dataFile);

	}
	
	private static File prepareFile(String filePath) {
		File dataFile = new File(filePath);
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("从" + filePath + "中读取数据。"); 
		} else {
			System.out.println(filePath + "文件不存在。");
			return null;
		}
		return dataFile;
	}

	private static void readData(File file) {
		System.out.println("文件中的内容为：");
		try {
			// 创建输入流
			FileInputStream fis = new FileInputStream(file);
			// 存放文件数据的byte数组
			byte[] data = new byte[1024];
			// 读取数据，放入byte数组
			int len = fis.read(data); 
			// 将byte数组转成字符串
			String content = new String(data, 0, len);
			System.out.println(content);
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
