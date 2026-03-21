class Solution {

    public class Disjoint{

        int[]size;
        int[]par;

        Disjoint(int n){
            size = new int[n];
            par = new int[n];

            for(int i=0; i<n; i++){
                size[i] = 1;
                par[i] = i;
            }
        }

        public int findPar(int node){

            if(par[node] == node) return node;


            par[node] = findPar(par[node]);
            return par[node];
        }

        public void union(int a, int b){
            int par_a = findPar(a);
            int par_b = findPar(b);

            if(par_a == par_b) return;

            if(size[par_a] < size[par_b]){

                // update ultimate parent
                par[par_a] = par_b;

                // update size
                size[par_b] += size[par_a];
            }

            else{

                // update ultimate parent
                par[par_b] = par_a;

                // update size
                size[par_a] += size[par_b];

            }
        }
    }

    HashMap<Integer, List<Integer> > mpX;
    HashMap<Integer, List<Integer> > mpY;

    public int maxActivated(int[][] points) {

        mpX = new HashMap<>();
        mpY = new HashMap<>();
        
        int idx = 0;
        for(int[]p : points){

            if( !mpX.containsKey(p[0]) ) mpX.put(p[0], new LinkedList<>() ); 
            if( !mpY.containsKey(p[1]) ) mpY.put(p[1], new LinkedList<>() ); 

            mpX.get(p[0]).add(idx);
            mpY.get(p[1]).add(idx);

            idx++;

        }

        Disjoint set = new Disjoint(points.length);

        for(var list : mpX.values() ){

            for(var el : list){
                // System.out.println(list.get(0) + " " + el);

                set.union(list.get(0), el);
            }
        }

        for(var list : mpY.values() ){

            for(var el : list){
                // System.out.println(list.get(0) + " " + el);

                set.union(list.get(0), el);
            }
        }

        int max1 = 0;
        int max2 = 0;

        int[]size_arr = set.size;
        int[]par_arr = set.par;

        for(int i=0; i<points.length; i++){

            if(par_arr[i] == i){
                int val = size_arr[i];
                if(max1 < val){
                    max2 = max1;
                    max1 = val;
                }
                else max2 = Math.max(max2, val);
            }


        }



        // System.out.println(mpX);
        // System.out.println(mpY);

        // boolean[]visited = new boolean[points.length];

        // int max1 = 0;
        // int max2 = 0;

        // for(int i=0; i<points.length; i++){

        //     if(visited[i] == false){

        //         int val = get_size(i, visited, points);

        //         if(max1 < val){
        //             max2 = max1;
        //             max1 = val;
        //         }
        //         else max2 = Math.max(max2, val);
        //     }
        // }

        return max1 + max2 + 1;
    }

    public int get_size(int curr, boolean[]visited, int[][]points){

        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(curr);

        while(q.size() > 0){

            int node = q.remove();

            if(visited[node]) continue;

            visited[node] = true;
            count++;

            for(int p : mpX.get( points[node][0] ) ){
                if(visited[p] == false){
                    q.add(p);
                    // visited[p] = true;
                    // count++;
                }
            }

            for(int p : mpY.get( points[node][1] ) ){
                if(visited[p] == false){
                    q.add(p);
                    // visited[p] = true;
                    // count++;
                }
            }
        }

        return count;

    }
}