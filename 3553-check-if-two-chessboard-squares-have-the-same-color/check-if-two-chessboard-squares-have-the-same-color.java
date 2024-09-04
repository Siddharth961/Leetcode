class Solution {
    public boolean checkTwoChessboards(String cord1, String cord2) {
        int x1 = cord1.charAt(0) - 'a';
        int y1 = cord1.charAt(1) - '1';
        int x2 = cord2.charAt(0) - 'a';
        int y2 = cord2.charAt(1) - '1';

        if( (x1+y1)%2 == (x2+y2)%2) return true;
        return false;
    }
}