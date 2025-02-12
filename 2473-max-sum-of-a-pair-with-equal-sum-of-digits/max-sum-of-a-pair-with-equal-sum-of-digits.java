class Solution {
    public int maximumSum(int[] nums) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = -1;

        for(int i : nums){
            int sum = getsum(i);

            if(mp.containsKey(sum)){

                ans = Math.max(ans, i + mp.get(sum));
                mp.put(sum, Math.max(i, mp.get(sum) ));
            }

            else mp.put(sum, i);
        }

        return ans;
    }

    public int getsum(int n){
        int sum = 0;

        while(n > 0){
            sum += n%10;
            n = n/10;
        }

        return sum;
    }
}