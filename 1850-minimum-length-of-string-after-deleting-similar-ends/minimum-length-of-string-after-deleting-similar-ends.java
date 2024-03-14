class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        int previ = 0;
        int prevj = j;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return j-i+1;

            char c = s.charAt(i);
            while(i<j){
                 previ = i;
                 prevj = j;
                if(s.charAt(i)==c) i++;
                if(s.charAt(j)==c) j--;

                if(previ==i && prevj==j)break;
            }

        }

        // System.out.println(((prevj-previ + 1)%2 != 0) +"--"+ (i==j) +"--"+ ((i-1)>=0) +"--"+ (s.charAt(i-1)==s.charAt(i)));

        if((prevj-previ + 1)%2!=0 && i==j && i-1>=0 && s.charAt(i-1)==s.charAt(i)){
            
            return 0 ;
        }

        return j-i+1;
    }
}