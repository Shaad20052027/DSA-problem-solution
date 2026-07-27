/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = length(headA);
        int lenB = length(headB);
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 0; i < lenB - lenA; i++){
                tempB = tempB.next;
            }
        }
        while(tempA != null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
    public int length(ListNode node){
        if(node == null){
            return 0;
        }
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}