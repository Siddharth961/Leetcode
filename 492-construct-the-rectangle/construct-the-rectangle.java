class Solution {
    public int[] constructRectangle(int area) {
        int len = -1;
        int wid = -1;

        int[]ans = new int[2];
        int min = area;

        int n = (int)Math.sqrt(area) + 1;

        for(int i=n; i>1; i--){
            
            if( area % i == 0){
                len = Math.max(i, area/i);
                wid = Math.min(i, area/i);

                // System.out.println(len+"--"+wid);

                if(min > len - wid){
                    ans[0] = len;
                    ans[1] = wid;
                    min = len-wid;
                }
            }
        }

        if(len == -1){
            ans[0] = area;
            ans[1] = 1;
        }

        return ans;
    }
}