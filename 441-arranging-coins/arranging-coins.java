class Solution {
    public int arrangeCoins(int n) {
        if(n<=1) return n;
        if(n<=3) return n==3? 2 : 1 ;
        long i = 1;
        long j = n/2;
        long mid = 1;

        while(i<=j){
             mid = i + (j-i)/2;

            int a = check(mid,n);


            if(a==0) return (int)mid;
            else if(a==1) j=mid-1;
            else i = mid+1;
        }
        return (int)j;
    }

    public int check(long temp, int n){
        long a = (temp*(temp+1))/2;
        if(a<n) return -1;
        else if(a==n) return 0;
        else return 1;
    } 
}