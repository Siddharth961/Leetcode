class Solution {
    public int minSwaps(int[] nums) {
        Integer[]temp = Arrays.stream(nums)
                       .boxed()
                       .toArray(Integer[]::new);


        Arrays.sort(temp, (a,b) -> {
            int sum_a = get_sum(a);
            int sum_b = get_sum(b);

            if(sum_a == sum_b) return a - b;
            return sum_a - sum_b;
        });

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], i);
        }

        int swaps = 0;

        for(int i=0; i<nums.length; i++){

            if(temp[i] != nums[i]){

                int orig_ind = mp.get(temp[i]);

                // place ele at orig_ind at correct position (i)

                int val = nums[i];

                nums[i] = nums[orig_ind];
                nums[orig_ind] = val;

                // update mapping
                mp.put(nums[i], i);
                mp.put(nums[orig_ind], orig_ind);

                swaps++;
            }

        }

        return swaps;
    }

    public int get_sum(int n){
        int sum = 0;

        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}