class Solution {

    public class DSU{
        int[]parent;
        int[]size ;

        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findPar(int curr){

            if(parent[curr] == curr) return curr;

            int ult_par = findPar( parent[curr] );

            parent[curr] = ult_par;

            return ult_par;

        }

        public void union(int a, int b){

            int ult_a = findPar(a);
            int ult_b = findPar(b);

            if(ult_a == ult_b) return;

            if(size[ult_a] > size[ult_b]){

                parent[ult_b] = ult_a;
                size[ult_a] += size[ult_b];
            }
            else{
                parent[ult_a] = ult_b;
                size[ult_b] += size[ult_a];
            }
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        

        DSU d = new DSU(source.length);

        for(int[]arr : allowedSwaps){
            d.union(arr[0], arr[1]);
        }

        HashMap<Integer, HashMap<Integer, Integer>> mp = new HashMap<>();
        //  par -> ( element -> frequency )
        // for each componenet stores frequency of elements present in it

        for(int i=0; i<d.parent.length; i++){

            int par = d.findPar(i);

            if(!mp.containsKey(par) ) mp.put(par, new HashMap<>());

            HashMap<Integer,Integer> sub_mp = mp.get(par);

            sub_mp.put( source[i] , sub_mp.getOrDefault(source[i], 0) + 1 );
        }

        // System.out.println(mp);

        int ans = 0;

        for(int i=0; i<source.length; i++){

            int par = d.findPar(i);

            HashMap<Integer,Integer> sub_mp = mp.get(par); // freq map of this component

            if( !sub_mp.containsKey( target[i] ) ){
                // the componenet doesnt have this element at all
                ans++;
            }
            else{

                sub_mp.put(target[i], sub_mp.getOrDefault(target[i], 0) - 1);

                if(sub_mp.get(target[i]) == 0) sub_mp.remove(target[i]);

                
            }


        }

        return ans;


    }
}