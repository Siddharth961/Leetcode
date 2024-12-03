class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m==0){
        //     for(int i=0; i<nums2.length; i++) nums1[i] = nums2[i];
        //     return ;
        // }
        if(n==0) return;
        int i=m-1;
        int j=n-1;

        int idx = n+m-1;


        while(i>=0 && j>=0){

            if(nums1[i] >= nums2[j]){
                nums1[idx] = nums1[i];
                i--;
                idx--;
            }
            else{
                nums1[idx] = nums2[j];
                j--;
                idx--;

            }

        }

        while(j>=0){
            nums1[idx] = nums2[j];
            j--;
            idx--;
        }


    }
}