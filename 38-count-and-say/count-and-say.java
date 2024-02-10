class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        sb =  get_ans(2,sb,n);
        return sb.toString();
    }

    public StringBuilder get_ans(int num, StringBuilder s, int n){
        if(num>n) return s;

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i<s.length()){

            char c = s.charAt(i);
            int count = 0;

            while(i<s.length() && s.charAt(i) == c ){
                i++;
                count++;
            }

            sb.append(count);
            sb.append(c);
        }

        // System.out.println(n + "---------" + sb);

        return get_ans(num+1, sb, n);
    }
}