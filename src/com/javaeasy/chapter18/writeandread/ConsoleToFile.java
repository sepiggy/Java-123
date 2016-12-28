package com.javaeasy.chapter18.writeandread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ConsoleToFile.java
 * 2016-12-28 14:06:03 
 * @author JiaMingsheng
 * p559
 */
public class ConsoleToFile {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		File datafile = prepareFile("c:\\javaeasy\\consoleFile.txt");
		
		PrintWriter pw = null;
		if (datafile == null) {
			System.out.println("���������ļ����������˳���");
			return;
		}
		try {
			pw = new PrintWriter(datafile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String content = null;
		String endMark = "end";
		
		try {
			System.out.println("�����Ҫд���ļ������ݣ���end������");
			while ((content = br.readLine()) != null) {
				if (content.equalsIgnoreCase(endMark)) {
					break;
				}
				pw.write(content + "\r\n");
			}
			pw.close();
			br.close();
			System.out.println("���������");
		} catch (IOException e) {
			e.printStackTrace();
		}
		printFileContent(datafile);
	}

	private static File prepareFile(String filePath) {
		File dataFile = new File(filePath);
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("ʹ���Ѿ����ڵ�" + filePath + "�ļ�");
		} else {
			try {
				dataFile.createNewFile();
				System.out.println("����" + filePath + "�ļ���");
			} catch (IOException e) {
				System.out.println("����" + filePath + "�ļ�ʧ�ܣ�������Ϣ��" + e.getMessage()); 
				return null;
			}
		}
		return dataFile;
	}
	
	private static void printFileContent(File file) {
		System.out.println("�ļ��е�����Ϊ��");
		try {
			FileReader fr = new FileReader(file);
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