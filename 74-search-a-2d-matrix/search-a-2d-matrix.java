class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length-1;
        int mid = 0;

        while(i<=j){
            mid = (i+j)/2;

            if(matrix[mid][0] > target) j = mid - 1;
            else if(matrix[mid][0] < target) i = mid+1;
            else break;
        }

        int r = 0;
        if(matrix[mid][0] == target || (mid==matrix.length-1 && matrix[mid][0]<target)) r = mid;
        else{
            if(mid+1<matrix.length && matrix[mid][0]<target){
                if(matrix[mid+1][0]>target) r = mid;
                else r = mid+1;
            }
            if(mid-1>=0 && matrix[mid][0]>target){
                 r = mid - 1;
            }
        
        }

        System.out.println(mid+" "+r);

        i = 0;
        j = matrix[0].length-1;
        
        while(i<=j){
            mid = (i+j)/2;
            if(matrix[r][mid] > target) j = mid-1;
            else if(matrix[r][mid] < target) i = mid+1;
            else return true;
        }

        return false;
    }
}