class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) return 0;

        int prevk = kthGrammar(n-1, (k+1)/2);
        int currk = 0; //temp value

        if(prevk==1){

            currk = k%2!=0 ? 1 : 0; 

        }

        else currk = k%2!=0 ? 0 : 1;

        return currk;
    }
}