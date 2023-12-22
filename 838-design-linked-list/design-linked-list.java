class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(){

        }
        Node(int data){
            val = data;
        }
    }

    Node head;
    Node tail;

    int size=0;

    public MyLinkedList() {
        
    }
    
    public int get(int idx) {
        if(idx<0 || idx>=size) return -1;
        Node ptr = head;
        int count = 0;

        while(count != idx){
            ptr = ptr.next;
            count++;
        }

        return ptr.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        if(head==null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }

        size++;
    }
    
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head==null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }

        size++;
    }
    
    public void addAtIndex(int idx, int val) {
        if(idx==0){
            addAtHead(val);
            return;
        }

        if(idx>size || idx<0) return;

        Node temp = new Node(val);

        if(idx==size){
            tail.next = temp;
            tail = temp;
        }
        else{
            int count = 0;
            Node ptr = head;
            while(count+1 < idx){
                ptr = ptr.next;
                count++;
            }

            temp.next = ptr.next;
            ptr.next = temp;
        }

        size++;

    }
    
    public void deleteAtIndex(int idx) {
        if(idx<0 || idx>=size){
            return;
        }
        
        if(idx==0) head = head.next;
        else{
            Node ptr = head;
            int count = 0;
            while(count+1 < idx){
                ptr = ptr.next;
                count++;
            }


            ptr.next = ptr.next.next;
            if(idx==size-1) tail = ptr;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */