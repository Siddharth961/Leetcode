class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get( arrays.get(0).size()-1 );

        int dist = 0;
        int cmin = 0;
        int cmax = 0;

        for(int i=1; i<arrays.size(); i++){

            cmin = arrays.get(i).get(0);
            cmax = arrays.get(i).get( arrays.get(i).size() - 1);
            
            dist = Math.max( dist, Math.abs( max - cmin));
            dist = Math.max( dist, Math.abs( cmax - min));

            max = Math.max( max, cmax);
            min = Math.min( min, cmin);

        }

        return dist;
    }
}