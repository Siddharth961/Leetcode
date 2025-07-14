class Solution {
    public class Node{
        char val;
        Node next;
        Node prev;

        Node(char v){
            val = v;

        }
    }
    public String processStr(String s) {

        Node head = null;
        Node tail = head;
        boolean ltr = true;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if( c != '*' && c!='#' && c!='%'){
                if(head == null){
                    head = new Node(c);
                    tail = head;
                }
                else{

                    Node temp = new Node(c);
                    if(ltr){
                        tail.next = temp;
                        temp.prev = tail;

                        tail = temp;
                    }
                    else{
                        head.prev = temp;
                        temp.next = head;

                        head = temp;
                    }
                }
            }

            else if( c == '*' && head != null){
                if(ltr){
                    if(tail.prev != null){
                        tail = tail.prev;
                        tail.next = null;
                    }

                    else{
                        head = null;
                        tail = null;
                    }
                }

                else{
                    if(head.next != null){
                        head  = head.next;
                        head.prev = null;
                    }
                    else{
                        head = null;
                        tail = null;
                    }
                }
            }

            else if( c == '#'){

                if(head == null)continue;

                if(ltr){
                    tail = duplicate(ltr, head, tail);
                }
                else{
                    head = duplicate(ltr, head, tail);

                }

            }

            else if( c == '%'){
                ltr = !ltr ;
            }

        }

        StringBuilder sb = new StringBuilder();

        if(ltr){
            Node ptr = head;
            while(ptr != null){
                sb.append(ptr.val);

                ptr = ptr.next;
            }
        }

        else{
            Node ptr = tail;

            while(ptr != null){
                sb.append(ptr.val);

                ptr = ptr.prev;
            }
        }

        return sb.toString();
        
    }

    public Node duplicate( boolean ltr, Node og_head, Node og_tail){

        if( ltr ){

            // create a new linked list in ltr order
            Node ptr1 = og_head;

            Node ptr2 = og_tail;

            while(ptr1 != og_tail.next){
                Node temp = new Node(ptr1.val);

                ptr2.next = temp;
                temp.prev = ptr2;

                ptr2 = ptr2.next;
                ptr1 = ptr1.next;
            }

            // og_tail.next = c_head.next; // connecting both lists

            return ptr2; // as it will be new tail
        }

        else{

            // we need to make list in reverse direction
            Node ptr1 = og_tail;
            // Node c_tail = og_head;
            // Node n_head;
            Node ptr2 = og_head;

            while(ptr1 != og_head.prev){
                Node temp = new Node(ptr1.val);

                temp.next = ptr2;
                ptr2.prev = temp;

                ptr2 = temp;
                ptr1 = ptr1.prev;
            }

            return ptr2; // as it will  be new head

        }
    }
}