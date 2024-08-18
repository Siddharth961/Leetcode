class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]lsi = new int[nums.length];
        int idx = 0;
        lsi[idx] = nums[0];

        for(int i=1; i<nums.length; i++){
            if(lsi[idx]<nums[i]){
                idx++;
                lsi[idx] = nums[i];
            }
            else{
                binary(idx, nums[i], lsi);
            }
        }

        return idx+1;
    }

    public void binary(int en, int tar, int[]lsi){
        int l=0;
        int r=en;
        int mid=0;
        int ans = 0;

        while(l<=r){
            mid = (l+r)/2;

            if(lsi[mid] < tar){
                l = mid+1;
            }
            else{
                ans = mid;
                r = mid-1;
            } 
            
        }

        lsi[ans] = tar;

        // for(int i : lsi) System.out.print(i+" ");
        // System.out.println();
    }
}