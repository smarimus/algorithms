package com.general;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    //boolean word = false;
    //Map<Character, Trie> map = new HashMap<Character, Trie>();
    TrieNode root = new TrieNode();

    public Trie() {
    }
    
    public void insert(String word) {
        char[] wordArray = word.toCharArray();

        Map<Character, TrieNode> currRoot = root.getNode();

        TrieNode t = null;
        for (int i =0; i<wordArray.length; i++ ) {
            char c = wordArray[i];
            
            if(currRoot.containsKey(c)){
                t = currRoot.get(c);
                currRoot = t.getNode();
            }else{
                TrieNode obj = new TrieNode();
                currRoot.put(c, obj);
                currRoot = obj.getNode();
                t = obj;
            }
        }
        t.setIsWord(true);
    }
    
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();

        Map<Character, TrieNode> currRoot = root.getNode();

        for (int i=0; i<wordArray.length; i++ ) {
            char c = wordArray[i];

            TrieNode t = currRoot.get(c);
            if(t == null){
                return false;
            }
            if(i == wordArray.length-1){
                return t.isWord();
            }
            currRoot = t.getNode();
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        char[] wordArray = prefix.toCharArray();

        Map<Character, TrieNode> currRoot = root.getNode();

        for (int i=0; i<wordArray.length; i++ ) {
            char c = wordArray[i];

            TrieNode t = currRoot.get(c);
            if(t == null && i != wordArray.length-1){
                return false;
            }
            currRoot = t.getNode();
        }
        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
        System.out.println(trie.search("sudhakar"));     // return false
        trie.insert("sudhakar");
        System.out.println(trie.search("sudhakar"));

    }

    private class TrieNode{
        private boolean isWord = false;
        private Map<Character, TrieNode>  node = new HashMap<>();

        public Map<Character, TrieNode> getNode() {
            return node;
        }

        public void setNode(Map<Character, TrieNode> node) {
            this.node = node;
        }

        public boolean isWord() {
            return isWord;
        }
        public void setIsWord(boolean isWord){
            this.isWord = isWord;
        }
        
    }

}


// search
// starts with

