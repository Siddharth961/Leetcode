class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int count = 0;

        char a=' ',b=' ',c=' ',d=' ';

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                count++;
                if(count==1){
                     a = arr1[i];
                     b = arr2[i];

                }
                if(count==2){
                     c = arr1[i];
                     d = arr2[i];
                }

                if(count>2) return false;
            }
        }

        if(count==0) return true;
        if(count==1) return false;
        if(a==d && b==c) return true;
        else return false;
    }
}