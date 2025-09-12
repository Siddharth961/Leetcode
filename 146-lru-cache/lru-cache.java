class LRUCache {

    int size = 0;
    int capacity ;

    HashMap<Integer, Node> mp;

    Node head = null;
    Node tail = head;    

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        mp = new HashMap<>();    
    }
    
    public void reposition(Node n){
        if(head == n) return; // 1st element

        if( tail == n){ // last element

            tail = n.prev;
            tail.next = null;

            n.prev = null;
            n.next = head;
            head.prev = n;

            head = n;

            return;

        }

        // in between list

        n.prev.next = n.next;

        n.next.prev = n.prev;

        n.prev = null;
        n.next = head;
        head.prev = n;

        head = n;

        return;
    }


    public int get(int key) {

        // System.out.println(mp);
        
        if( !mp.containsKey( key ) ) return -1; // 0 elements in list

        Node n = mp.get(key);

        reposition(n);

        return n.val;       


    }
    
    public void put(int key, int value) {

        // System.out.println(mp);

        
        if(mp.containsKey( key )){
            Node n = mp.get(key);

            n.val = value; 
            reposition(n);
        }
        else{

            size++;

            Node n = new Node(key, value);

            mp.put(key, n);


            if(head == null){ // if 0 elements
                head = n;
                tail = n;
                return;
            }

            // more than 0 elements

            n.next = head;
            head.prev = n;
            head = n;

            
        }

        //handling size limits

        if(size>capacity){

            mp.remove(tail.key);
            tail = tail.prev;
            tail.next = null;


            size--;
        }
    }
}

public class Node{
        Node prev;
        Node next;
        int val;
        int key;

        Node(int k, int v){
            key = k;
            val = v;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */