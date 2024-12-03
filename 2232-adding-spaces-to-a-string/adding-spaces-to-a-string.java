class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        char[]arr = s.toCharArray();

        while(i<arr.length){
            if( j<spaces.length && i == spaces[j]){
                sb.append(' ');
                j++;
            }
            sb.append(arr[i]);
            i++;
        }

        return sb.toString();
    }
}