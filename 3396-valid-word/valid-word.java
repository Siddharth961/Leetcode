class Solution {
    public boolean isValid(String word) {

        if(word.length() < 3) return false;

        HashSet<Character> st = new HashSet( Arrays.asList('a', 'e', 'i', 'o' , 'u', 'A', 'E', 'I', 'O', 'U'));

        boolean vowel = false;
        boolean conso = false;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if( c>='0' && c<='9') continue;

            else if( (c>='a' && c<='z') || (c>='A' && c<='Z')){
                
                if( st.contains(c)) vowel = true;
                else conso = true;
            }

            else return false;
        }

        return vowel && conso;
    }
}