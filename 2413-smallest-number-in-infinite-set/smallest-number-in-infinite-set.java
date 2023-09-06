class SmallestInfiniteSet {
    PriorityQueue<Integer> q  = new PriorityQueue<>();
    int i = 1;

    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        if(!q.isEmpty()) return q.poll();

        i++;
        return i-1;
    }
    
    public void addBack(int num) {
        if(i>num && !q.contains(num)) q.offer(num);
         
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */