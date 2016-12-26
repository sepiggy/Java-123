package com.javaeasy.chapter18.fileoperation;

import java.io.File;
import java.io.IOException;

/**
 * CreateFileAndFolder.java
 * 2016-12-26 14:43:56 
 * @author JiaMingsheng
 * p549
 */
public class CreateFileAndFolder {
	
	public static void main(String[] args) {
		String folderPath = "c:" + File.separator + "javaeasy" + File.separator + "testingfolder";
		String fileName = "testingfile.txt";

		File folder = new File(folderPath);
		if (folder.exists() && folder.isDirectory()) {
			System.out.println("该文件夹已经存在了。");
		} else {
			boolean creatFolders = folder.mkdirs();
			if (creatFolders) {
				System.out.println("文件夹创建成功。");
			} else {
				System.out.println("文件夹创建失败。");
				return;
			}
		}
		
		File file =  new File(folder, fileName);
		if (file.exists() && file.isFile()) {
			System.out.println("文件已经存在，将文件删除！");
			boolean deleteFile = file.delete();
			if (deleteFile) {
				System.out.println("文件删除成功！");
			} else {
				System.out.println("文件删除失败！");
				return;
			}
		}
		
		try {
			file.createNewFile();
			System.out.println("文件创建成功。");
		} catch (IOException e) {
			System.out.println("文件创建失败。错误信息：" + e.toString());
			return;
		}
	}

}
