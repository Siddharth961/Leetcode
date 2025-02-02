class Solution {
    public int maxDistance(String s, int k) {
        
        int ans = 0;
        char[][] dir = new char[][]{{'N', 'E'}, {'N', 'W'},{'S', 'E'},{'S', 'W'}};

        int temp = k;
        int dist = 0;

        for(char[]d : dir){

            temp = k;
            dist = 0;

            for(int i=0; i<s.length(); i++){

                char c = s.charAt(i);

                if( c == d[0] || c == d[1]) dist++;
                else{
                    if( temp > 0){
                        temp--;
                        dist++;
                    }

                    else dist--;
                }
                ans = Math.max(ans, dist);
            }

        }

        return ans;
    }
}