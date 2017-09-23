package com.interview;

import java.util.Collections;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Object,Object> map = Collections.emptyMap();
		
		//map.put("Sudhakar", "Sudhakar");
		int offset =-1;
		assert offset >= 0 && offset <=10;
		
		System.out.println(test());

	}
	
	static int test(){
		try{
			Integer a = new Integer(1);
			Integer b = new Integer(1);
			if(a == b){
				System.out.println("test");
			}
			
			if(a.equals(b)){
				System.out.println("test one");
			}
		}catch(Exception ex){
			return 2;
		}finally{
			return 3;
		}
	}
}