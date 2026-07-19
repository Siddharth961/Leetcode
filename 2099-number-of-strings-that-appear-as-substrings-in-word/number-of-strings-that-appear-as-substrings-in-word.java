class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String s : patterns){
            int val = search(s, word);
            if(val == 1){
                System.out.println(s);
                ans++;
            }
        }

        return ans;
    }

    public int search(String s, String tar){
        int[]lps = buildLPS(s);

        int i=0;
        int j=0;

        while(i < tar.length()){
            
            while(j != 0 && tar.charAt(i) != s.charAt(j)){
                j = lps[j-1];
            }

            if(tar.charAt(i) == s.charAt(j)) j++;
            if(j == s.length()) return 1;

            i++;
        }

        return 0;
    }

    public int[] buildLPS(String s){

        int len=0;
        int[]lps = new int[s.length()];

        for(int i=1; i<lps.length; i++){

            while( len != 0 && s.charAt(len) != s.charAt(i) ){
                len = lps[len-1];

            }

            if(s.charAt(len) == s.charAt(i)) len++;

            lps[i] = len;

        }

        return lps;
    }
}