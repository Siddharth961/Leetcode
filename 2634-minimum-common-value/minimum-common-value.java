class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; 
        int j = 0;

        while(i<nums1.length && j<nums2.length){

            

            if(nums1[i]==nums2[j]) return nums1[i];

            else if(nums1[i]>nums2[j]){
                 j =Math.max(j+1, binary( nums2, nums1[i], j) ) ;
               
            }
            else { 
                i = Math.max(i+1, binary( nums1, nums2[j], i ));
            }

            
        }

        return -1;
    }
    public int binary(int[]n, int val, int startidx){
        int i = startidx;
        int j = n.length-1;

        int mid = 0;

        while(i<=j){
            mid = (i+j)/2;
            if(n[mid] == val) return mid;
            else if(n[mid]<val) i = mid+1;
            else j = mid - 1;
        }
        // if(startidx==0){
        //     System.out.println( n[startidx] + " "+mid);
        // }
        if(n[mid]>val && mid>0) return mid - 1; 

        return mid ;
    }
}