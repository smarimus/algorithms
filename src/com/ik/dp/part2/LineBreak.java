package com.ik.dp.part2;

public class LineBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String words[] = { "aaa",
		"bb", "cc", "ddddd" };
	String words1[] = { "bb", "cc"};
	String words2[] = {"aa"};
	
	System.out.println(lineBreak(words1, 0, 0, 5).str);
	
	}
	
	static class Result{
		private  int cost;
		private String str;
		Result(String str, int cost){
			this.cost = cost;
			this.str = str;
		}
	}
	
	public static Result lineBreak(String words[], int index, int startCol, int maxWidth){
		if (words.length == index){
			return new Result("", 0);
		}
		
		String word = words[index];
		//int rest = words[1:];
		int endCol = word.length() + startCol;
		
		if(endCol > maxWidth)
			return new Result("", Integer.MAX_VALUE);
		
		//no line break
		Result r1 = lineBreak(words, index+1,  endCol+1, maxWidth);
		r1.str = word + " " + r1.str;
		
		//yes line break
		Result r2 = lineBreak(words, index+1, 0, maxWidth);
		r2.str = word + System.getProperty("line.separator")  + r2.str;
		
		r2.cost += Math.pow(maxWidth - endCol, 3);
		
		System.out.println("r1: " + r1.cost + " r2:" + r2.cost);
		if(r1.cost <= r2.cost){
			return r1;
		}
		return r2;
	}
}