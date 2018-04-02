package com.ik.tree.part2;

import com.ik.tree.session.BST;
import com.ik.tree.session.Node;

/*
Given a binary tree, populate nextRight pointers in each node. 
 
Constraint: Use only constant extra space.
 
e.g. Given this:
         a
       /  \
      b    c
     / \    \
    d   e    f
 
Turn it into this:
         a -> nil
       /  \
      b -> c -> nil
     / \    \
    d -> e -> f -> nil
    
 */
public class SiblingPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		populateSiblingPointer(root); 
	}
	
	static void populateSiblingPointer(Node<Integer> root){
		
		Node<Integer> head = null; //head of the next level
		Node<Integer> prev = null; //the leading node on the next level
		Node<Integer> cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
	}
	
	static void populateRightPointer(Node rootNode){
		
		if(rootNode == null) return;
		
		populateRightPointer(rootNode.right);
		
		if(rootNode.left != null && rootNode.right != null){
			twoChildLink(rootNode);
		}else{
			oneChildLink(rootNode);
		}
		
		populateRightPointer(rootNode.left);
		
	}
	
	static void twoChildLink(Node node){
		if(node.left != null && node.right != null){
			Node left = node.left;
			Node right = node.right;
			left.next = right;
			
			Node next = node.next;
			node.left.next = next.right;
		}
	}
	
	static void oneChildLink(Node node){
			if(node.left != null){
				Node next = node.next;
				node.left.next = next.right;
			}else{
				Node right = node.next;
				node.right.next = right.right;
			}
	}
}