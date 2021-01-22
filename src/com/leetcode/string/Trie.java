package com.leetcode.string;

class Trie {

    Data[] head; 
    /** Initialize your data structure here. */
    public Trie() {
        head = new Data[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Data[] temp = head;
        char[] arr = word.toCharArray();
        
        for(int i=0; i< arr.length; i++){
            int val = Character.getNumericValue(arr[i]) - Character.getNumericValue('a'); ;
            if(temp[val] != null ){
                temp = temp[val].next;
            }else{
                Data data = new Data();
                temp[val] = data;
                temp = data.next;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
    	Data[] temp = head;
        char[] arr = word.toCharArray();
        
        int i=0;
        while(i< arr.length){
            int val = Character.getNumericValue(arr[i]);
            if(temp[val] != null ){
                temp = temp[val].next;
            }
            i++;
        }
        return i == arr.length-1;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return true;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("sudhakar");
    	System.out.println(trie.search("sudhakar"));
    }
}

class Data{
    Data[]  next = new Data[26];
    Data(){}
}

