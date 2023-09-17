class Solution {
    public boolean predictTheWinner(int[] nums) {
        return ans(nums, 0, 0, 0, nums.length-1, true);
    }

    public boolean ans(int[]arr, int p1, int p2, int i, int j, boolean turn){
        if(i>j){
            if(p1>=p2) return true;
            else return false;
        }
        boolean a=true,b=true;
        if(turn == true){
            a = ans(arr, p1+arr[i], p2, i+1, j, false);
            if(a) return a;
            b = ans(arr, p1+arr[j], p2, i, j-1, false);
        return (a || b);

        }
        else{
            a = ans(arr, p1, p2 + arr[j], i, j-1, true);
            if(!a) return a;

            b = ans(arr, p1, p2 + arr[i], i+1, j, true);
        return (a && b);

        }

    }
}