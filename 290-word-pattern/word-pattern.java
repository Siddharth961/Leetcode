class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mp = new HashMap<>();
        HashMap<String ,Character > mp2 = new HashMap<>();
        String[]st = s.split(" ");

        if(st.length != pattern.length()) return false;

        int i=0;

        for(char c : pattern.toCharArray()){      

            if(mp2.containsKey(st[i]) && mp2.get(st[i])!=c) return false;

            if(mp.containsKey(c)==false){
                mp.put(c,st[i]);
                mp2.put(st[i],c);
            }

            else{ 
                if(mp.get(c).equals(st[i])==false)return false;
            }

            System.out.println(mp);

            i++;


        }

        System.out.println(mp);

        return true;
    }

}