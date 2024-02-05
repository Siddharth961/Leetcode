class Solution {
    public int countSegments(String s) {
        boolean encounter = false;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c != ' ' && encounter==false){
                count++;
                encounter = true;
            }

            if(c == ' ' && encounter==true) encounter = false;
        }
        return count;
    }
}