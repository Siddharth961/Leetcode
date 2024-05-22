class Solution {

    List<List<String>> ans = new ArrayList();
    List<String> al = new ArrayList();

    public List<List<String>> partition(String s) {
        get_ans("", s);
        return ans;
    }

    public void get_ans( String left, String right){

        

        if( check(left)==false ) return;

        if(right.length()==0){

            al.add(left);

      
            ans.add( new ArrayList<>(al) );

            al.remove(al.size()-1);
            return;
        }

        if(left.length()>0) al.add(left);

        for(int i=0; i<right.length(); i++){

            String l = right.substring(0, i+1);
            String r = right.substring(i+1, right.length());
            
            get_ans(l, r);

        }

        if(al.size()>0) al.remove(al.size()-1);
    }

    public boolean check(String s){
        if(s.length()==0) return true;

        char[]arr =s.toCharArray();

        int i=0;
        int j=arr.length-1;

        while(i<=j){
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }

        return true;

    }
}