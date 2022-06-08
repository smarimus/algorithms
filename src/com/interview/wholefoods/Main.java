package com.interview.wholefoods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      //System.out.println(line);
      System.out.println(brackerChecker(line));
    }
  }
  
  public static boolean brackerChecker(String s){
    if(s.length() < 2)
      return false;
    
    Deque<String> stack = new ArrayDeque<>();
    for(int i=0; i< s.length(); i++){
      String curr =  String.valueOf(s.charAt(i));
      
      if("[".equals(curr) || "]".equals(curr) || "{".equals(curr) || "}".equals(curr)){
      
            if( curr.equals("]") || curr.equals("}") ){
              String outVal = stack.pop();
              
              if(outVal.equals(curr)){
                return false;
              }

              if(outVal.equals("[") && !curr.equals("]") ){
                return false;
              }
              if(outVal.equals("{") && !curr.equals("}") ){
                return false;
              }

            }else{
                stack.push(curr);
            }
        }
     }
     return stack.isEmpty();
  }
    
  
}
