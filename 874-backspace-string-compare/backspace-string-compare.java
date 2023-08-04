class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(i<sb.length()){
            if(i==0 && sb.charAt(i)=='#')sb.delete(i,i+1);
            
            else if(sb.charAt(i)=='#'){
                sb.delete(i-1,i+1);
                i--;
            }
            else i++;
        }
        String s1 = sb.toString();
        
        sb = new StringBuilder(t);
         i=0;
        while(i<sb.length()){
            if(i==0 && sb.charAt(i)=='#')sb.delete(i,i+1);

            else if(sb.charAt(i)=='#'){
                sb.delete(i-1,i+1);
                i--;
            }
            else i++;
        }
        String s2 = sb.toString();
        return s1.equals(s2);
    }
}