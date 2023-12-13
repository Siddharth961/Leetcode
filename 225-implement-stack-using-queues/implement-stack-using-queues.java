class MyStack {

    Queue<Integer> q ;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.add(x);
        int n = q.size()-1;
        while(n>0){
            q.add(q.remove());
            n--;
        }
    }
    
    public int pop() {
        return q.remove();
        
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size()==0;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */