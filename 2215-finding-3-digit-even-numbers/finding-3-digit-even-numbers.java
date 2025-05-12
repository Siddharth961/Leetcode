class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[]freq = new int[10];

        for(int i : digits) freq[i]++;

        ArrayList<Integer> al = new ArrayList<>();

        for(int i=100; i<999; i += 2){

            if( possible(i, freq) )al.add(i);
        }

        int[]ans = new int[al.size()];

        int idx = 0;
        for(int val : al){
            ans[idx] = val;
            idx++;
        }

        return ans;
    }

    public boolean possible(int val, int[]avail ){

        int[]freq = new int[10];

        while(val > 0){
            freq[ val % 10 ]++;
            val /= 10;
        }

        for(int i=0; i<10; i++){
            if( freq[i] > avail[i] ) return false;
        }

        return true;
    }


}