import java.util.*;

/**
 * Definition for singly-linked list.
 */ 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Step3 {
  public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null) return false;

    Set<Integer> nodeSet = new HashSet<>();
    while(head != null) {
      if(nodeSet.contains(head.val)) {
        return true;
      }
      nodeSet.add(head.val);
      head = head.next;
    }
    return false;
  }
}
