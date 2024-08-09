class Solution {
    public int numMagicSquaresInside(int[][] grid) {        
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows<3 || cols<3) return 0;

        int[]freq = new int[10];
        int ans = 0;

        int re = 2;
        int ce = 3;

        int val = 0;
        while(re<rows){
            
            Arrays.fill(freq, 0);           
            ce = 0;

            while(ce<cols){

                if(ce > 2){

                    for(int i=re-2; i<=re; i++){
                        val = grid[i][ce-3];
                        if(val < 10 && freq[val]>0) freq[val]--;
                    }
                }

                for(int i=re-2; i<=re; i++){
                    val = grid[i][ce];
                    if(val < 10 ) freq[val]++;
                }

                // if(ce==3 && re==4) System.out.println(st);

                
                if( check(re, ce, freq, grid) ) ans++;

                ce++;
                            

            }

            re++;
        }

        return ans;
    }

    public boolean check(int re, int ce, int[]freq, int[][]grid){
        
        for(int i=1; i<=9; i++) if(freq[i]<=0) return false;

        int val = grid[re-2][ce-2] + grid[re][ce] ;

        if( val != grid[re][ce-2] + grid[re-2][ce] ) return false;

        val += grid[re-1][ce-1];
                System.out.println(val);

        int col_sum = 0;

        for(int i=re-2; i<=re; i++){
            for(int j=ce-2; j<=ce; j++){
                col_sum += grid[i][j];
            }
            if( val != col_sum) return false;
            col_sum = 0;
        }


        int row_sum = 0;

        for(int j=ce-2; j<=ce; j++){
            for(int i=re-2; i<=re; i++){
                row_sum += grid[i][j];
            }
            if( val != row_sum) return false;
            row_sum = 0;
        }

        return true;

    }
}