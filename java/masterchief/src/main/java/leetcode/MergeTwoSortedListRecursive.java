package leetcode;

public class MergeTwoSortedListRecursive {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            ListNode smallerNode;
            if(l1.val < l2.val){
                smallerNode = l1;
                l1 = l1.next;
            } else {
                smallerNode = l2;
                l2 = l2.next;
            }
            smallerNode.next = mergeTwoLists(l1, l2);
            return smallerNode;
        }
    }

}
