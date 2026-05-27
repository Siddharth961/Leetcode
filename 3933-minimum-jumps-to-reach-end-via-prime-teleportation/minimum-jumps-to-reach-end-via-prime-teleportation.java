class Solution {
    static final int n = 1000001;
    static boolean[]not_prime = new boolean[n];

    static {

        // Arrays.fill(prime, true);
        not_prime[0] = true;
        not_prime[1] = true;

        for(int i=2; i*i < not_prime.length; i++){

            // if i is prime, need to make sure its factors are not prime
            if( not_prime[i] == false){
                for(int j = i*i; j<not_prime.length; j+=i){

                    not_prime[j] = true;

                }
            }
        }

    }
    public int minJumps(int[] nums) {

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        int max = 0;

        for(int i=0; i<nums.length; i++){

            if(!mp.containsKey(nums[i])) mp.put(nums[i], new LinkedList<>());

            mp.get(nums[i]).add(i);

            max = Math.max(nums[i], max);
        }

        boolean[]visited = new boolean[nums.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        int jumps = 0;

        while(q.size() > 0){

            int k = q.size();

            while(k > 0){

                int node = q.remove();

                if(node == nums.length-1) return jumps;

                if(node - 1 >= 0 && visited[node-1] == false){
                    q.add(node-1);
                    visited[node-1] = true;
                }
                if(node + 1 < nums.length && visited[node+1] == false){
                    q.add(node+1);
                    visited[node+1] = true;
                }

                if(not_prime[ nums[node] ] == false){

                    for(int i=nums[node]; i <= max; i += nums[node]){

                        if( mp.containsKey(i)){

                            for(int neig : mp.get(i)){
                                if(visited[neig] == false){
                                    q.add(neig);
                                    visited[neig] = true;
                                }
                            }

                            mp.remove(i);
                        }
                    }
                }

                k--;
            }

            jumps++;
        }

        return -1;

    }
}