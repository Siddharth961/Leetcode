/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)return null;
        Node tail = connector(head);
        return head;
    }

    public Node connector(Node head){
        Node i = head;
        while(i.next!=null){

            

            if(i.child!=null){
                Node j = i.next;
                i.next = i.child;
                i.child.prev = i;

                Node ctail = connector(i.child); //getting tail of child list

                ctail.next = j;
                j.prev = ctail;
                i.child = null;
                i = j;
            }

            else i=i.next;
        }
        if(i.next==null&&i.child!=null){
                
                i.next = i.child;
                i.child.prev = i;
                i.child=null;
                return connector(i.next);
            }

        return i;//returning the tail
    }
}