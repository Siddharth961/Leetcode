class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        String temp = "";

        while(i<s.length()){
            char c = s.charAt(i);
            i++;
            if(c=='['){
                temp = decodeString(s);
                for(int j=0; j<num; j++){
                    sb.append(temp);
                }

                num = 0;
                
                            
            }

            else if(c==']') break;

            else if(Character.isAlphabetic(c)) sb.append(c);
            else{
                num = num * 10 + c - '0';
            }
        }

        return sb.toString();

    }
}