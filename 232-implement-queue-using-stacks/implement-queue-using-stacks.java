class MyQueue {
    Stack<Integer> main;
    Stack<Integer> help;

    public MyQueue() {
        main = new Stack<>();
        help = new Stack<>();
    }
    
    public void push(int x) {

        while(main.size()>0){
            help.push(main.pop());
        }

        main.push(x);

        while(help.size()>0){
            main.push(help.pop());
        }        
    }
    
    public int pop() {

        return main.pop();
        
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.size()==0;
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