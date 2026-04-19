class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int i=nums1.length-1;
        int j=nums2.length-1;

        int ans = 0;

        while(i >= 0 && j >= 0){
            
            if( nums1[i] <= nums2[j]){

                // val at i smaller than val  at j so we can calcualte ans
                ans = Math.max(ans, j-i);

                // since val at i was smaller we can try increase that value by moving i
                i--;

            }
            else{     

                // val at i is greater so we need to increase val at j
                // but we also need to make sure i < j

                j--;
                if(i > j) i = j;        
                
            }

        }

        return ans;



    }
}