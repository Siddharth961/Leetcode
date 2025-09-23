class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = getRow(matrix, target);

        return search(row, matrix, target);
    }

    public int getRow(int[][] matrix, int target){
        int l=0;
        int h = matrix.length-1;
        int mid = 0;

        int ans = 0;

        while(l <= h){
            mid = (l+h)/2;

            if(matrix[mid][0] <= target ){
                ans = mid;
                l = mid+1;
            }
            else h = mid-1;
        }

        return ans;
    }

    public boolean search(int row, int[][]matrix, int target){

        int l = 0;
        int h = matrix[0].length-1;
        int mid = 0;

        while(l <= h){
            mid = (l+h)/2;

            if(matrix[row][mid] == target ){
                return true;
            }

            if(matrix[row][mid] <= target) l = mid+1;

            else h = mid-1;
        }

        return false;

    }
}