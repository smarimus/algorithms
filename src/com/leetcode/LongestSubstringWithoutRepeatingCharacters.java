package com.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(getLength("geeksforgeeks"));
		System.out.println("geeksforgeabcdxyzfgh");
		System.out.println(getLength("geeksforgeabcdxyzfgh"));

	}
	

    static final int NO_OF_CHARS = 256;
	public static int getLength(String str){
		
		int n = str.length();
        int cur_len = 1;    // length of current substring
        int max_len = 1;    // result
        int prev_index;        //  previous index
        int i;
        int visited[] = new int[NO_OF_CHARS];
         
        /* Initialize the visited array as -1, -1 is 
         used to indicate that character has not been 
         visited yet. */
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }
         
        /* Mark first character as visited by storing the
             index of first   character in visited array. */
        visited[str.charAt(0)] = 0;
        
        for(i = 1; i < n; i++){
            prev_index = visited[str.charAt(i)];
            
            if( prev_index != -1 && (i - cur_len > prev_index)){System.out.print(" -- ");}
            System.out.println(i + " cur_len: " + cur_len +" " + " prev_index: " +prev_index + " ch: " + str.charAt(i) + "  " +  (i - cur_len) + " " + (i - cur_len > prev_index));
            
            if(prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else{
                if(cur_len > max_len){
                    max_len = cur_len;
                }
                 
                System.out.println(" cur_len before:   " + cur_len +"  after: " + (i - prev_index));
                cur_len = i - prev_index;
            }
            // update the index of current character
            visited[str.charAt(i)] = i;
        }
         
        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if(cur_len > max_len)
            max_len = cur_len;
         
        return max_len;
		
	}

}