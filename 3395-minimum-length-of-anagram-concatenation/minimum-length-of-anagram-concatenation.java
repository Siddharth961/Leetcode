class Solution {
    public int minAnagramLength(String s) {
        ArrayList<Integer> al = factors(s.length());
        int[]arr = new int[26];

        // for(int i : al) System.out.print(i+" ");

        int idx = 0;

        char[]word = s.toCharArray();

        for(int i=0; i<word.length; i++){

            arr[ word[i]-'a' ]++;

            if(i+1 == al.get(idx)){
                
                if(check(al.get(idx), i+1, word, arr) == true) return i+1;;
                idx++;
            }
        }

        return s.length();
    }

    public ArrayList<Integer> factors(int n){

        ArrayList<Integer> al = new ArrayList<>();

        for(int i=1; i<=n; i++) if(n%i==0) al.add(i);

        return al;
    }

    public boolean check(int len, int idx, char[]word, int[]arr ){

        int[]temp = new int[26];

        

        while(idx<word.length){

            for(int count = len; count>0; count--){
                temp[ word[idx]-'a' ] ++;
                idx++;
            }

            for(int i=0; i<26; i++){
                if(arr[i]>0){
                    if(temp[i]==0 || temp[i]%arr[i]!=0) return false;
                }
                if(arr[i]==0 && temp[i]>0) return false;
            }
        }

        return true;
    }
}
