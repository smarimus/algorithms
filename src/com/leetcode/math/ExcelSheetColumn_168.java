package com.leetcode.math;

public class ExcelSheetColumn_168 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertToTitle(7001));
		//characterTest();

	}

	private static void characterTest() {
		int t = (char)'A';
		int t1 = (char)'a';
		System.out.println(t);
		
		System.out.println(t1);
		System.out.println(t1-t);
		
		for(int i = 90; i< 97; i++){
			System.out.print((char)i + "	");
		}
	}
	
	public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            System.out.println((char)('A' + n % 26));
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

}
