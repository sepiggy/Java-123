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
			System.out.println("������Ҫһ���ļ�·����Ϊ������");
			return;
		}
		
		String filePath =  args[0];
		File file = new File(filePath);
		
		if (!file.exists()) {
			System.out.println(filePath + "������Ч��·����");
			return;
		}
		
		if (!file.isFile()) {
			System.out.println(filePath + "������Ч���ļ���");
			return;
		}
		
		File renameFile = new File(file.getParentFile(), "renamedFile");
		
		if (renameFile.exists()) {
			System.out.println("�ļ����Ѿ���ռ�ã�");
			return;
		}
		
		if (file.renameTo(renameFile)) {
			System.out.println("�ļ��������ɹ���");
		} else {
			System.out.println("�ļ�������ʧ�ܡ�");
		}
	}

}
