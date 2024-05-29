class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            diff[i] = Math.abs((int)(s.charAt(i))-(int)(t.charAt(i)));
            
            
        }

        int cost = 0;
        int i=0;
        int j=0;
        int len = 0;

        while(j<diff.length){

            cost += diff[j];
            while( i<=j && cost>maxCost){
                cost -= diff[i];
                len = Math.max( len, j-i);
                i++;
            }
                len = Math.max( len, j-i+1);
            j++;
        }

        return len;
    }
}