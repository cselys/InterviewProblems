package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import fantasist.InterviewProblems.leetcode.utils.ListNode;

public class MergeKSortedLists {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty())
        	return null;
        
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val < n2.val)
					return -1;
				else if (n1.val > n2.val)
					return 1;
				else
					return 0;
			}
		};
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < lists.size(); i++) {
        	ListNode node = lists.get(i);
        	if (node != null)
        		heap.add(lists.get(i));
        }
        while(!heap.isEmpty()) {
        	if (head == null) {
        		head = heap.poll();
        		cur = head;
        		if (cur.next != null)
        			heap.add(cur.next);
        	} else {
        		ListNode newNode = heap.poll();
        		cur.next = newNode;
        		cur = newNode;
        		if (cur.next != null)
        			heap.add(cur.next);
        	}
        }

        return head;
    }
	
	public static void main(String[] args) {
		MergeKSortedLists m = new MergeKSortedLists();
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode n = new ListNode(1);
		ListNode n2 = new ListNode(0);
		n2.next = new ListNode(2);
		lists.add(n);
		lists.add(n2);
		ListNode head = m.mergeKLists(lists);
		ListNode.printList(head);
	}

}
