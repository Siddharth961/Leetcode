// class Solution {
//     public class Edge{
//         int src;
//         int cost;
//         int dst;

//         Edge(int s, int c, int d){
//             src = s;
//             cost = c;
//             dst = d;
//         }
//     }

//     // int ans = -1;

//     HashMap<Long, Integer>[]dp;
    
//     public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

//         int n = online.length;

//         List<Edge>[] graph = make_graph( n, edges);

//         Arrays.sort(edges, (a ,b) -> a[2] - b[2]);

//         int l = 0;
//         int h = edges.length - 1;
//         int mid  = 0;

//         int ans = -1;

//         while( l <= h){
//             mid = (l+h)/2;

//             int limit = edges[mid][2];

//             if( djikstra(limit, k, online, graph)){
//                 ans = Math.max(ans, limit);
//                 l = mid+1;
//             }

//             else h = mid-1;
//         }

//         return ans;

        

//     }

//     public List<Edge>[] make_graph( int n, int[][]edges){

//         List<Edge>[]graph = new LinkedList[n];

//         for(int i=0; i<n; i++){
//             graph[i] = new LinkedList<>();
//         }

//         for(int[]e : edges){
//             graph[ e[0] ].add( new Edge( e[0], e[2], e[1] ));
//         }

//         return graph;
//     }

//     public int get_path( int src, int tar, long ssf,  List<Edge>[]graph, boolean[]online, long k     ){
//         if( src == tar){
//             if(ssf > k) return Integer.MIN_VALUE;

//             return Integer.MAX_VALUE;
//         }

//         if( dp[src].containsKey(ssf) ) return dp[src].get(ssf);
        
//         if( online[src] == false || ssf > k) return  Integer.MIN_VALUE;


//         int ans = Integer.MIN_VALUE; 

//         for(Edge n : graph[src]){

//             // int new_min = Math.ans(msf, n.cost);
//             long new_ssf = ssf + n.cost;

//             int new_max = get_path( n.dst, tar, new_ssf,   graph, online, k);

//             ans = Math.max( ans, Math.min(new_max , n.cost) );
//         }

//         // if( ans != Integer.MIN_VALUE){
            
//         //     ans = Math.min( ans , prev_cost);
//         // }


//         dp[src].put( ssf, ans);

//         return ans;
//     }

//     public boolean djikstra(int limit, long k, boolean[]online, List<Edge>[] graph){

//         int n = graph.length;

//         long[]dist = new long[n];
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[0] = 0;

//         boolean[]visited = new boolean[n];

//         PriorityQueue<Pair> pq = new PriorityQueue<>();

//         pq.add( new Pair(0, 0));

//         while( pq.size() > 0){
//             Pair p = pq.remove();

//             if( visited[p.node] || !online[p.node]) continue;

//             for(Edge e : graph[p.node] ){

//                 if( e.cost >= limit){
//                     if( p.cost + e.cost < dist[e.dst] ){
//                         dist[e.dst] = p.cost + e.cost;

//                         pq.add( new Pair(e.dst, dist[e.dst]) );
//                     }
//                 }
//             }

//         }

//         return dist[n-1] <= k;


//     }

//     public class Pair implements Comparable<Pair>{

//         int node;
//         long cost;

//         Pair( int n, long c){
//             node = n;
//             cost = c;
//         }

//         @Override
//         public int compareTo(Pair p2){
//             return Long.compare(this.cost, p2.cost);
//         }

//     }
// }
class Solution {
    private long dijkstra(int src, int target, List<List<int[]>> adj, int n) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0]; int u = (int) top[1];
            if (d > dist[u]) continue;
            if (u == target) return d;

            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
        return INF;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        long l = 0, h = (int) 1e9, best = -1;

        while (l <= h) {
            long mid = l + (h - l) / 2;
            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

            for (int[] e : edges) {
                int u = e[0], v = e[1], c = e[2];
                if (c >= mid && online[u] && online[v]) {
                    adj.get(u).add(new int[]{v, c});
                }
            }

            long dist = dijkstra(0, n - 1, adj, n);
            if (dist <= k) {
                best = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (int) best;
    }
}
