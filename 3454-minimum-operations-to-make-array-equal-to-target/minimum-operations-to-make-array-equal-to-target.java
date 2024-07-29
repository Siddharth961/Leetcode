class Solution {
    public long minimumOperations(int[] nums, int[] target) {

        for(int i=0; i<target.length; i++){
            target[i] = target[i]-nums[i];
        }

        long ans = Math.abs(target[0]);

        for(int i=1; i<target.length; i++){

            if( (target[i]<0 && target[i-1]<0) || (target[i]>=0 && target[i-1]>=0)){
                ans += Math.max( Math.abs(target[i]) - Math.abs(target[i-1] ), 0);
            }
            else{
                ans += Math.abs(target[i]);
            }
        }

        return ans;
    }
}