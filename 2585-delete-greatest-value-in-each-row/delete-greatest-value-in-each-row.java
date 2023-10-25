class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int[]arr : grid) Arrays.sort(arr);

        int j = grid[0].length-1;
        int ans = 0;
        int max = 0;

        while(j>=0){
            max = 0;
            for(int[]arr : grid){
                if(max<arr[j]) max = arr[j];
            }
            System.out.println(max);

            ans += max;
            j--;
        }

        

        return ans;
    }
}