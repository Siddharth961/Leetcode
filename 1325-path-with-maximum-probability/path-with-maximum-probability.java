class Solution {

    class Edge{
        int src;
        double prob;
        int dst;
        Edge(int s, double p, int d){
            src = s;
            prob = p;
            dst = d;
        }
    }

    class Pair implements Comparable<Pair>{
        int node;
        double prob;
        Pair(int n, double p){
            node = n;
            prob = p;
        }

        @Override
        public int compareTo( Pair p2 ){
            return Double.compare(this.prob, p2.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();


        for(int i=0; i<edges.length; i++){
            graph[edges[i][0]].add( new Edge(edges[i][0], succProb[i], edges[i][1]) );
            graph[edges[i][1]].add( new Edge(edges[i][1], succProb[i], edges[i][0]) );
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        double[]dist = new double[n];
        dist[start_node] = 1;
        boolean[]visited = new boolean[n];

        pq.add( new Pair(start_node, 1));

        while(pq.size()>0){
            Pair p = pq.poll();
            if(visited[p.node]) continue;
            visited[p.node] = true;

            for(Edge e : graph[p.node]){
            
                if( p.prob*e.prob > dist[e.dst]){
                    dist[e.dst] = p.prob*e.prob;
                    pq.add( new Pair( e.dst, dist[e.dst]));
                }
            }
        }

        return dist[end_node];

    }

    public void print_pq(PriorityQueue<Pair> pq){
        for(Pair p : pq){
            System.out.print(p.node+"--"+p.prob+", ");
        }
        System.out.println();
    }
}