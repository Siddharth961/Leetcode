class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> st = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(int i=0; i<nums.length; i++){
            sb = new StringBuilder();
            count = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%p == 0){
                    count++;

                }

                if(count>k) break;

                sb.append(nums[j]);
                sb.append(',');

                st.add( sb.toString() );
            }
        }

        return st.size();
    }
}