class Solution {
    public int minJumps(int[] arr) {
        
        HashMap<Integer, List<Integer> > mp = new HashMap<>();

        for(int i=0; i<arr.length; i++){

            if(!mp.containsKey(arr[i])) mp.put(arr[i], new LinkedList<>());

            mp.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[]visited = new boolean[arr.length];

        q.add(0);
        visited[0] = true;

        int jumps = 0;

        while(q.size() > 0){
            


            int k = q.size();

            // System.out.println(q);

            while(k > 0){

                // have marked node visited already -- but now doing propagation
                int node = q.remove();

                if(node == arr.length-1) return jumps;

                if(node > 0){
                    if(visited[node-1] == false){
                        q.add(node-1);
                        visited[node-1] = true;
                    }
                }

                if(node < arr.length-1){
                     if(visited[node+1] == false){
                        q.add(node+1);
                        visited[node+1] = true;
                    }
                }

                if(mp.containsKey(arr[node]) ){
                    for(int neig : mp.get(arr[node])){

                        // if(neig == node) continue;

                        if(visited[neig] == false){
                            visited[neig] = true;
                            q.add(neig);

                        }

                    }
                    mp.remove(arr[node]);
                }


                k--;
            }

            jumps++;
        }

        return -1;

    }
}