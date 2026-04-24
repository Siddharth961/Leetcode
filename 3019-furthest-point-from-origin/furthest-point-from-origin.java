class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int fix = 0;
        int var = 0;

        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);

            if(c == 'L') fix--;
            if(c == 'R') fix++;
            if(c == '_')var++;
        }

        return Math.abs(fix) + var;
    }
}