class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[]prefix = new int[nums.length];
        int pre=0;

        for(int i=0; i<nums.length; i++){
            pre += nums[i];
            prefix[i] = pre;
        }

        int i1=0;
        int j1 = i1 + firstLen - 1;
        int i2=0;
        int j2=0;

        int sum1=0;
        int sum2=0;

        int ans = 0;

        while(j1 < nums.length){
            sum1 = prefix[j1] - prefix[i1] + nums[i1];

            i2=0;
            j2=i2 + secondLen - 1;;

            while( j2 < nums.length){

            
                if( (j2>=i1 && j2<=j1) || (i2>=i1 && i2<=j1) || (i2<=i1 && j2>=j1)){
                    i2 = j1+1;
                    j2 = i2 + secondLen - 1;
                }

                

                if(j2>=nums.length) break;

                sum2 = prefix[j2] - prefix[i2] + nums[i2];

                

                ans = Math.max( ans, sum1 + sum2); 
                
                i2++;
                j2++;
            }

            i1++;
            j1++;
        }

        return ans;
    }
}