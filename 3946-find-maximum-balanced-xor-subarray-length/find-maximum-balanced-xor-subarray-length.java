class Solution {
    public int maxBalancedSubarray(int[] nums) {
        
        int n = nums.length;

        int odd = 0;
        int even = 0;
        int xor = 0;
        int ans = 0;

        HashMap<String, Integer> mp = new HashMap<>(); // "xor diff", index

        mp.put("0 0", -1);

        for(int i=0; i<n; i++){
            
            if( nums[i] % 2 == 0) even++;
            else odd++;


            xor ^= nums[i];

            String s = xor + " " + (even - odd);

            // if(i == nums.length-1) System.out.println(s);

            if( mp.containsKey(s) ){

                int idx = mp.get(s);                
                ans = Math.max(ans, i - idx );
            }

            else mp.put(s, i );


            // System.out.println(mp );


        }

        return ans;
    }
}