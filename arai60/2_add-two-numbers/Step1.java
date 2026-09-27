class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Step1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        int carry = 0;

        // l1かl2のいずれかが空になるまで
        // 加えて、いずれも空であっても桁上りがあれば続行(結果のLinkedListに加える必要がある)
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 == null && l2 == null) {
                sum = carry;
            }
            else if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;

            carry =  sum / 10;
        }
        return head.next;
    }
}
