class Solution {
    public String makeFancyString(String s) {
       StringBuilder sb = new StringBuilder();

       for(int i=0; i<s.length(); i++){

        char c = s.charAt(i);

        if(i == 0) sb.append(c);
        else if( i < s.length() - 1){
            if( !(c == sb.charAt( sb.length() - 1) && c == s.charAt(i + 1)) ){
                sb.append(c);
            }
        }
        else sb.append(c);
       } 

       return sb.toString();
    }
}