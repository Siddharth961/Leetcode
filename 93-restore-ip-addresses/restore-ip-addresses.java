class Solution {
    List<String> al = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int min = s.length()/4;
        // StringBuilder asf = new StringBuilder();

        get_ans(s, "", 1);

        return al;
    }

    public void get_ans(String s, String asf, int bit){
        if(bit==4){
            if( valid(s)) al.add(asf + s);
            return;
        }

      

        for(int i=1; i<4 && i<s.length()+1; i++){
            String this_bit = s.substring(0,i);
            if( !valid(this_bit)) return;

            

            String to_pass = s.substring(i, s.length());

            get_ans(to_pass, asf + this_bit + ".", bit+1);

        }
    }

    public boolean valid(String s){
        if(s.length() == 1) return true;
        if(s.length() > 3 || s.length()<=0){
            
            return false;
        }

        if(s.charAt(0) == '0') return false;

        int a = s.charAt(0) - '0';
        int i = 1;
        while(i<s.length()){
            a = a*10;
            a += s.charAt(i) - '0';
            i++;
        }
        if( a>=0 && a <256 ) return true;
        return false;
    }
}