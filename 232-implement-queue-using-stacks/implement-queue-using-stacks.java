class MyQueue {  

    Stack<Integer>st = new Stack<>();
    Stack<Integer>helper = new Stack<>(); 

    public MyQueue() {
        
    }
    
    public void push(int x) {
        
        while(st.size()!=0){
            helper.push(st.pop()); 
        }

        helper.push(x);

        while(helper.size()!=0){
            st.push(helper.pop());
        }

        
    }
    
    public int pop() {
        if(st.size()==0) return -1;
        return st.pop();
    }
    
    public int peek() {
        if(st.size()==0) return -1;
        return st.peek();
    }
    
    public boolean empty() {
        if(st.size()>0) return false;
        else return true;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */