class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList< Edge >[] graph = new ArrayList[n];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[]arr : edges){
            
            graph[ arr[0] ].add( new Edge(arr[0], arr[2], arr[1]) );
            graph[ arr[1] ].add( new Edge(arr[1], arr[2], arr[0]) );
        }

        // for(int i=0; i<n; i++){
        //     if(graph[i] != null){
        //        for(Edge e : graph[i]){
        //         System.out.println(e.src+"--"+ e.dst +"--"+ e.wt);
        //        }
        //     }
        // }

        int min = n+1;
        int ans = 0;

        for(int i=0; i<n; i++){
            int neighbours = get_neighbours(i, graph, distanceThreshold);
            // System.out.println(neighbours);
            if(neighbours <= min){
                min = neighbours;
                ans = i;
            }
        }

        return ans;
    }

    public int get_neighbours(int src, ArrayList<Edge>[] graph, int threshold){

        int n = graph.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean[]visited = new boolean[n];
        int[]distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        pq.add(new Pair(src, 0));

        while(pq.size()>0){
            Pair p = pq.poll();
            if(visited[p.node]) continue;

            visited[p.node] = true;

            if(graph[p.node]==null) continue;

            for(Edge e : graph[p.node]){

                if(distance[e.src]+e.wt < distance[e.dst]){
                    distance[e.dst] = distance[e.src] + e.wt;
                    pq.add(new Pair(e.dst, distance[e.dst]));
                }
            }
        }

        int ans = 0;
        for(int i : distance) if(i <= threshold) ans ++;

        return ans;

    }

    public class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int n, int d){
            node = n;
            dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public class Edge{
        int src;
        int dst;
        int wt;

        Edge(int s, int w, int d){
            src = s;
            dst = d;
            wt = w;
        }
    }
}