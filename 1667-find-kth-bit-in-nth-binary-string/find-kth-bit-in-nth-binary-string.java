class Solution {
    public char findKthBit(int n, int k) {
        String str = bits(n);
        return str.charAt(k-1);
    }

    public String bits(int n){
        if(n==1) return "0";

        String str = bits(n-1);
        StringBuilder sb = new StringBuilder();
        sb.append(str+"1");
        for(int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(c=='1') sb.append("0");
            else sb.append("1");
        }

        return sb.toString();
    }
}