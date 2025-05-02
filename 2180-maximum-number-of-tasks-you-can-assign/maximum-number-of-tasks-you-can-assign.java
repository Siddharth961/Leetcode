class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;

        int ans = 0;

        int l = 0;
        int h = n;
        int mid = 0;

        while( l <= h){
            mid = (l+h)/2;

            boolean val = calc( mid, tasks, workers, pills, strength );

            // System.out.println( mid +" "+val);

            if( val == true){
                ans = mid;
                l = mid + 1;
            }
            else h = mid-1;
        }

        return ans;
    }

    public boolean calc( int tar, int[] tasks, int[] workers, int pills, int strength){

        if(tar > workers.length ) return false;


        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int i = workers.length - tar; i < workers.length; i++){

            mp.put(workers[i], mp.getOrDefault(workers[i], 0) + 1);
        }

        int idx = tar-1;

        while(idx >= 0){

            int w = mp.lastKey();


            if( tasks[idx] <= w ){

                mp.put(w, mp.get(w) - 1);
                if(mp.get(w) == 0) mp.remove(w);
                
                idx--;
            }
            else{
                if(pills > 0){

                    Integer candi = mp.ceilingKey( tasks[idx] - strength);

                    if(candi == null) return false;

                    mp.put(candi, mp.get(candi) - 1);
                    if(mp.get(candi) == 0) mp.remove(candi);

                    idx--;
                    pills--;
                
                }

                else return false;
            }

        }

        return true;
    }
}