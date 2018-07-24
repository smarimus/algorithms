package com.ik.string.session;

public class TriesAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String w = "sudhakar";
		String w1 = "sudha";
		String w2 = "sudharam";
		
		Trie t = createTrieNode(w1.toCharArray());
		t = createTrieNode(w.toCharArray());
		t = createTrieNode(w2.toCharArray());
		
		System.out.println("printing.....");
		System.out.println(printWord(t, "sudhakar"));
		System.out.println(printWord(t, "sudha"));
		System.out.println(printWord(t, "sudharam"));

	}
	
	static private Trie root = new Trie();
	
	static Trie  createTrieNode(char[] c){
		
		Trie curr = root;
		for (int i = 0; i < c.length; i++) {
			int index = c[i] - 'a' ;
			System.out.println(index + "	" + c[i] + "  "+ 'a');
			Trie obj = curr.node[index];
			if(obj == null){
				Trie tri = new Trie();
				curr.node[index] = tri;
				curr = tri;
			}else{
				curr = obj;
			}
		}
		curr.isWord = true;
		return root;
	}
	
	static boolean printWord(Trie t, String word){
		
		Trie cur = t;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index =  c - 'a' ;
			System.out.println(index);
			Trie node = cur.node[index];
			if(node == null){
				return false;
			}else{
				cur = node;
			}
		}
		return true;
	}
	
	static class Trie{
		Trie[] node = new Trie[26];
		boolean isWord = false;
	}
}

