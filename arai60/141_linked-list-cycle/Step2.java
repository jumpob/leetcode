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

class Step2 {
  public boolean hasCycle(ListNode head) {  
    // リストの要素が0もしくは1の場合の場合は循環リストとしてみなさない
    if (head == null || head.next == null) return false;
    
    Set<Integer> nodeSet = new HashSet<>();
    
    while(head != null) {
      if(nodeSet.contains(head.val)) {
        return true;
      }
      nodeSet.add(head.val);
      head.next = head;
    }

    return false;
  }
}
