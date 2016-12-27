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
			System.out.println("ʹ���Ѿ����ڵ�datafile.txt�ļ�");
		} else {
			try {
				dataFile.createNewFile();
				System.out.println("����datafile.txt�ļ���");
			} catch (IOException e) {
				System.out.println("����datafile.txt�ļ�ʧ�ܣ�������Ϣ��" + e.getMessage());
				return;
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(dataFile);
			pw.write("���ļ���д�����ݡ�");
			System.out.println("д�����ݳɹ���");
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���������ϢΪ��" + e.getMessage());
		}
	}

}
