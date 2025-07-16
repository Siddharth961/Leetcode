class Solution {
    public class Edge{

        int src;
        int weight;
        int dst;

        Edge(int s, int w, int d){
            src = s;
            weight = w;
            dst = d;
        }

    }

    public int minCost(int n, int[][] edges, int k) {

        LinkedList<Edge>[]graph = make_graph(n, edges);
        
        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));

        int l=0;
        int h = edges.length - 1;
        int mid = 0;

        int ans = 0; // min weight

        while( l <= h){
            mid = (l + h)/2;

            int val = find_comps( edges[mid][2], graph);

            // System.out.println(edges[mid][2] + "  " + val);

            if( val <= k){
                ans = edges[mid][2];
                h = mid-1;
            }
            else{

                l = mid+1;

            }
        }

        if(h < 0 && k==n ) return 0;

        return ans;

        
    }

    public LinkedList<Edge>[] make_graph(int n, int[][]edges){

        LinkedList<Edge>[]graph = new LinkedList[n];

        for(int i=0; i<graph.length; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[]e : edges){
            graph[ e[0] ].add( new Edge(e[0], e[2], e[1]) );
            graph[ e[1] ].add( new Edge(e[1], e[2], e[0]) );
        }

        // for(int i=0; i<graph.length; i++){
        //     System.out.print(i + " -- ");
        //     for(Edge e : graph[i]){
        //         System.out.print(e.dst + " ");
        //     }
        //     System.out.println();
        // }

        return graph;
    }

    public int find_comps(int weight_limit, LinkedList<Edge>[]graph){

        int[]groups = new int[graph.length];

        int group = 0;

        for(int i=0; i<groups.length; i++){

            if(groups[i] != 0) continue;

            group++;

            dfs(i, group, groups, weight_limit, graph);
        }

        return group;
    }

    public void dfs(int src, int group, int[]groups, int limit, LinkedList<Edge>[]graph){

        groups[src] = group;

        for(Edge e : graph[src]){
            if( e.weight > limit || groups[e.dst] != 0) continue;

            dfs( e.dst, group, groups, limit, graph);
        }
    }
}