package task1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

// 
	public int[] mirror() {
		int n = array.length;
		int[] newArray = new int[n * 2];
		for (int i = 0; i < n; i++) {
			newArray[i] = array[i];
			newArray[n * 2 - 1 - i] = array[i];

		}
		return newArray;
	}

//
	public int[] removeDuplicates() {
		int n = array.length;
		int value = 0; // tạo ví trị để lưu phần tử ko trùng lặp
		int[] newArray = new int[n];// mảng mới

		for (int i = 0; i < n; i++) {
			boolean isAppear = false;
			for (int j = 0; j < value; j++) {
				if (array[i] == array[j]) {
					isAppear = true;
					break;
				}

			}
			if (!isAppear) {
				newArray[value] = array[i];
				value++;
			}
		}
		int[] newArrays = Arrays.copyOf(newArray, value);
		return newArrays;

	}

	public int[] getMissingValues() {
		int n = array.length;

		int valueArray = 0;
		for (int i = 0; i < n - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				valueArray += array[i + 1] - array[i] - 1;
			}
		}
		int[] newArray = new int[valueArray];
		int index = 0;

		for (int i = 0; i < n - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				int missing = array[i + 1] - array[i] - 1;

				for (int j = 1; j <= missing; j++) {
					newArray[index] = array[i] + j;
					index++;
				}
			}
		}
		return newArray;
	}

	public int[] fillMissingValues(int k) {
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++) {
			if (array[0] == -1) {
				array[0] = (array[i + 1] + array[i + 2] + array[i + 3]) / k;
			}
			if (array[n - 1] == -1) {
				array[n - 1] = (array[n - 2] + array[n - 3] + array[n - 4]) / k;
			
			}else
				if (array[i] == -1) {
				if (array[i - 1] + array[i - 2] + array[i + 1] > array[i + 1] + array[i + 2] + array[i - 1]) {
					array[i] = (array[i + 1] + array[i + 2] + array[i - 1]) / k;
				} else {
					array[i] = (array[i - 1] + array[i - 2] + array[i + 1]) / k;
				}

			}
		}

		return array;
	}
	
	
	

	public static void main(String[] args) {
		
		System.out.println("intput: [1, 2, 3]");
		int[] array1 = { 1, 2, 3 };
		MyArray myArray1 = new MyArray(array1);

		int[] newArray1 = myArray1.mirror();
		System.out.println("output: "+Arrays.toString(newArray1));

		System.out.println("");
		System.out.println("input: 1 3 5 1 3 7 9 8");
	    int[] array2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray myArray2 = new MyArray(array2);
		int[] newArray2 = myArray2.removeDuplicates();
		System.out.println("output: "+Arrays.toString(newArray2));

		System.out.println("");
		System.out.println(" Input: 10 11 12 13 14 16 17 19 20");
		int[] array3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray myArray3 = new MyArray(array3);
		int[] newArray3 = myArray3.getMissingValues();
		System.out.println("output: "+Arrays.toString(newArray3));

		System.out.println("");
		System.out.println("Input: 10 11 12 -1 14 10 17 19 20");
		int[] array4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		MyArray myArray4 = new MyArray(array4);
		int[] newArray4 = myArray4.fillMissingValues(3);
		System.out.println("output (k=3): "+Arrays.toString(newArray4));
	}
}