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
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tmp = head;
        HashSet<ListNode> set = new HashSet<>();
            // System.out.println();
        while(tmp != null) {
            if(set.contains(tmp)) {
                return true;
            }
            set.add(tmp);
            tmp = tmp.next;
        }
        return false;
    }
}