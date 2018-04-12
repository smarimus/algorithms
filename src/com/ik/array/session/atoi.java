package com.ik.array.session;

public class atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "test";
		
		System.out.println(myAtoi("2")); // +2
		System.out.println(myAtoi("- 321")); // 0
		System.out.println(myAtoi("+2")); // +2
		
		System.out.println(myAtoi("+-2")); // 0
		System.out.println(myAtoi("+"));
		System.out.println(myAtoi("   a2"));
		System.out.println(myAtoi("   -2"));
		System.out.println(myAtoi("   +2"));
		System.out.println(myAtoi("-12344444444444444444444444444444444"));
		System.out.println(myAtoi("		"));
		System.out.println(myAtoi("		-"));
		System.out.println(myAtoi("		-a"));
		System.out.println(myAtoi("	-	-a -12"));
		System.out.println(myAtoi("	-	-a -a12"));
		
	}
	
	public static int myAtoi(String s) {
		boolean flag = true;	boolean hasSign = false; boolean found = false;
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		int result=0;
		
		int i=0;
		while(i < len && Character.isWhitespace(s.charAt(i))){
			i++;
		}
		
		while(flag && i < len){
			if(Character.isDigit(s.charAt(i)) ){
				flag = false;	found = true;
			   break; 
			}else if((s.charAt(i) == 43 || s.charAt(i) == 45) && (i+1 < len) && (Character.isDigit(s.charAt(i+1)))){
				
				 if(i - 1 >= 0 && ( s.charAt(i - 1) == 45 || s.charAt(i - 1) == 43)){
					 i = i+2; continue;
				}
				hasSign = true; found = true; break;
			}
			flag = false;
		}
		
		if(found && i < len){
			if( hasSign && i+1 < len) {
				sb.append(s.charAt(i));
				sb.append(s.charAt(++i));
			}else{
				sb.append(s.charAt(i));
			}
			
			while(i+1 < len && Character.isDigit(s.charAt(i+1))){
				sb.append(s.charAt(++i));
			}
			
			if(sb.length() > 0 ){
				try{
					result = Integer.parseInt(sb.toString());
				}catch(NumberFormatException nfe){
					if(sb.toString().startsWith("-")){
						result =Integer.MIN_VALUE;
					}else{
						result =Integer.MAX_VALUE;
					}
				}
			}
		}
		
		return result;
	}
	
	public static int myAtoi1(String s) {
		boolean flag = true;	boolean hasSign = false; boolean found = false;
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		int result=0;
		
		int i=0;
		while(i < len && Character.isWhitespace(s.charAt(i))){
			i++;
		}
		
		while(flag && i < len){
			if(Character.isDigit(s.charAt(i)) ){
				flag = false;	found = true;
			   break; 
			}else if((s.charAt(i) == 43 || s.charAt(i) == 45) && (i+1 < len) && (Character.isDigit(s.charAt(i+1)))){
				
				 if(i - 1 >= 0 && ( s.charAt(i - 1) == 45 || s.charAt(i - 1) == 43)){
					 i = i+2; continue;
				}
				hasSign = true; found = true; break;
			}
			i++;
		}
		
		
		if(found && i < len){
			if( hasSign && i+1 < len) {
				sb.append(s.charAt(i));
				sb.append(s.charAt(++i));
			}else{
				sb.append(s.charAt(i));
			}
			
			while(i+1 < len && Character.isDigit(s.charAt(i+1))){
				sb.append(s.charAt(++i));
			}
			
			if(sb.length() > 0 ){
				try{
					result = Integer.parseInt(sb.toString());
				}catch(NumberFormatException nfe){
					if(sb.toString().startsWith("-")){
						result =Integer.MIN_VALUE;
					}else{
						result =Integer.MAX_VALUE;
					}
				}
			}
		}
		
		return result;
	}
	
	public static int myAtoiOld(String s) {
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