package com.ik.sort.tt;

public class isPal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("Dammit I'm mad."));
		System.out.println(isPalindrome("Red Roses run no risk, sir, on nurses order."));
		//System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		//System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(",'"));
		System.out.println(isPalindrome("       |' g  '''|    "));
	}
	
	public static boolean isPalindrome(String strarr) {
		strarr = strarr.trim();
		
        if(strarr.length() <=1)
			return true;
        
        int first = eatSpaceFirst(strarr, 0);
        int last = eatSpaceLast(strarr, strarr.length()-1);
        
        if(first >= strarr.length() || last >= strarr.length()) return true;
        
        boolean isEqual = Character.toString(strarr.charAt(first)).equalsIgnoreCase(Character.toString(strarr.charAt(last) ));
        
        if(isEqual && (first+1 > last))
        	return true;
        
		return  isEqual && isPalindrome(strarr.substring(first+1, last)); 
	
	}
	
	static int eatSpaceFirst(String s, int index){
		int len = s.length();
		while(index < len ){
			String c = Character.toString(s.charAt(index));
			if(".".equals(c)  || ",".equals(c)|| "!".equals(c) || "-".equals(c) || ";".equals(c) || ":".equals(c) || "'".equals(c) || "\"".equals(c) || "".equals(c) || " ".equals(c)){
				index = index+1;
			}else{
				break;
			}
		}
		return index;
	}
	
	static int eatSpaceLast(String s, int index){
		
		while(index >= 0 ){
			String c = Character.toString(s.charAt(index));
			if(".".equals(c)  || ",".equals(c)|| "!".equals(c) || "-".equals(c) || ";".equals(c) || ":".equals(c) || "'".equals(c) || "\"".equals(c) || "".equals(c)|| " ".equals(c)){
				index = index-1;
			}else{
				break;
			}
		}
		return index;
	}

}


//System.out.println(s.length());
//System.out.println(s.substring(1, s.length()-1));