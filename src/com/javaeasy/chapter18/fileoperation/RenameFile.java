package com.javaeasy.chapter18.fileoperation;

import java.io.File;

/**
 * RenameFile.java
 * 2016-12-27 10:41:07 
 * @author JiaMingsheng
 * p552
 */
public class RenameFile {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("程序需要一个文件路径作为参数！");
			return;
		}
		
		String filePath =  args[0];
		File file = new File(filePath);
		
		if (!file.exists()) {
			System.out.println(filePath + "不是有效的路径！");
			return;
		}
		
		if (!file.isFile()) {
			System.out.println(filePath + "不是有效的文件！");
			return;
		}
		
		File renameFile = new File(file.getParentFile(), "renamedFile");
		
		if (renameFile.exists()) {
			System.out.println("文件名已经被占用！");
			return;
		}
		
		if (file.renameTo(renameFile)) {
			System.out.println("文件重命名成功。");
		} else {
			System.out.println("文件重命名失败。");
		}
	}

}
