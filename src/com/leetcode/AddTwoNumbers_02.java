package com.leetcode;

public class AddTwoNumbers_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(9 / 10);
		System.out.println(11 / 10);
		System.out.println(10 / 10);
		System.out.println(15 / 10);

		System.out.println("");

		System.out.println(9 % 10);
		System.out.println(10 % 10);
		System.out.println(11 % 10);
		System.out.println(18 % 10);

		ListNode l2 = new ListNode(9);
		// l2.next = new ListNode(9);

		ListNode l1 = new ListNode(1);
		// l1.next = new ListNode(8);
		// l1.next.next = new ListNode(2);

		ListNode res = addTwoNumbers3(l1, l2);

		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}
	}
	
	public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		int carry = 0;
		ListNode l1Curr = l1, l2Curr  = l2, curr = dummy;

		while (l1Curr != null || l2Curr != null) {
			
			int l1Val = (l1Curr != null) ? l1Curr.val : 0; 
			int l2Val = (l2Curr != null) ? l2Curr.val : 0;
			
			int sum = l1Val + l2Val + carry;
			
			carry = sum/10;
			
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
			if(l1Curr != null) l1Curr = l1Curr.next;
			if(l2Curr != null) l2Curr = l2Curr.next;
		}
		
		if (carry>0) {
			curr.next = new ListNode(carry);
			curr = curr.next;
		}
		return dummy.next;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null, resHead = null;
		boolean carr = false;
		ListNode l1Curr = l1;
		ListNode l2Curr = l2;

		while (l1Curr != null && l2Curr != null) {
			int sum = l1Curr.val + l2Curr.val;
			if (carr) {
				sum = sum + 1;
				carr = false;
			}
			if (sum >= 10) {
				carr = true;
				sum = sum % 10;
			}
			if (resHead != null) {
				resHead.next = new ListNode(sum);
				resHead = resHead.next;
			} else {
				resHead = result = new ListNode(sum);
			}

			l1Curr = l1Curr.next;
			l2Curr = l2Curr.next;
		}

		while (l1Curr != null) {
			int sum = l1Curr.val;
			if (carr)
				sum = sum + 1;
			carr = false;

			if (sum >= 10) {
				carr = true;
				sum = sum % 10;
			}
			resHead.next = new ListNode(sum);
			resHead = resHead.next;

			l1Curr = l1Curr.next;
		}

		while (l2Curr != null) {
			int sum = l2Curr.val;
			if (carr)
				sum = sum + 1;
			carr = false;

			if (sum >= 10) {
				carr = true;
				sum = sum % 10;
			}
			resHead.next = new ListNode(sum);
			resHead = resHead.next;

			l2Curr = l2Curr.next;
		}

		if (carr) {
			resHead.next = new ListNode(1);
			resHead = resHead.next;
		}

		return result;
	}
	
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}

/*
 * while(l1Curr != null){ result.next = new ListNode(l1.next.val); l1Curr =
 * l1Curr.next; }
 */