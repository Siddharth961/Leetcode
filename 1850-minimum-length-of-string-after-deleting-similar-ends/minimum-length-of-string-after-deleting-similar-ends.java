class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        int previ = 0;
        int prevj = j;

        while(i<j && s.charAt(i)==s.charAt(j)){

            char c = s.charAt(i);
            while(i<j && s.charAt(i)==c){

                i++;               
            }
            while(j>=i && s.charAt(j)==c){

                j--;               
            }

        }

       

        

        return j-i+1;
    }
}