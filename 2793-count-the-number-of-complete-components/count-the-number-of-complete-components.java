class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);

        for(int[]e : edges){
            dsu.union(e[0], e[1]);
        }

        int ans = 0;

        for(int node=0; node<n; node++){

            if(dsu.parent[node] == node){
                
                int edge_in_comp = dsu.edges[node];
                int comp_size = dsu.size[node];

                // System.out.println(node + " " + edge_in_comp + " " + comp_size);

                if( edge_in_comp == ((comp_size)*(comp_size - 1)) / 2){
                    ans++;
                }
            }
        }

        return ans;

    }

    public class DSU{

        int[]parent;
        int[]size;
        int[]edges;

        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            edges = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find_ult_par(int curr){

            if( parent[curr] == curr) return curr;

            int ult_parent = find_ult_par( parent[curr] );

            parent[curr] = ult_parent;

            return ult_parent;
        }

        public void union(int a, int b){

            int ult_a = find_ult_par(a);
            int ult_b = find_ult_par(b);

            if(ult_a == ult_b){
                edges[ult_a]++;
                return;
            }

            if( size[ult_a] >= size[ult_b]){

                parent[ult_b] = ult_a;
                size[ult_a] += size[ult_b];

                edges[ult_a] += edges[ult_b] + 1;
            }
            else{

                parent[ult_a] = ult_b;
                size[ult_b] += size[ult_a];
                edges[ult_b] += edges[ult_a] + 1;
            }
        }
    }
}