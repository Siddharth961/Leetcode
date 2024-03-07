class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') sb.append(c);
        }

        sb.reverse();

        int i=0; 
        int j=0;

        for(char c : s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                ans.append( sb.charAt(j) );
                j++;
            }
            else ans.append(c);
        }

        return ans.toString();
    }
}