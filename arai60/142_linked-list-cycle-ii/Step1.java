import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Step1 {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    Set<ListNode> nodes = new HashSet<>();
    while (head != null) {
      if (nodes.contains(head)) {
        return head;
      }

      nodes.add(head);
      head = head.next;
    }

    return null;
  }
}
