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
			System.out.println("��" + filePath + "�ж�ȡ���ݡ�"); 
		} else {
			System.out.println(filePath + "�ļ������ڡ�");
			return null;
		}
		return dataFile;
	}

	private static void readData(File file) {
		System.out.println("�ļ��е�����Ϊ��");
		try {
			// ����������
			FileInputStream fis = new FileInputStream(file);
			// ����ļ����ݵ�byte����
			byte[] data = new byte[1024];
			// ��ȡ���ݣ�����byte����
			int len = fis.read(data); 
			// ��byte����ת���ַ���
			String content = new String(data, 0, len);
			System.out.println(content);
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���������ϢΪ��" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
