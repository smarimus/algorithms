package com.ik.array.tt;

public class DetectPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {6, 2, 5, 8};
		
		System.out.println(detect_primes(a));

	}
	
	static String detect_primes(int[] a) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			
			int val = a[i];
			
			if(isPrime(val)){
				sb.append(1);
			} else{
				sb.append(0);
			}
		}
		return sb.toString();
    }
	
	//https://stackoverflow.com/questions/1801391/what-is-the-best-algorithm-for-checking-if-a-number-is-prime
	// Sieve of Eratosthenes
	
	
	//http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
	static boolean isPrime(long n) {
	    // fast even test.
	    if(n > 2 && (n & 1) == 0)
	       return false;
	    // only odd factors need to be tested up to n^0.5
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) 
	            return false;
	    return true;
	}

}
