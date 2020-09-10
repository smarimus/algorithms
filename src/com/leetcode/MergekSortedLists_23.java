package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {
	
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ListNode[] ls0 = {new ListNode(1), new ListNode(4), new ListNode(5) };
		ListNode[] ls1 = {new ListNode(1), new ListNode(3), new ListNode(4) };
		ListNode[] ls2 = {new ListNode(2), new ListNode(6)};*/
		
		ListNode ls0 = new ListNode(1);
		ls0.next = new ListNode(4);
		ls0.next.next = new ListNode(5);
		
		ListNode ls1 = new ListNode(1);
		ls1.next = new ListNode(3);
		ls1.next.next = new ListNode(4);
		
		ListNode ls2 = new ListNode(2);
		ls1.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[3];
		lists[0] = ls0;
		lists[1] = ls1;
		lists[2] = ls2;

		ListNode ls = mergeKLists(lists);
		
		while(ls != null){
			//System.out.print(ls.val + " ");
			ls = ls.next;
		}
		int[] s = {3,2,3,1,2,4,4, 4,4,4,5,5,5,5,5,6};
		Arrays.sort(s);
		Arrays.stream(s).forEach(e -> System.out.print(e + " "));
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        
        // get the min and add it to the list.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Arrays.stream(lists).forEach(e -> {
			while(e!=null){
				//System.out.println(e.val);
				minHeap.add(e.val);
				e = e.next;
			}
		});
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(minHeap.peek() != null){
			//System.out.println(minHeap.peek());
			head.next = new ListNode(minHeap.poll());
			head = head.next;
		}
		return dummy.next;
    }
	
}
