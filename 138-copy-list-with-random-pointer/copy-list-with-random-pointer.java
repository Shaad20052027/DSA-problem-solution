/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        Node prev = null;
        Node newhead = null;

        HashMap<Node, Node> map = new HashMap<>();

        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr, temp);
            if(newhead == null){
                newhead = temp;
                prev = newhead;
            }else{
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }

        curr = head;
        Node newCurr = newhead;
        while(curr != null){
            if(curr.random == null){
                newCurr.random = null;
            }else{
                newCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newhead;
    }
}