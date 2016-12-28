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
		// 使用byte类型的变量给int数组中的元素赋值
		intArray[0] = byteValue;
		System.out.println("int数组intArray中的第一个元素值为：" + intArray[0]);
	}

}
