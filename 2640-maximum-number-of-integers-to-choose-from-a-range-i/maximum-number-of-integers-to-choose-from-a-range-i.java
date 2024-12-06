class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[]arr = new boolean[n+1];

        for(int i:banned) if(i <= n) arr[i] = true;

        int sum = 0;
        int count = 0;
        for(int i=1; i<arr.length; i++){
            
            if(arr[i] == false){
                if(sum + i > maxSum) return count;
                sum += i;
                count++;
            }
        }

        return count;
    }
}