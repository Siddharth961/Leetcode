class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> al = new ArrayList<>();
        String s = "";

        for(int i=0; i<words.length; i++){
            s = words[i];
            for(char c : s.toCharArray()){
                if(c==x){
                    al.add(i);
                    break;
                }
            }
        }
        return al;
    }
}