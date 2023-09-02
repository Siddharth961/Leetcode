class MyHashMap {

    class Node{
        int key;
        int val;
        Node(){}
        Node(int a, int b){
            key = a;
            val = b;
        }
    }

    int size = 0;
    int capacity = 10;
    float load_factor = 0.75f;
    LinkedList<Node>[] arr;

    public MyHashMap() {
        init();
        
    }

    public void init(){
        arr = new LinkedList[capacity];

        for(int i=0; i<arr.length; i++){
            arr[i] = new LinkedList<>();

        }
    }

    public void rehash(){
        LinkedList<Node>[] old = arr;
        capacity = 2*capacity;
        size=0;

        init();

        for(var i: old){
            for(var j : i){
                put(j.key, j.val);
            }
        }
    }
    
    public void put(int key, int value) {
        int bi = Math.abs(hashfunc(key));
        int idx = Search(arr[bi],key);


        if(idx==-1){
            Node temp = new Node(key,value);
            arr[bi].add(temp);
            size++;
        }
        else{
            Node temp = arr[bi].get(idx);
            temp.val = value;
        }

        if(size >= capacity*load_factor) rehash();
        
    }
    
    public int get(int key) {
        int bi = Math.abs(hashfunc(key));
        int idx = Search(arr[bi],key);

        if(idx==-1) return -1;
        else return arr[bi].get(idx).val;
    }
    
    public void remove(int key) {
        int bi = Math.abs(hashfunc(key));
        int idx = Search(arr[bi],key);

        if(idx==-1){
            return;
        }
        else{
            arr[bi].remove(idx);
            size--;
        }
    }

    public int hashfunc(int i){
        return i%capacity;
    }

    public int Search(LinkedList<Node>ll, int k){

        for(int i=0; i<ll.size(); i++){
            if(ll.get(i).key==k) return i;
        }

         return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */