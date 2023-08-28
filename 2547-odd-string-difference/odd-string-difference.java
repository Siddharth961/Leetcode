class Solution {
    public String oddString(String[] words) {
        HashMap<String, String> m1 = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();
        
        for(String s : words){
            String str = calc(s);

            m1.put(str,s);
            m2.put(str,m2.getOrDefault(str,0)+1); 
        }
        System.out.println(m1);
        System.out.println(m2);
         for(String s1:m2.keySet()){
            if(m2.get(s1)==1)return m1.get(s1);
        }
        return "";
        
    }

    public String calc(String s){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length()-1; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);

            sb.append(b-a);
            sb.append(" ");
        }

        System.out.println(sb);

        return sb.toString();
    }
}