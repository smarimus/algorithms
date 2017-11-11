package com.ik.array.part2;

public class EncodeDecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAAb";
		String s2 = "BAAAB";
		String s3 = "ABAB";
		String s4 = "a";
		
		System.out.println(compress(s));
		System.out.println(compress(s2));
		System.out.println(compress(s3));
		System.out.println(compress(s4));
		
		String s5 = "5Ab";
		String s6 = "B3AB";
		String s7 ="ABAB";
		String s8 ="a";
		
		System.out.println(deCompress(s));
		System.out.println(deCompress(s2));
		System.out.println(deCompress(s3));
		System.out.println(deCompress(s8));
	}
	
	static String compress(String s){
		char[] chArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		int count=1;
		for (int i = 0; i < chArr.length; i++) {
			
			char c = chArr[i];
			while(i+1 < chArr.length && c == chArr[i+1] ){
				count++; i++;
			}
			if(count > 1){
				sb.append(count).append(c); count=0;
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	static int parseInt(char s){
		int result =0;
		try{
			String s1= Character.toString(s);
			result = Integer.parseInt(s1);
		}catch(Exception ex){
		}
		return result;
	}
	
	static String deCompress(String s){
		char[] chArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < chArr.length; i++) {
			char val = chArr[i];
			int count = parseInt(val);
			
			if(i+1 < chArr.length && count > 0){
				char str = chArr[i+1];
				
				for (int j = 0; j < count; j++) {
					sb.append(str);
					i++;
				}
			}
			
			sb.append(val);
		}
		return sb.toString();
	}
}


/*Simple version of the problem: Compress a string (only has alphabet characters), with basic encoding, where you simply count the number of repeated characters. Then also write a routine to decompress it.
 
e.g.
Input: "AAAAA" 
Output: "5A"
 
Input: "BAAAB"
Output: "B3AB"
 
Input: "ABAB"
Output: "ABAB" [We are not concerned about characters repeating in groups]
 
Assume that a given character will not repeat more than 127 times.
 
Solution: Compression solution to this is very simple. It pretty much needs one loop. Decompression is equally simple. Let us know if that is not clear.
 
Important twists to the problem: 
* String can have any character from the basic ASCII set (ASCII values 0 to 127). i.e. it can now include numbers.
* Compressed length must not exceed original length. It can be same or less.
 
Solution hint: Given that you cannot have numbers in your solution, can you use something else? Can you make use of higher order ASCII values?
 
Test cases are given for compression of 2nd (twisted) case. 
 */