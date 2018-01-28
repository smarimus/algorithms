package com.ik.string.session;

public class TrieBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/*public static class Trie{
		Map<Character, Trie> child = new HashMap<Character, Trie>(); 
		Trie(Character c, Trie trie){
			child.put(c, trie);
		}
		Trie(Character c){
			child.put(c, new Trie());
		}
		Trie(){
		}
		
		public Map<Character, Trie> getChild(){
			return child;
		}
	}*/
	
	public static class Trie{
		char[] node = new char[26];
	}
	
	
}