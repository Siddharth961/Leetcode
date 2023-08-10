class FrontMiddleBackQueue {

    Deque<Integer> q1 = new LinkedList<>();
    Deque<Integer> q2 = new LinkedList<>();

    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {    
        if(q1.size()>q2.size()){
            q2.offerFirst(q1.pollLast());
        }

        q1.offerFirst(val);
    }
    
    public void pushMiddle(int val) {
        if(q1.size()>q2.size()){
            q2.offerFirst(q1.pollLast());
        }

        q1.offerLast(val);
    }
    
    public void pushBack(int val) {
        if(q1.size()==0){
            pushFront(val);
            return;
        }
        if(q1.size()==q2.size()){
            q1.offerLast(q2.pollFirst());
        }

        q2.addLast(val);
    }
    
    public int popFront() {

        if(q1.size()==0) return -1;

        if(q1.size()==q2.size()){
            q1.offerLast(q2.pollFirst());

        }

        int val = q1.removeFirst();
        return val;
    }
    
    public int popMiddle() {

        if(q1.size()==0) return -1;

        int val = q1.peekLast();

        if(q1.size()==q2.size()){
            q1.pollLast();
            q1.offerLast(q2.pollFirst());
        }

        else q1.pollLast();

        



        return val;

        
    }
    
    public int popBack() {

        if(q1.size()==0) return -1;

        if(q1.size()>q2.size()){
            q2.offerFirst(q1.pollLast());
        }

        int val = q2.removeLast();

        return val;
        
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */