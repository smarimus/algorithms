package com.general;

public class Lazy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(init);
	}
	
	private static boolean init = false;
	
	static{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("");
				//init=true;
			}
		});
		
		t.start();
		
		try{
			t.join();
		}catch(InterruptedException e){
			throw new AssertionError(e);
		}
	}

}
