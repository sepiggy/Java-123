package com.javaeasy.chapter18.writeandread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * WriteDataUsingStream.java
 * 2016-12-28 14:09:30 
 * @author JiaMingsheng
 * p561
 */
public class WriteDataUsingStream { 
	
	public static void main(String[] args) {
		File dataFile = new File("c:\\javaeasy\\DataFileForOutputStream.txt");
		if (dataFile.exists() && dataFile.isFile()) {
			// �ļ��Ѵ��ڵ����
			System.out.println("ʹ���Ѿ����ڵ� DataFileForOutputStream.txt�ļ�");
		} else {
			// �ļ�δ���ڵ����
			try {
				dataFile.createNewFile();
				System.out.println("����DataFileForOutputStream.txt�ļ���");
			} catch (IOException e) {
				System.out.println("����DataFileForOutputStream.txt�ļ�ʧ�ܣ��������ϢΪ��" + e.getMessage());
				return;
			}
		}
		
		try {
			String content = "ͨ����������ļ�д�����ݡ�";
			FileOutputStream fos = new FileOutputStream(dataFile);
			byte[] contentBytes = content.getBytes();
			fos.write(contentBytes);
			fos.close();
			System.out.println("����д��ɹ���");
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���������ϢΪ��" + e.getMessage());
		} catch (IOException e) {
			System.out.println("������ݳ���������ϢΪ��" + e.getMessage());
		}
	}
}
