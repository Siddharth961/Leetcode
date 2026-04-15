class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        

        int ans = words.length + 1;

        for(int i=0; i<words.length; i++){
            if(words[i].equals(target) ){

                int a = Math.abs(i - startIndex);
                int b = (words.length - i) + startIndex; 
                int c = i + (words.length - startIndex);

                ans = Math.min(ans , Math.min(a, Math.min(b, c)));
            }
        }

        return ans == words.length + 1 ? -1 : ans;
    }
}