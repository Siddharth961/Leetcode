class ProductOfNumbers {

    Node head;


    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        Node temp = new Node(num);
        temp.next = head;
        head = temp;
    }
    
    public int getProduct(int k) {
        Node ptr = head;
        int pro=1;
        while(k>0){
            pro = pro*ptr.val;
            ptr = ptr.next;
            k--;
        }

        return pro;
    }
}

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */