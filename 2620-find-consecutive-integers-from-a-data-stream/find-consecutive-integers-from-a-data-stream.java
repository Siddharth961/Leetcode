class DataStream {

    int val, k, count;
    public DataStream(int value, int k) {
        val = value;
        this.k = k;
        count = 0;
    }

    public boolean consec(int num) {
        if (num == val) count++;
        else count = 0;
        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */