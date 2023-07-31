class MinStack {

    Stack<Long> st = new Stack<>();
    long min;

    public MinStack() {
        
    }
    
    public void push(int val) {
        long x = (long)val;
        if(st.size()==0){
            st.push(x);
            min=x;
        }

        else if(x>=min){
            st.push(x);
        }
        else if(x<min){
            st.push(2*x-min);
            min = x;
        }
        
    }
    
    public void pop() {
        if(st.size()==0) return ;
        else if(st.peek()>=min) st.pop();
        else if(st.peek()<min){
            min = 2*min - st.peek();
            st.pop();
        }

    }
    
    public int top() {
        if(st.size()==0) return -1; 
        long q = st.peek();
        if(q>=min) return (int)q;
        else return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */