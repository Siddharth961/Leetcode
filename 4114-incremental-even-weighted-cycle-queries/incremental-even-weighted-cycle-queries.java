class Solution {

    public class Dsu{
        int[]wt;
        int[]par;
        int[]size;

        Dsu(int n){
            wt = new int[n];
            par = new int[n];
            size = new int[n];

            for(int i=0; i<n; i++){
                par[i] = i;
                size[i] = 1;
            }
            
        }

        public int[] findPar(int curr){

            if(par[curr] == curr){
                // i.e we have reached top/ultimate parent

                return new int[]{0, curr}; // returning { xor till ult par, ult par}
            }

            int[] arr = findPar( par[curr] );

            par[curr] = arr[1]; // setting ult parent of curr
            wt[curr] = wt[curr] ^ arr[0]; // setting xor of dist from ult parent

            return new int[]{wt[curr], arr[1]};  // returning { xor till ult par, ult par}
        }

        public boolean union(int u, int v, int w){

            int[]pu = findPar(u);
            int[]pv = findPar(v);

            if(pu[1] != pv[1]){
                // u and v are of different components currently, joining them wont create a new cycle

                if(size[ pu[1] ] > size[ pv[1] ] ){

                    size[ pu[1] ] += size[ pv[1] ];

                    par[ pv[1] ] = pu[1];
                    wt[ pv[1] ] = pu[0] ^ pv[0] ^ w;
                }

                else{

                    size[ pv[1] ] += size[ pu[1] ];

                    par[ pu[1] ] = pv[1];
                    wt[ pu[1] ] = pu[0] ^ pv[0] ^ w;

                }

                return true; // since we can join u and v
            }

            

            // u and v are of same component so connecting them will create a new cycle

            int wt_of_cycle = pu[0] ^ pv[0] ^ w;

            return wt_of_cycle == 0; // if wt == 0 i.e even, we can join u and v else no
            
        }
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {

        Dsu d = new Dsu(n);

        int ans = 0;

        for(int[]e : edges){

            if( d.union(e[0], e[1], e[2] ) ) ans++;
        }

        return ans;        
    }
}