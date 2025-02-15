class Solution {
    public boolean isRobotBounded(String inst) {
        
        int x = 0;
        int y = 0;

        int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int d = 0;

        for(int i=0; i<inst.length(); i++){
            char c = inst.charAt(i);

            if( c == 'G'){

                x += dir[d][0];
                y += dir[d][1];
            }
            else if( c=='L') d = ((d-1)+4)%4;
            else d = (d+1)%4;
        }

        if( (x==0 && y==0) || d!=0 ) return true;
        return false;
    }
}