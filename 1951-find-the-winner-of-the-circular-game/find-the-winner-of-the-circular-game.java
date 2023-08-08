class Solution {
    public int findTheWinner(int n, int k) {
        int[]arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i]=i;
        }

        int size=n;
        int i=0;

        while(size>1){
            int count = k;
            while(count>0){
                
                if(i==arr.length-1)i=1;
                else i++;
                if(arr[i]!=-1) count--;
            }
            arr[i]=-1;
            
            size--;

        }
        for( i=1; i<=n; i++){
            if(arr[i]>-1)return arr[i];
        }

        return i;
    }
}