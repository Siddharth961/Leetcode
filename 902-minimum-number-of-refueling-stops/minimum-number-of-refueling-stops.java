class Solution {
    public int minRefuelStops(int target, int fuel, int[][] stations) {
        if(stations.length==0) return target<=fuel ? 0 : -1;
        
        PriorityQueue<Integer> max =  new PriorityQueue<>(Collections.reverseOrder());

        int stops=0;
        int maxpos = fuel;

        for(int i=0; i<stations.length; i++){
            if(maxpos >=target  ) return stops;
            // if(mp.containsKey(i)) max.add(mp.get(i));
            if(maxpos >= stations[i][0]) max.add(stations[i][1]);
            else{
                while(maxpos < stations[i][0] && max.size()>0){
                maxpos += max.poll();
                stops++;

                }
                if(maxpos < stations[i][0]) return -1;
                else max.add(stations[i][1]);
            }
            
        }

        while(maxpos < target && max.size()>0){
            maxpos += max.poll();
            stops++;
        }
        
        return maxpos>=target ? stops : -1;
    }
}