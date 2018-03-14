package com.ik.tree.session;

public class BST {

	public static void main(String[] args) {		
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
		
		Node<Integer> n = bst.find(root, 55);
		System.out.println( ( n != null ? n.value : null ) );
		
		bst.inOrderTraverse(root);
		
		bst.delete(root, null, 25);
		System.out.println();
		
		bst.inOrderTraverse(root);
	}
	
	Node<Integer> root = null;
	
	public void delete(Node<Integer> root, Node<Integer> parent, int deleteItem){
		if(root == null) return;
		
		if(root.value > deleteItem){
			delete(root.left, root, deleteItem);
		}else if(root.value < deleteItem ){
			delete(root.right, root, deleteItem);
		}
		
		Node<Integer> deleteNode = root;
		
		if(deleteNode.value == deleteItem){
			if(deleteNode.left == null && deleteNode.right == null){
				reArrange(parent, deleteItem, -1);
			}else if(deleteNode.left == null || deleteNode.right == null){
				if(deleteNode.left == null)
					reArrange(parent, deleteItem, deleteNode.right.value);
					deleteNode.right = null;
				if(deleteNode.right == null)
					reArrange(parent, deleteItem, deleteNode.left.value);
					deleteNode.left = null;
			}else{
				Node<Integer> maxNode = max(deleteNode.left);
				deleteNode.value = maxNode.value;
				delete(deleteNode.left, deleteNode, maxNode.value);
			}
		}
	}
	
	public Node<Integer> inorderSuccessor1(Node<Integer> root, Node<Integer> node){
		
		if(node.right != null){
			return min(node.right);
		}
		
		Node<Integer> successor = null;
		while(root.left != null){
			
			if(root.value > node.value){ //left
				successor = root;
				root = root.left;
			}else if(root.value < node.value){ //right
				root = root.right;
			}else{
				break;
			}
		}
		return successor;
	}
	
	// parent reference
	public Node<Integer> inorderSuccessor2(Node<Integer> root, Node<Integer> node){
		if(node.right != null){
			return min(node.right);
		}
		
		/*Node<Integer> p = node.parent; 
		while(p != null && node == p.right){
			node = p;
			p = p.parent
		}
		return p;*/ return null;
	}
	
	public void add(Node<Integer> root, int toBeAdded){
		
		if(root == null){
			root = new Node<Integer>(toBeAdded);return;
		}
		if(root.value > toBeAdded){
			//left
			if(root.left == null) {
				root.left = new Node<Integer>(toBeAdded);
				return;
			}else{
				add(root.left, toBeAdded);
			}
		}else if(root.value < toBeAdded){
			//right
			if(root.right == null) {
				root.right = new Node<Integer>(toBeAdded);
				return;
			}else{
				add(root.right, toBeAdded);
			}
		}
	}

	//Delete single item
	private void reArrange(Node<Integer> parent, int deleteItem, int newValue) {
		if(parent.left != null && parent.left.value == deleteItem){
			if(newValue == -1){
				parent.left = null;
			}else{
				parent.left.value = newValue; 
			}
		}
		if(parent.right != null && parent.right.value == deleteItem) {
			if(newValue == -1){
				parent.right = null;
			}else{
				parent.right.value = newValue; 
			}
		}
	}
	
	public Node<Integer> find(Node<Integer> n, int toBeFound){
		Node<Integer> result = null;
		if(n == null) return null;
		if(n.value == toBeFound) 
			return n; 
		if(n.value > toBeFound)
			//left
			result = find(n.left, toBeFound);
		if(n.value < toBeFound)
			result = find(n.right, toBeFound);
		return result;
	}
	
	public Node<Integer> min(Node<Integer> n){
		
		if(n == null) return null;
		if(n.left == null){
			return n;
		}
		return min(n.left);
	}
	
	public Node<Integer> max(Node<Integer> n){
		if(n == null) 
			return null;
		if(n.right == null){
			return n;
		}
		return max(n.right);
	}
	
	public void inOrderTraverse(Node<Integer> n){
		if(n==null) return;
		inOrderTraverse(n.left);
		System.out.print(n.value + " ,");
		inOrderTraverse(n.right);
	}
}
