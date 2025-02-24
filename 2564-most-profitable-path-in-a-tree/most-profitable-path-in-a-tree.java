class Solution {
    LinkedList<Integer>[] tree;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = edges.length+1;

        tree = new LinkedList[n];
        for(int i=0; i<tree.length; i++) tree[i] = new LinkedList<>();

        for(int[]arr : edges){
            tree[ arr[0] ].add(arr[1]);
            tree[ arr[1] ].add(arr[0]);
        }

        HashMap<Integer, Integer>bob_time = new HashMap<>();

        bob_travel(0, bob, -1, bob_time);
        // System.out.println(bob_time);

        return alice_travel(0, 0, -1, amount, bob_time);
    }

    public int alice_travel(int alice, int time, int par, int[]amount, HashMap<Integer, Integer>mp){

        int sum = 0;

        if(mp.containsKey(alice) ){
            
            if(mp.get(alice) == time) sum += amount[alice]/2;
            else if(mp.get(alice) > time) sum += amount[alice];

            // if(alice == 0) System.out.println(sum+" -- "+time);

        }

        else sum += amount[alice];

        int val = Integer.MIN_VALUE;

        for(int child : tree[alice]){
            if(child == par) continue;
            val = Math.max(val, alice_travel(child, time+1, alice, amount, mp) );
        }

        if(val == Integer.MIN_VALUE) val = 0;

        return sum + val ;

        
    }

    public int bob_travel( int root, int tar, int par, HashMap<Integer, Integer>time){
        if( root == tar){
            time.put( root, 0);

            return 1;
        }

        for( int child : tree[root]){

            if(child == par) continue;

            int val = bob_travel(child, tar, root, time);

            if(val != -1){
                time.put(root, val);
                return val+1;
            }

        }

        return -1;

        
    }
}