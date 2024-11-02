class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[]n = name.toCharArray();
        char[]t = typed.toCharArray();

        int i=0;
        int j=0;
        char prev = n[0];
        
        while(i<n.length && j<t.length){
            // System.out.println(i+"--"+j+"--"+prev);
            if(n[i] == t[j]){
                prev = n[i];
                i++;
                j++;
            }
            else if(t[j] == prev){
                j++;

            }
            else return false;
        }



        if( i < n.length) return false;

        
        while(j<t.length){
            if(t[j] != n[i-1]) return false;
            j++;
        }

        return true;
    }
}