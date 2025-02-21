class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(String s : nums){
            sb.append(s.charAt(idx) == '0' ? '1' : '0');
            idx++;
        }

        return sb.toString(); 
    }
}