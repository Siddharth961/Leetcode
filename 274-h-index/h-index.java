class Solution {
    public int hIndex(int[] citations) {
        int[]check = new int[1001];

        for(int i : citations) check[i]++;
        int count = 0;

        for(int i = 1000; i>=0; i--){
            if( check[i] > 0 ){
                count += check[i];
            }
                if(count >= i ) return i;
        }

        return 0;
    }
}