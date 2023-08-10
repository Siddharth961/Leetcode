class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

class MyCircularQueue {

    Node head;
    Node tail;
    int size=0;
    int max=0;

    public MyCircularQueue(int k) {
        max = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;



        Node temp = new Node(value);
        if(head==null) head=tail=temp;
        else{
            tail.next=temp;
            tail = temp;
        }
        size ++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        
        if(head==tail) head=tail=null;
        else{
        head = head.next;
        
        }

        size--;
        return true;
    }
    
    public int Front() {
         if(isEmpty()) return -1;

        
        return head.val;
    }
    
    public int Rear() {
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */