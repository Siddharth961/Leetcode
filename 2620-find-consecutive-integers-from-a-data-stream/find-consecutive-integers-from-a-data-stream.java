class DataStream {

    Queue<Integer> q = new LinkedList<>();
    int val=0;
    int k = 0;

    public DataStream(int value, int k) {
        val = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        
        if(num==val){
            if(q.size()==k) return true;
            q.add(val);
            if(q.size()==k) return true;

        }
        else q.clear();

        
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */