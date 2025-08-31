/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode res = head;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null) {
            while(fast != null) {
                if(slow.val == fast.val) {
                    fast = fast.next;
                } else {
                    slow.next = fast;
                    slow = fast;
                    break;
                }
            }
        }
        slow.next = fast;
        return res;
    }
}