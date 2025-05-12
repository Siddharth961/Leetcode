class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        HashMap<Long, TreeSet<Integer>> rowMap = new HashMap<>();
        HashMap<Long, TreeSet<Integer>> colMap = new HashMap<>();

        long[] rowSum = new long[r];     // Sum of each row
        long[] colSum = new long[c];     // Sum of each column
        long[] rowPrefix = new long[r];   // Prefix sum of rowSum
        long[] colPrefix = new long[c];   // Prefix sum of colSum

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                long val = grid[i][j];

                rowMap.putIfAbsent(val, new TreeSet<>());
                rowMap.get(val).add(i);
                colMap.putIfAbsent(val, new TreeSet<>());
                colMap.get(val).add(j);

                rowSum[i] += val;
                colSum[j] += val;
            }
        }

        for(int i=0; i<r; i++){
            if(i == 0) rowPrefix[i] = rowSum[i];
            else rowPrefix[i] = rowSum[i] + rowPrefix[i-1];
        }

        for(int i=0; i<c; i++){
            if(i == 0) colPrefix[i] = colSum[i];
            else colPrefix[i] = colSum[i] + colPrefix[i-1];
        }

        for(int j=0; j<c-1; j++){

            long left = colPrefix[j];
            long right = colPrefix[c-1] - colPrefix[j];

            // System.out.println(left + " " + right);


            if(left == right) return true;

            long diff = Math.abs(left - right);

            if(left > right){

                
                if (j==0){ if(grid[0][0] == diff || grid[r - 1][0] == diff)  return true; }

                else if(colMap.containsKey(diff) ){

                    Integer pos = colMap.get(diff).floor(j);
                    if(pos != null && ( r != 1 || pos==0 || pos==j) ) return true;

                }

            }
            else{

                
                if (j==c-2){ if(grid[0][c-1] == diff || grid[r - 1][c-1] == diff) return true; }

                else if(colMap.containsKey(diff) ){

                    Integer pos = colMap.get(diff).ceiling(j+1);
                    if(pos != null && ( r != 1 || pos==j+1 || pos==c-1) ) return true;

                }

            }
        }

        for(int i=0; i<r-1; i++){

            long left = rowPrefix[i];
            long right = rowPrefix[r-1] - rowPrefix[i];

            // System.out.println(left + " " + right);
            // System.out.println(12356);

            if(left == right) return true;

            long diff = Math.abs(left - right);

            if(left > right){

                
                if (i==0){ if(grid[0][0] == diff || grid[0][c-1] == diff)  return true;}

                else if(rowMap.containsKey(diff) ){

                    Integer pos = rowMap.get(diff).floor(i);
                    if(pos != null && ( c != 1 || pos==0 || pos==i) ) return true;

                }

            }
            else{

                
                if (i==r-2){ if(grid[i+1][0] == diff || grid[i+1][c-1] == diff) return true;}

                else if(rowMap.containsKey(diff) ){

                    Integer pos = rowMap.get(diff).ceiling(i+1);
                    if(pos != null && ( c != 1 || pos==i+1 || pos==r-1) ) return true;

                }

            }
        }


        
        return false;

    }

    
}