package com.javaeasy.chapter18.fileoperation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ListForderAndFile.java
 * 2016-12-26 15:36:17 
 * @author JiaMingsheng
 * p550
 */
public class ListForderAndFile {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("程序需要一个文件夹路径作为参数！");
			return;
		}
		
		String folderPath = args[0];
		File folder = new File(folderPath);
		if (!folder.exists()) {
			System.out.println(folderPath + "不是有效的路径！");
			return;
		}
		if (!folder.isDirectory()) {
			System.out.println(folderPath + "不是有效的文件夹！");
			return;
		}
		
		File[] allFiles =  folder.listFiles();
		List files = new ArrayList();
		List folders = new ArrayList();
		
		for (int i=0; i<allFiles.length; i++) {
			if (allFiles[i].isFile()) {
				files.add(allFiles[i]);
			} else {
				folders.add(allFiles[i]);
			}
		}
		
		System.out.println("文件夹\"" + folderPath + "\"中包含如下文件夹：");
		printPath(folders);
		System.out.println("=========================================");
		System.out.println("文件夹\"" + folderPath + "\"中包含如下文件：");
		printPath(files);
	}
	
	private static void printPath(@SuppressWarnings("rawtypes") List list) {
		for (int i=0; i<list.size(); i++) {
			File file = (File) list.get(i);
			System.out.println(file.getName());
		}
	}
}
