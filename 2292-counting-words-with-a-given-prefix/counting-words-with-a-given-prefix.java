class Solution {
    public int prefixCount(String[] words, String pref) {
        int original=0;
        for(int i=0;i<words.length;i++){
            String sw=words[i];
            int index=0;
            int count=0;
            while(index<sw.length() && index<pref.length()){
                if(sw.charAt(index)==pref.charAt(index)){
                    count++;
                }
                if(count==pref.length()){
                    original++;
                }
                index++;
            }
        }
        return original ;
    }
}