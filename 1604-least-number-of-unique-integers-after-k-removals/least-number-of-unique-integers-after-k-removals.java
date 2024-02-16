class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[]freq = new int[arr.length+1];
        int len = 1; 
        int count = 0; //number of unique elements
        for(int i=0; i<arr.length; i++){
            if(i+1 < arr.length && arr[i]==arr[i+1]){
                len++;
            }
            else{
                count++;
                freq[len]++;
                len = 1;
            }
        }

        for(int i=1; i<freq.length; i++){
           
                int countreduce = Math.min( k/i , freq[i]);
                count -= countreduce;
                k -= countreduce*i;
                if(k<=i) break;                
           
        }

        return count;
    }
}