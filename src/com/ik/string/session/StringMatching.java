package com.ik.string.session;

import java.util.Arrays;
import java.util.Comparator;

public class StringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.stream(buildTable("aabaabaaa")).forEach(e -> System.out.print(e));
		System.out.println("");
		System.out.println("010123452");
		
		Arrays.stream(buildTable("abcdabeabf")).forEach(e -> System.out.print(e));
		System.out.println("");
		Arrays.stream(buildTable("abcdeabfabc")).forEach(e -> System.out.print(e));
		System.out.println("");
		Arrays.stream(buildTable("aabcadaabe")).forEach(e -> System.out.print(e));
		System.out.println("");
		Arrays.stream(buildTable("aaaabaacd")).forEach(e -> System.out.print(e));
		
		System.out.println(kmpPatternMatching("abxabcabcaby", "abcaby") );
		
		//Arrays.sort(a, c);
	}
	
	private static boolean kmpPatternMatching(String s, String p) {
		int[] table = buildTable(p);
		
		int i,j;
		i = j = 0;
		while(i<s.length()){
			
			if(s.charAt(i) == p.charAt(j)){
				j++;i++;
			}else{
				if(j == 0){
					i++; continue;
				}else{
					j = table[j-1];
				}
			}
			if(j == p.length()) break;
		}
		return (j == p.length() ? true : false );
	}
	
	private static int[] buildTable(String p) {
		int count[] = new int[p.length()];
		
		count[0] = 0;
		int j=0;
		int i=1;
		for (int k= 1; k < p.length(); ) {
			if(p.charAt(j) == p.charAt(i)){
				count[k] = j+1;
				k++; i++; j++;
			}else if(p.charAt(j) != p.charAt(i)){
				
				if(j==0){
					i++;
					count[k] = 0;
					k++;
				}else{
					j = count[j-1];
				}
			}
		}
		return count;
	}
	

	public static boolean bruteForceMatching(String s, String p) {
		
		boolean found = false;
		for (int i = 0; i < s.length(); i++) {
			
			int innerCount=i;
			for (int j = 0; j < p.length(); j++) {
				
				if(s.charAt(innerCount) == p.charAt(j)){
					innerCount++;
					
					if(p.length() == innerCount){
						System.out.println("");
						found = true;
						break;
					}
				}
			}
			String ss = new String();
			
			if(found)break;
		}
		return found;
	}
	
	public int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
        Arrays.sort(costs, comparator);
        
        int N = costs.length / 2,
                c1 = 0,// counter for the station A
                c2 = 0,// counter for the station B
                ans = 0,
                i = 0;
        
        while (i < 2 * N) {
            if ((costs[i][0] <= costs[i][1] && c1 < N) || c2 == N) {
                ans += costs[i++][0];
                c1++;
            } else {
                ans += costs[i++][1];
                c2++;
            }
        }
        
        return ans;
    }
}

