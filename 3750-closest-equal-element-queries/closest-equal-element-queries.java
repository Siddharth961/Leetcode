class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!mp.containsKey(nums[i])) mp.put(nums[i], new ArrayList<>());

            mp.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();
       

        for(int q : queries){

            int val = search(q, mp.get(nums[q]), nums.length);
            ans.add(val);
        }

        return ans;

    }

    public int search(int tar_idx, List<Integer>list, int n ){

        // ONE IMPOERTANT THING TO NOTICE
        //tar_idx will ALWAYS be present in list

        if(list.size() == 1) return -1;

        int l = 0;
        int h = list.size() - 1;

        int mid = 0;

        int loc_in_list = 0;

        while(l <= h){

            mid = (l+h)/2;

            if( list.get(mid) <= tar_idx){
                loc_in_list = mid;
                l = mid+1;
            }

            else h = mid-1;


        }

        int prev_dist = loc_in_list != 0 ? (tar_idx - list.get(loc_in_list - 1) ) : (tar_idx + (n - list.get(list.size()-1) ) );

        int next_dist = loc_in_list != list.size()-1 ? (list.get(loc_in_list + 1) - tar_idx) : ( (n-tar_idx) + list.get(0));

        return Math.min(prev_dist, next_dist);
        
    }
}