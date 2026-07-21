class Solution {
    public long gcdSum(int[] nums) {
        
        int[]prefixGcd = build_prefixGcd(nums);

        Arrays.sort(prefixGcd);

        int i=0;
        int j=prefixGcd.length-1;

        long ans = 0;

        while(i < j){
            ans += gcd(prefixGcd[i], prefixGcd[j]);

            i++;
            j--;
        }

        return ans;
        
    }

    public int[] build_prefixGcd(int[]nums){

        int max = nums[0];
        int[]arr = new int[nums.length];

        for(int i=0; i<arr.length; i++){

            max = Math.max(max, nums[i]);
            arr[i] = gcd(nums[i], max);
        }

        return arr;
    }

    public int gcd(int a, int b){

        if(b % a == 0) return a;

        return gcd( b % a, a);
    }
}