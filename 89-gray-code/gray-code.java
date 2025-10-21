class Solution {
    HashSet<Integer> st = new HashSet<>();
    List<Integer>ans;

    public List<Integer> grayCode(int n) {
        
         travel(new int[n], 0, new LinkedList<>());

         return ans;
    }

    public boolean travel(int[]arr, int curr, LinkedList<Integer> al){


        if( st.contains(curr) ) return false;

        st.add(curr);
        al.add(curr);
        
        if( st.size() == Math.pow(2, arr.length)){

            int count = 0;
            for(int i : arr){
                count += i;
                
            }

            if(count == 1){

                ans = new LinkedList<>(al);

            }

            al.remove( al.size() - 1);

            st.remove(curr);

            return count == 1;
        }

        boolean val = false;
        for(int i=0; i<arr.length; i++){


            if( arr[i] == 0){

                arr[i] = 1;
                val = travel(arr, curr + (int)Math.pow(2, i) , al);
                arr[i] = 0;
            }
            else{
                arr[i] = 0;
                val = travel(arr, curr - (int)Math.pow(2, i), al);
                arr[i] = 1;
            }

            if(val == true) break;
        }

        al.remove( al.size() - 1);

        st.remove(curr);

        return val;
    }
}