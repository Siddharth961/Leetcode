class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int diff = 0;
        int i = 0;

        for( i=0; i<heights.length-1; i++){
             if(heights[i+1] <= heights[i]) continue;
            int required = heights[i+1] - heights[i];
            if(bricks >= required){
                bricks -= required;
                max.add(required);
            }else if(ladders > 0){
                if(max.size()!=0){
                    int maxBricksPast = max.peek();
                    if(maxBricksPast > required){
                        bricks += maxBricksPast;
                        max.poll();
                        bricks -= required;
                        max.add(required);
                    }
                }
                ladders--;
            }
            else break;
        }
       
        return i;
    }
}