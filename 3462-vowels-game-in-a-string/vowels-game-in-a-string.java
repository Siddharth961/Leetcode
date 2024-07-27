class Solution {
    public boolean doesAliceWin(String s) {
        return turn('a', 0, s.toCharArray());
    }

    public boolean turn( char player, int idx, char[]arr ){

        System.out.println(idx);

        if(idx == arr.length){
            if(player == 'a') return false;
            return true;
        }

        int even = -1;
        int odd = -1;

        int vowels = 0;

        for( int i=idx; i<arr.length; i++){
            if( check_vowel(arr[i]) ){
                vowels++;
                if(vowels%2 == 0) even = i;
                else odd = i;
            }
        }

        // if(idx==7) System.out.println(player+"---"+vowels+"--"+odd+"-- "+even);

        if(vowels == 0){
            return player=='a' ? false : true;
        }

        if(player=='a'){
            if( even < odd ) idx = arr.length;
            else idx = even;
        }
        else{
            // if(even==-1) return true;
            if( odd < even ) idx = arr.length;
            else idx = odd;
        }

        player = (player=='a') ? 'b' : 'a' ;

        return turn(player, idx, arr);
    }

    public boolean check_vowel(char a){
        if( a=='a' || a=='e' || a=='i' || a=='o' || a=='u') return true;
        return false;
    }
}