package com.ik.array.part2;

public class HummingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//String s ="12344555";
		
		
	}
}

/*
We're given a large array of 4-byte integers. We need to write a method to find out how many total bits are turned on (i.e. 1s are set) 
inside such an array. [Such a digital sum of binary representation of a number, is also called its Hamming Weight].
 
e.g.
1. if input array has two numbers: 31 and 51, the answer is 9, because 31 has 5 bits turned on (out of 32) and 51 has 4. 
2. if the input is 2147483647 and 3, the answer is 31 + 2 = 33
 
We're looking for a fast solution, even if it uses extra memory. 
While it is possible to optimize solutions based on the machine architecture,
we're not looking for intense bit-hackery. 
Assume input in base-10. No floating points.
 
Hint: Think hash tables.
*/