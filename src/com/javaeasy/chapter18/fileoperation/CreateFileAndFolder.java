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
			System.out.println("���ļ����Ѿ������ˡ�");
		} else {
			boolean creatFolders = folder.mkdirs();
			if (creatFolders) {
				System.out.println("�ļ��д����ɹ���");
			} else {
				System.out.println("�ļ��д���ʧ�ܡ�");
				return;
			}
		}
		
		File file =  new File(folder, fileName);
		if (file.exists() && file.isFile()) {
			System.out.println("�ļ��Ѿ����ڣ����ļ�ɾ����");
			boolean deleteFile = file.delete();
			if (deleteFile) {
				System.out.println("�ļ�ɾ���ɹ���");
			} else {
				System.out.println("�ļ�ɾ��ʧ�ܣ�");
				return;
			}
		}
		
		try {
			file.createNewFile();
			System.out.println("�ļ������ɹ���");
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ�ܡ�������Ϣ��" + e.toString());
			return;
		}
	}

}
