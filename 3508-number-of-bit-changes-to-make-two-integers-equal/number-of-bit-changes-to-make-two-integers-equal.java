class Solution {
    public int minChanges(int n, int k) {
        
        int bits = 0;

        while(n!=0 || k!=0){

            if(n%2 != k%2){
                if(n%2 == 0) return -1; // as only 1 can be changed to 0 and only in n
                 bits++;
            }
            if(n==k) return bits;


            n /= 2;
            k /= 2;
        }

        return bits;
    }
}