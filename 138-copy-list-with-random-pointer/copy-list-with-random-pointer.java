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
        if(head==null)return null;
        Node chead = new Node(100);
        chead = deepcopy(head,chead);
        // System.out.println(chead.val);

        Node thead = new Node(100);
        Node t = thead;
        Node ptr1 = head;
        Node ptr2 = chead;

        while(ptr1!=null){
            t.next  = ptr1;
            ptr1 = ptr1.next;
            t = t.next;

            t.next = ptr2;
            ptr2 = ptr2.next;
            t = t.next;
        }

        ptr1=head;

        while(ptr1!=null){

            if(ptr1.random==null)ptr1.next.random = null;
            else ptr1.next.random = ptr1.random.next;
            ptr1 = ptr1.next.next;
        }

        System.out.println(head.next.val);
        ptr1 = head;
        ptr2 = chead;
        while(ptr2!=null){
            ptr1.next = ptr2.next;
            ptr1 = ptr1.next;
            if(ptr1 == null)break;
            ptr2.next = ptr1.next;
            ptr2 = ptr2.next;
        }

        return chead;
    }

    public Node deepcopy(Node head, Node chead){
        Node temp = chead;
        Node ptr  = head;

        while(ptr!=null){
            Node dummy = new Node(ptr.val);
            temp.next = dummy;
            temp = dummy;
            ptr = ptr.next;
        }
        // System.out.println(temp.val);

        return chead.next;

    }
}