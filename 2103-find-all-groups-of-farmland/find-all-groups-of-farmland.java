class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> al = new ArrayList<>();

        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){

                if(land[i][j]==1){

                    int[]arr = new int[4];
                    arr[0] = i;
                    arr[1] = j;

                    travel(i, j, arr, land);
                    al.add(arr);
                }
            }
        }

        int[][] ans = new int[al.size()][];
        int i=0;
        for(int[]e : al){
            ans[i] = e;
            i++;
        }

        return ans;
    }

    public void travel(int r, int c, int[]arr, int[][]land){

        if( r<0 || c<0 || r==land.length || c==land[0].length) return;
        if(land[r][c]==0) return;

        if(arr[2]<r) arr[2] = r;
        if(arr[3]<c) arr[3] = c;

        land[r][c]=0;

        travel(r, c+1, arr, land);
        travel(r+1, c, arr, land);

    }
}