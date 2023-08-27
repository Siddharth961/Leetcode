class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mp  = new HashMap<>();

        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        int ans = 0;

        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            
            if(i<s.length()-1){
                char b = s.charAt(i+1);
                if(mp.get(a)<mp.get(b)){
                    ans += mp.get(b)-mp.get(a);
                    i++;
                }

                else ans += mp.get(a);
            }

            else ans += mp.get(a);

        } 

        return ans;
    }
}