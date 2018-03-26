package com.ik.tree.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

public class SerializeAndDeSerializeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*				1										25
  													/		  \	
  												  /			     \
				2							18						40	
										/		\  				   /	\
				3					10				20			36			55
								 /	  \			   /	\		/  \		/ \
				4				n		n		19		 24 |30		38	 42		n
																  /	   \
				5												37		n
*/
		BST bst = new BST();
		Node<Integer> root = new Node<Integer>(25);
		
		bst.add(root, 18);
		bst.add(root, 20);
		bst.add(root, 19);
		bst.add(root, 24);
		bst.add(root, 10);
		bst.add(root, 40);
		bst.add(root, 36);
		bst.add(root, 38);
		bst.add(root, 37);
		bst.add(root, 30);
		bst.add(root, 55);
		bst.add(root, 42);
		
		List<String> results = new ArrayList<String>();
		serialize(root, results);
		
		for(String result: results){
			System.out.print(result + " ,");
		}
		
		System.out.println();
		
		Iterator<String> itr = results.iterator();
		Node<Integer> newRoot = deserialize(results, itr);
		print(newRoot);
		
	}
	
	public static void serialize(Node<Integer> root, List<String> results ){
		if(root == null){
			results.add("#");
			return;
		}
		results.add(String.valueOf(root.getValue()));
		serialize(root.getLeft(), results);
		serialize(root.getRight(), results);
	}
	
	public static Node<Integer> deserialize(List<String> results, Iterator<String> itr){
		
		Integer value = null;
		if(itr.hasNext()){
			String s = itr.next();
			if(!"#".equals(s)){
				value = Integer.parseInt(s);
			}else{
				return null;
			}
		} 
		Node<Integer> n = new Node<Integer>(value);
		n.setLeft( deserialize(results, itr) );
		n.setRight( deserialize(results, itr) );
		
		return n;
	}
	
	public static void print(Node<Integer> root ){
		if(root == null){
			return;
		}
		System.out.print(root.getValue() + " ," );
		print(root.getLeft());
		print(root.getRight());
	}

}
