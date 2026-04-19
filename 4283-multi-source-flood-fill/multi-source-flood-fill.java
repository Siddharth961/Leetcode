class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        
        int[][] grid = new int[n][m];

        // boolean[][]visited = boolean[n][m];

        // Queue<int[]> q = new LinkedList<>();

        HashMap<String, Integer> mp = new HashMap<>();

        for(int[]s : sources){

            // grid[ s[0] ][ s[1] ] = s[2];

            // q.add(new int[]{s[0], s[1]});

            mp.put(s[0] + " " + s[1], s[2]);
        }

        while(mp.size() > 0){

            HashMap<String, Integer> next_mp = new HashMap<>();

            for(var k : mp.keySet()){

                String[]arr = k.split(" ");

                int r = Integer.parseInt(arr[0]);
                int c = Integer.parseInt(arr[1]);

                int color = mp.get(k);

                if(grid[r][c] != 0 ) continue; // this cell was already set in previous step but tried to bbe overwritten

                // setting [r][c] to color permanently

                 grid[r][c] = color;

                // propagating its impact for next level

                if(r-1 >= 0 && grid[r-1][c] == 0){
                    String new_k = (r-1) + " " + c;

                    if(!next_mp.containsKey(new_k) || next_mp.get(new_k) < color){
                        next_mp.put(new_k, color);
                    }
                }
                if(c+1 < m && grid[r][c+1] == 0){
                    String new_k = (r) + " " + (c+1);

                    if(!next_mp.containsKey(new_k) || next_mp.get(new_k) < color){
                        next_mp.put(new_k, color);
                    }
                }
                if(r+1 < n && grid[r+1][c] == 0){
                    String new_k = (r+1) + " " + c;

                    if(!next_mp.containsKey(new_k) || next_mp.get(new_k) < color){
                        next_mp.put(new_k, color);
                    }
                }
                if(c-1 >= 0 && grid[r][c-1] == 0){
                    String new_k = (r) + " " + (c-1);

                    if(!next_mp.containsKey(new_k) || next_mp.get(new_k) < color){
                        next_mp.put(new_k, color);
                    }
                }


            }

            mp = next_mp;

            // for(int[]arr : grid){
            //     for(int i : arr) System.out.print(i + " ");
            //     System.out.println();
            // }

            // System.out.println("------------");

        }

        return grid;
    }


}