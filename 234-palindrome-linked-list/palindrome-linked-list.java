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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = midnode(head);
        ListNode headsecond = reverseList(mid);
        ListNode rereversehead = headsecond;
        while(head != null && headsecond != null){
            if(head.val != headsecond.val){
                break;
            }
            head = head.next;
            headsecond = headsecond.next;
        }
        reverseList(rereversehead);
        return head == null || headsecond == null;
    }
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode present = head;
        ListNode prev = null;
        ListNode next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    public ListNode midnode(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}