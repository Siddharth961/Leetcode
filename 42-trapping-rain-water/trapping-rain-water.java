class Solution {
    public int trap(int[] height) {
        
        int l_max = height[0];
        int r_max = height[ height.length - 1];

        int l = 1;
        int r = height.length-2;

        int ans = 0;

        while(l<=r){

            if(l_max < r_max){

                if(height[l] < l_max) ans += l_max - height[l];
                else l_max = height[l];

                l++;

            }

            else{
                if(height[r] < r_max) ans += r_max - height[r];
                else r_max = height[r];

                r--;
            }
        }

        return ans;
    }
}