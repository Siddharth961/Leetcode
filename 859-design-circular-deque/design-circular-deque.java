class Node {
    int val;
    Node next, prev;
    Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {
    Node head;
    Node tail;
    int size=0;
    int max=0;

    public MyCircularDeque(int k) {
        max = k;
    }
    
    public boolean insertFront(int value) {

        if(isFull()) return false;



        Node temp = new Node(value);
        if(head==null) head=tail=temp;
        else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size ++;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        
        if(isFull()) return false;

        Node temp = new Node(value);
        if(head==null) head=tail=temp;
        else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }

        size++;

        return true;
        
    }
    
    public boolean deleteFront() {

        if(isEmpty()) return false;
        if(head==tail) head=tail=null;
        else{
        head = head.next;
        head.prev = null;
        }

        size--;
        return true;
        
    }
    
    public boolean deleteLast() {

        if(isEmpty()) return false;

        if(head==tail)head=tail=null;

        else{
        tail = tail.prev;
        tail.next = null;

        }

        

        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;

        
        return head.val;
    }
    
    public int getRear() {
        if(isEmpty()) return -1;

        
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(size==0)return true;
        else return false;
    }
    
    public boolean isFull() {
        if(size==max)return true;
        else return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */