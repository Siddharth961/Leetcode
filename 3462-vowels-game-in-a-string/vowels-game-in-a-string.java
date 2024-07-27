class Solution {
    public boolean doesAliceWin(String s) {

        for(char c : s.toCharArray()){
            if( check_vowel(c)) return true;
        }

        return false;
        
    }

    

    public boolean check_vowel(char a){
        if( a=='a' || a=='e' || a=='i' || a=='o' || a=='u') return true;
        return false;
    }
}