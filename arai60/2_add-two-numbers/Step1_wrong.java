class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 注! このコードは動かない!
class Step1_wrong {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = listToNum(l1) + listToNum(l2);

        if (sum == 0) {
            return new ListNode(0);
        }
        
        return numToList(sum);
    }

    private int listToNum(ListNode nodes) {
        int i = 0;
        int ret = 0;

        while (nodes != null) {
            ret += nodes.val * Math.pow(10, i);
            nodes = nodes.next;
            i++;
        }
        return ret;
    }

    private ListNode numToList(int num) {
        ListNode head = new ListNode(num % 10);
        num = num / 10;        
        ListNode current = head;

        while (num != 0) {
            current.next = new ListNode(num % 10);
            current = current.next;
            num = num / 10;
        }
        return head;
    }
}