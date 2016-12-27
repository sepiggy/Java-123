package com.javaeasy.chapter18.writeandread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WriteDataToFile.java
 * 2016-12-27 16:52:06 
 * @author JiaMingsheng
 * p556
 */
public class WriteDataToFile {
	
	public static void main(String[] args) {
		File dataFile =  new File("c:\\javaeasy\\datafile.txt");
		
		if (dataFile.isFile() && dataFile.exists()) {
			System.out.println("使用已经存在的datafile.txt文件");
		} else {
			try {
				dataFile.createNewFile();
				System.out.println("创建datafile.txt文件。");
			} catch (IOException e) {
				System.out.println("创建datafile.txt文件失败，错误信息：" + e.getMessage());
				return;
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(dataFile);
			pw.write("向文件中写入数据。");
			System.out.println("写入数据成功！");
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		}
	}

}
