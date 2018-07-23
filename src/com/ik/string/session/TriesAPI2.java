package com.ik.string.session;

public class TriesAPI2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String w = "sudhakar";
		String w1 = "sudhakar is great";
		String w2 = "sudharam";
		
		Trie t = createTrieNode(w1.toCharArray());
		createTrieNode(w1.toCharArray());
		//t = createTrieNode(w.toCharArray());
		//t = createTrieNode(w2.toCharArray());
		
		System.out.println("printing.....");
		System.out.println(printWord(t, "sudhakar".toCharArray()));
		//System.out.println(printWord(t, "sudha"));
		//System.out.println(printWord(t, "sudharam"));

	}
	
	static private Trie root = new Trie();
	
	static Trie  createTrieNode(char[] c){
		
		Trie curRoot = root; 
		for (int i = 0; i < c.length; i++) {
			int index = c[i] - 'a';
			curRoot.node[index] = new Trie();
			curRoot = curRoot.node[index];
		}
		return root;
	}
	
	static boolean printWord(Trie t, char[] c){
		StringBuilder sb = new StringBuilder();
		
		Trie curRoot = root; 
		for (int i = 0; i < c.length; i++) {
			int index = c[i] - 'a';
			Trie node = curRoot.node[index];
			if(node != null){
				curRoot = node;
			}else{
				return false;
			}
			sb.append(c[i]);
		}
		System.out.println(sb.toString());
		return true;
	}
	
	static class Trie{
		Trie[] node = new Trie[26];
		boolean isWord = false;
	}
}

