class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        travel(0, s, new ArrayList<>());
        return ans;
    }

    public void travel(int idx, String s, List<String>ssf ){


        if(idx == s.length()){
            ans.add( new ArrayList<>(ssf) );
            return;
        }

        for(int end = idx; end < s.length(); end++){
            String part = s.substring(idx, end+1);

            if( (isPalindrome(part)) ){

                // valid partition

                ssf.add(part);
                travel(end+1, s, ssf);
                ssf.remove( ssf.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s){

        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}