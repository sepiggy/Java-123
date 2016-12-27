package com.javaeasy.chapter18.writeandread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {
	
	public static void main(String[] args) {
		File dataFile = new File("c:\\javaeasy\\datafile.txt");
		
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("��datafile.txt�ж�ȡ���ݡ�");
		} else {
			System.out.println("datafile.txt�ļ������ڡ�");
			return;
		}
		System.out.println("�ļ��е�����Ϊ��");
		try {
			FileReader fr = new FileReader(dataFile);

			BufferedReader br = new BufferedReader(fr);
			
			String content = null;
			
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���������ϢΪ��" + e.getMessage()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
