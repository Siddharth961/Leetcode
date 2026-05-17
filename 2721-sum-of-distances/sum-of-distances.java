class Solution {
    public long[] distance(int[] nums) {
        

        long[]ans = new long[nums.length];

        HashMap<Integer, long[]> mp = new HashMap<>(); // val -> [no.of indices, sum of indices]

        for(int i=0; i<nums.length; i++){

            if( !mp.containsKey(nums[i])){

                mp.put(nums[i], new long[2]);

            }

            long[]record = mp.get(nums[i]);

            long val = (record[0] * i ) - record[1];

            ans[i] += val;

            record[0]++;
            record[1] += i;
        }

        mp.clear();
        for(int i=nums.length-1; i>=0; i--){

            if( !mp.containsKey(nums[i])){

                mp.put(nums[i], new long[2]);

            }

            long[]record = mp.get(nums[i]);

            long val = record[1] - (record[0] * i ) ;

            ans[i] += val;

            record[0]++;
            record[1] += i;
        }

        return ans;


    }
}