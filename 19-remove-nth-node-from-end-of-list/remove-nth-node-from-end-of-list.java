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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int pos = length(head) - n;

        // Remove the head
        if (pos == 0) {
            return head.next;
        }

        ListNode temp = head;

        // Move to the node before the one to remove
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        // Skip the node
        temp.next = temp.next.next;

        return head;
    }

    private int length(ListNode head) {

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }
}