class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        HashMap<Integer, Integer> st1 = new HashMap<>();
        HashMap<Integer, Integer> st2 = new HashMap<>();

        int ptr1 = node1;
        int ptr2 = node2;

        int dist = 0;

        while(ptr1 != -1 && !st1.containsKey(ptr1) ){

            st1.put(ptr1, dist);
            ptr1 = edges[ptr1];

            dist++;

        }

        dist = 0;
        int min_dist = Integer.MAX_VALUE;
        int ans = -1;

        while(ptr2 != -1 && !st2.containsKey(ptr2)){

            if(st1.containsKey(ptr2)){

                int val = st1.get(ptr2);

                if(min_dist > Math.max(dist , val) ){

                    ans = ptr2;
                    min_dist = Math.max(dist , val) ;
                }

                if(min_dist == Math.max(dist , val) ) ans = Math.min(ans, ptr2);

                
            }

            st2.put(ptr2, dist);
            ptr2 = edges[ptr2];

            dist++; 
        }

        // System.out.println(st1);
        // System.out.println(st2);



        return ans ;
    }
}