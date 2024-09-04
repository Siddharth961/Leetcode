class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashMap<Integer, HashSet<Integer> > mp = new HashMap<>();
        for(int[]arr : obstacles){
            if(!mp.containsKey(arr[0]) ){
                mp.put(arr[0], new HashSet<>() );
                
            }

            mp.get(arr[0]).add(arr[1]);
        }

        // for( var e : mp.keySet()){
        //     for(int[]arr : mp.get(e)){
        //         System.out.print(arr[0]+"--"+arr[1]+"  ");
        //     }
        //     System.out.println();
        // }

        int x = 0;
        int y = 0;
        int n_x = 0;
        int n_y = 0;
        int dist = 0;
        int dir = 0;

        for(int com : commands){
            if(com == -2){
                dir = (dir+3)%4;
            }

            else if(com == -1){
                dir = (dir+1)%4;
            }

            else{

                int k = com;

                while(k>0){
                    n_y = y;
                    n_x = x;
                    if(dir == 0) n_y = y+1;
                    if(dir == 1) n_x = x+1;
                    if(dir == 2) n_y = y-1;
                    if(dir == 3) n_x = x-1;

                    boolean obst = false;

                    if( mp.containsKey( n_x )){
                        if(mp.get(n_x).contains(n_y)){
                            obst = true;
                            break;
                        }
                    }

                    // System.out.println(obst);
                    if(obst == true) break;

                    x = n_x;
                    y = n_y;
                    dist = Math.max(dist, x*x + y*y);

                    k--;

                }
            }

            // System.out.println(x+" "+y+" "+dir);
        }

        return dist;
    }
}