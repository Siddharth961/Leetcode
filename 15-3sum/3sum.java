class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;

            List< List<Integer> > lists = two_sum(i+1, -nums[i], nums);

            for( var ll : lists ){
                ans.add(ll);
            }

        }

        return ans;

    }

    public List< List<Integer>> two_sum(int idx, int tar, int[]nums){

        int i=idx;
        int j=nums.length-1;

        List< List<Integer>> ans = new LinkedList<>();

        HashSet<Integer> st = new HashSet<>();

        while(i < j){

            if(st.contains(nums[i])){
                i++;
                continue;
            }
            if(nums[i] + nums[j] == tar){

                LinkedList<Integer> ll = new LinkedList<>();
                ll.add(-tar);
                ll.add(nums[i]);
                ll.add(nums[j]);

                ans.add(ll);

                st.add(nums[i]);
                st.add(nums[j]);

                i++;
                j--;


            }
            else if(nums[i] + nums[j] < tar){
                i++;
            }
            else j--;
        }

        return ans;
    }

    
}