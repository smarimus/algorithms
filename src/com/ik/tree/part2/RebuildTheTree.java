package com.ik.tree.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ik.tree.session.BSTUtil;
import com.ik.tree.session.Node;

public class RebuildTheTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> root = BSTUtil.getBST();
		
		List<Node<Integer>> inOrder = new ArrayList<Node<Integer>>();
		inOrderTraverseInArr(root, inOrder);
		System.out.println();
		
		// PreOrder
		List<Node<Integer>> preOrder = new ArrayList<Node<Integer>>();
		preOrderTraverseInArr(root, preOrder);
		Node<Integer> newRoot1 = constructFromPreorder(inOrder, preOrder);
		BSTUtil.preOrderTravers(newRoot1);
		
		System.out.println();
		
		// PreOrder
		List<Node<Integer>> postOrder = new ArrayList<Node<Integer>>();
		postOrderTraverseInArr(root, postOrder);
		Node<Integer> newRoot2 = constructFromPostOrder(inOrder, postOrder);
		BSTUtil.preOrderTravers(newRoot2);
		
	}
	
	public static Node<Integer> constructFromPreorder(List<Node<Integer>> inOrder, List<Node<Integer>> preOrder){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inOrder.size(); i++) {
			map.put(inOrder.get(i).getValue(), i);
		}
		
		Iterator<Node<Integer>> itr = preOrder.iterator();
		Node<Integer> newRoot = buildTree(map, itr, 0, preOrder.size()-1);
		
		return newRoot;
	}
	
	public static Node<Integer> constructFromPostOrder(List<Node<Integer>> inOrder, List<Node<Integer>> postOrder){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inOrder.size(); i++) {
			map.put(inOrder.get(i).getValue(), i);
		}
		
		Collections.reverse(postOrder);
		
		System.out.println();
		Iterator<Node<Integer>> itr = postOrder.iterator();
		Node<Integer> newRoot = buildTreePost(map, itr, 0, postOrder.size()-1);
		
		return newRoot;
		
	}
	
	public static Node<Integer> buildTree(Map<Integer, Integer> map,
			Iterator<Node<Integer>> itr , int start, int end){
		
		if(start > end){
			return null;
		}
		
		Node<Integer> node = null;
		if(itr.hasNext()){
			node = itr.next();
		}else{
			return null;
		}
		
		Node<Integer> root = new Node<Integer>(node.getValue());
		int index = map.get(node.getValue());
		
		Node<Integer> left = buildTree(map, itr, start, index-1);
		Node<Integer> right = buildTree(map, itr, index+1, end);
		root.setLeft(left);
		root.setRight(right);
		
		return root;
	}
	
	public static Node<Integer> buildTreePost(Map<Integer, Integer> map,
			Iterator<Node<Integer>> itr , int start, int end){
		
		if(start > end){
			return null;
		}
		
		Node<Integer> node = null;
		if(itr.hasNext()){
			node = itr.next();
		}else{
			return null;
		}
		
		Node<Integer> root = new Node<Integer>(node.getValue());
		int index = map.get(node.getValue());
		
		Node<Integer> right = buildTreePost(map, itr, index+1, end);
		Node<Integer> left = buildTreePost(map, itr, start, index-1);
		
		root.setLeft(left);
		root.setRight(right);
		
		return root;
	}
	

	public static void inOrderTraverseInArr(Node<Integer> n, List<Node<Integer>> list){
		if(n==null) return;
		inOrderTraverseInArr(n.getLeft(), list);
		list.add(n);
		inOrderTraverseInArr(n.getRight(), list);
	}
	
	public static void preOrderTraverseInArr(Node<Integer> n, List<Node<Integer>> list){
		if(n==null) return;
		list.add(n);
		preOrderTraverseInArr(n.getLeft(), list);
		preOrderTraverseInArr(n.getRight(), list);
	}
	
	public static void postOrderTraverseInArr(Node<Integer> n, List<Node<Integer>> list){
		if(n==null) return;
		postOrderTraverseInArr(n.getLeft(), list);
		postOrderTraverseInArr(n.getRight(), list);
		list.add(n);
	}
}

