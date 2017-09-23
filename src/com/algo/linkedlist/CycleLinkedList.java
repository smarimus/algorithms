package com.algo.linkedlist;

public class CycleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static boolean findCycle(Node node){
		Node slow = null;
		Node fast = null;
		while(slow.next != null &&  fast.next != null){
			
			slow = node.next;
			fast = node.next.next;
			
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
	
	static int findLength(Node node){
		int index =0;
		
		Node slow = null;
		Node fast = null;
		while(slow.next != null &&  fast.next != null){
			
			slow = node.next;
			fast = node.next.next;
			
			index++;
			
			if(slow == fast){
				return index;
				
			}
		}
		return index;
	}
	
	static int startAddress(Node node){
		int index =0;
		
		Node slow = null;
		Node fast = null;
		while(slow.next != null &&  fast.next != null){
			
			slow = node.next;
			fast = node.next.next;
			
			index++;
			
			if(slow == fast){
				return index-1;
				
			}
		}
		return index-1;
	}
	/*ListNode* GetLoopStart(ListNode* head)
	{
	    ListNode *slow = head, *fast = head;
	    auto cycleSize = GetCycleSize(head, slow, fast);
	    if (cycleSize == 0) {
	        // list has no cycle
	        return nullptr;
	    }
	    else
	    {
	        return fast;
	    }
	}*/

	private class Node{
		int value;
		Node next;
		
		Node(int value, Node next){
		}
	}
}

