class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        boolean check=false;     

        for(int i=left; i<=right; i++){

            check = false;

            for(int[] arr : ranges){
                if(arr[0]<=i && i<=arr[1]){
                    check = true;
                    break;
                }
            }

            if(!check) return false;

        }

        return true;
    }
}