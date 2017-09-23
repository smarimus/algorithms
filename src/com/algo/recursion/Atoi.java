package com.algo.recursion;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s =  {"42",
				"-3924x8fc",
				"abc-843t" ,
				"+1",
				"c++", 
				"++1",  // Tricky.
				"--4-5", // Tricky
				"+-- +-6.3 ", // Tricky
				"",
				"  ",
				"								sdsd 			34 2323 ",
				"-",
				"",
				};
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(atoi(s[i]));	
		}
		
		/*for (int i = 0; i < s.length; i++) {
			System.out.println(myAtoi(s[i]));	
		}*/
		
	}
	
/*	e.g. 
	"42" = 42
	"-3924x8fc" = -3924
	"abc-843t" = -843
	"+1" = 1
	"c++" = 0
	"++1" = 1  // Tricky.
	"--4-5" = -4 // Tricky
	"+-- +-6.3 " = -6 // Tricky
	"" = 0
	"  " = 0
	"-" = 0*/
	
	public static int atoi(String s) {
        int result=0;
		int startIndex=0;
        int len= s.length()-1;
		
		boolean found = false;
		
		StringBuffer sb = new StringBuffer();
		while(startIndex <= len){
			char c = s.charAt(startIndex);
			boolean isDigit = Character.isDigit(c);
			if(!found && isDigit){
				found = true;
			}
			
			if(found){
				if(startIndex-1 >= 0){
					char sign = s.charAt(startIndex-1);
					if("-".equalsIgnoreCase(Character.toString(sign))){
						sb.append(sign);
					}
				}
				
				if(isDigit){
					sb.append(c);
				}else{
					break;
				}
			}
			startIndex++;
		}
		
		String finalStr = sb.toString();
		if(finalStr.length() >0){
			result = Integer.parseInt(finalStr);
		}
		
		return result;
        
    }
	
	public static int myAtoi(String s) {
        int result=0;
		int startIndex=0;
        int len= s.length()-1;
		
		boolean found = false;
			
		while(startIndex <= len){
			char c = s.charAt(startIndex);
			if(Character.isDigit(c)){
				found = true;
				break;
			}
			startIndex++;
		}
		
		if(found){
			StringBuffer sb = new StringBuffer();
			while(startIndex <= len){
				char c = s.charAt(startIndex);
				
				if(startIndex-1 >= 0){
					char sign = s.charAt(startIndex-1);
					if("-".equalsIgnoreCase(Character.toString(sign))){
						sb.append(sign);
					}
				}
				
				if(Character.isDigit(c)){
					sb.append(c);
				}else{
					break;
				}
				startIndex++;
			}
			
			String finalStr = sb.toString();
			if(finalStr.length() >0){
				if(isInteger(finalStr)){
					result = Integer.parseInt(finalStr);
				}else if(finalStr.startsWith("-")){
					result = Integer.MIN_VALUE;
				}else{
					result = Integer.MAX_VALUE;
				}
			}
		}
		
		return result;
        
    }
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
	