class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char[]arr = word.toCharArray();

        char prev = arr[0];
        int count = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i] || count==9){
                sb.append(count);
                sb.append(prev);
                prev = arr[i];
                count = 1;
            }
            else count++;
        }

        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}