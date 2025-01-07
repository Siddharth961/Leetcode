class Solution {
    public int ladderLength(String begin, String end, List<String> list) {
        
        List< List<Integer> > graph = new LinkedList<>();

        for(int i=0; i<list.size(); i++){
            graph.add( new LinkedList<>() );
        }

        int src = -1;
        int tar = -1;

        String s;

        for(int i=0; i<list.size(); i++){

            s = list.get(i);

            if(s.equals(begin) ) src = i;
            if(s.equals(end) ) tar = i;

            for(int j = 0; j<list.size(); j++){

                if(i == j) continue;
                
                if(compare( i, j, list) ){
                    graph.get(i).add(j); 
                }
            }
        }

        if(src == -1){

            graph.add( new LinkedList<>() );
            list.add(begin);

            src = graph.size()-1;

            for(int j = 0; j<list.size(); j++){
                
                if(compare( src, j, list) ){
                    graph.get(src).add(j);
                    graph.get(j).add(src);
                }
            }

            
        }

        // for(int i = 0; i<graph.size(); i++){
        //     System.out.print(i+" -- ");

        //     for(int j : graph.get(i)){
        //         System.out.print(j+" ");
        //     }

        //     System.out.println();
        // }
        // System.out.println("------------");

        return travel(src, tar, graph);

    }

    public boolean compare(int i, int j, List<String> list){

        String s1 = list.get(i);
        String s2 = list.get(j);

        boolean change = false;

        for(int k=0; k<s1.length(); k++){

            if( s1.charAt(k) != s2.charAt(k) ){
                if(change) return false;
                else change = true;
            }

        }

        return change;

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

    public int travel( int src, int tar, List<List<Integer>> graph){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[]visited = new boolean[graph.size()];

        int[]distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 1;

        pq.add( new Pair(src, 1));

        while(pq.size()>0 ){

            Pair p = pq.poll();

            if( visited[p.node] ) continue;

            if(p.node == tar) return p.dist;

            visited[p.node] = true;

            for(int neighbour : graph.get(p.node) ){

                if(distance[neighbour] > distance[p.node] + 1){
                    distance[neighbour] = distance[src] + 1;
                    pq.add( new Pair(neighbour, p.dist+1 ) );
                }
            }
        }

        return 0;
    }
}