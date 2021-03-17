package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

class TrieWithMap_208 {

    Tries trieHead; 
    /** Initialize your data structure here. */
    public TrieWithMap_208() {
    	trieHead = new Tries();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        char[] arr = word.toCharArray();
        Map<Character, Tries>  tempHead  = trieHead.childrens;
        Tries pre;
        for(int i=0; i< arr.length; i++){
            //int val = Character.getNumericValue(arr[i]) - Character.getNumericValue('a'); ;
        	pre=tempHead.get(arr[i]);
            if(tempHead.get(arr[i]) != null ){
            	tempHead = tempHead.get(arr[i]).childrens;
            	if(i == arr.length-1){
            		pre.isWord = true;
            	}
            }else{
            	Tries newChild = new Tries();
            	if(i == arr.length-1){
            		newChild.isWord = true;
            	}
                tempHead.put(arr[i], newChild);
                tempHead = newChild.childrens;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
    	char[] arr = word.toCharArray();
        Map<Character, Tries>  tempHead  = trieHead.childrens;
        Tries pre;
        for(int i=0; i< arr.length; i++){
        	System.out.println(tempHead.get(arr[i]).isWord + " "+arr[i]);
        	pre=tempHead.get(arr[i]);
            if(tempHead.get(arr[i]) != null ){
            	tempHead = tempHead.get(arr[i]).childrens;
            	
            	if(i == arr.length-1 && pre.isWord){
            		return true;
            	}
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	
    	char[] arr = prefix.toCharArray();
        Map<Character, Tries>  tempHead  = trieHead.childrens;
        for(int i=0; i< arr.length; i++){
            if(tempHead.get(arr[i]) != null ){
            	tempHead = tempHead.get(arr[i]).childrens;
            	if(i == arr.length-1){
            		return true;
            	}
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	TrieWithMap_208 trie = new TrieWithMap_208();
    	
    	trie.insert("apple");
    	System.out.println(trie.search("apple"));   // returns true
    	System.out.println(trie.search("app"));     // returns false
    	System.out.println(trie.startsWith("app")); // returns true
    	trie.insert("app");   
    	System.out.println(trie.search("app"));     // returns true
    	
    }
}

class Tries{
    Map<Character, Tries>  childrens = new HashMap<>();
    boolean isWord = false;
    Tries(){}
}

