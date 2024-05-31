class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        String[]arr = s.split(" ");

        
        
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length-1; i>=0; i--){
            arr[i] = arr[i].trim();
            if(arr[i].length()>0){
                sb.append(arr[i]);
                sb.append(" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}