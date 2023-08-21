class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> mp = new HashMap<>();

        int i = 97;
        for(char c: key.toCharArray()){
            if(c==' ')continue;
            if(mp.containsKey(c)==false){
                mp.put(c, (char)i);
                i++;

            }
            if(i==123)break; 
        }

        System.out.print(mp);

        StringBuilder sb = new StringBuilder();

        for(char c : message.toCharArray()){            
            if(c==' ')sb.append(' ');
            else sb.append(mp.get(c));

        }

        return sb.toString();
    }
}