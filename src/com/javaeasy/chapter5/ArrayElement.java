package com.javaeasy.chapter5;

/**
 * ArrayElement.java
 * 2016-12-28 17:22:45 
 * @author JiaMingsheng
 * p112
 */
public class ArrayElement {
	public static void main(String[] args) {
		int[] intArray = new int[1];
		byte byteValue = 55;
		// ʹ��byte���͵ı�����int�����е�Ԫ�ظ�ֵ
		intArray[0] = byteValue;
		System.out.println("int����intArray�еĵ�һ��Ԫ��ֵΪ��" + intArray[0]);
	}

}
