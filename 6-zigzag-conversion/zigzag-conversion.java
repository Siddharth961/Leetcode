class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        StringBuilder[] arr = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++) arr[i] = new StringBuilder();

        int j=0;
        boolean dir_down = true;

        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);

            arr[j].append(c);

            if(dir_down) j++;
            else j--;

            if(j == numRows){
                dir_down = false;
                j = numRows-2;
            }
            else if( j < 0){
                dir_down = true;
                j = 1;
            }
        }

        for(int i=1; i<numRows; i++){
            
            arr[0].append(arr[i]);
        }

        return arr[0].toString();
    }
}