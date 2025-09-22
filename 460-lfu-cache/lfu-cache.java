class LFUCache {

    HashMap<Integer, Node> getMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    int minFreq;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        getMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = Integer.MAX_VALUE;
        size = 0;
        this.capacity = capacity;
    }

    public void updatePosition(Node n){

        int freq = n.freq;

        freqMap.get(freq).remove(n);

        if( freqMap.get(freq).size() == 0){
            freqMap.remove(freq);
            if(minFreq == freq) minFreq++;
        }

        n.freq++;

        freqMap.putIfAbsent(n.freq, new DoublyLinkedList());

        freqMap.get( n.freq ).addFirst(n);
    }
    
    public int get(int key) {
        
        if(!getMap.containsKey( key) )return -1;

        Node n = getMap.get(key);
        updatePosition(n);

        return n.value;


    }
    
    public void put(int key, int value) {
        
        if(getMap.containsKey( key )){

            Node n = getMap.get(key);
            n.value = value;

            updatePosition(n);

            return;
        }


        if( size == capacity){

            Node n = freqMap.get(minFreq).removeLast();

            getMap.remove(n.key);
            size--;

        }
        Node n = new Node(key, value);
        freqMap.putIfAbsent(1, new DoublyLinkedList());

        freqMap.get(1).addFirst(n);
        getMap.put(key, n);
        size++;
        minFreq = 1;


    }
public class Node{
    int key;
    int value;
    int freq;
    Node prev;
    Node next;

    Node(int k, int v){

        key = k;
        value = v;
        freq = 1;

    }
}
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    // Insert at the front
    public void addFirst(Node node) {
        if (node == null) return;

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    // Insert at the end
    public void addLast(Node node) {
        if (node == null) return;

        node.prev = tail;
        node.next = null;

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = tail;
        }

        size++;
    }

    // Remove a given node in O(1)
    public void remove(Node node) {
        if (node == null) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // Node is head
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // Node is tail
            tail = node.prev;
        }

        // Help GC (optional)
        node.prev = null;
        node.next = null;

        size--;
    }

    // Remove head
    public void removeFirst() {
        if (head != null) {
            remove(head);
        }
    }

    // Remove tail
    public Node removeLast() {
        Node ans = tail;
        if (tail != null) {
            remove(tail);
        }

        return ans;
    }

    // Return current size
    public int size() {
        return size;
    }

    // Is list empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Getters for head and tail
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    // Debug printing
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
}




/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//  for get need hashmap

//  for put
//     if storage
//         - can be done with hashmap
//     else
//         - retrieve key with factor LFU + LRU 
//         - for lru - linear structure needed or  timestamp priority queue
//         - for lfu

// ok  big thing that no random remove operation required

// with doubly linkedlist accessed element can be taken and put to first..hence last elemen

// node will have prev next freq key val
// make a getmap key, node
// use a queue of freq
// and hashmap of freq , linked list

// when putting
//     when removal needed
//         get least overall freq and then get its least, wihtin that list remove last element as it will be least recently used

//     when putting 
//         if element already present
//             - update node val
//             -get its node and remove while connecting prev and next node
//             -then get its freq and increment it
//                 -if list of this freq presentin map then put the node at its head
//                 - if not make new list and put this node in it and also add this freq at end of freq list
        
//         if not present
//             - if size available, then make node with freq = 1
//                 -if list of this freq presentin map then put the node at its head
//                 - if not make new list and put this node in it and also add this freq at start of freq list
//             - else
//                 - get first freq from freq queue
//                 - remove last element of the corresponding list
//                 - then make node with freq = 1
//                     -if list of this freq presentin map then put the node at its head
//                     - if not make new list and put this node in it and also add this freq at end of freq list



//     for getting - use get map
//         if element present
//             -get its node and remove while connecting prev and next node
//             -then get its freq and increment it
//                 -if list of this freq presentin map then put the node at its head
//                 - if not make new list and put this node in it and also add this freq at end of freq list
//                  return value
//             else return -1;


//  Helper functions

//  - update node position ( node )

        
