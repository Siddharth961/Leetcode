class Solution {
    public int compress(char[] arr) {
        
        int i= -1;
        int j=1;
        int count = 1;

        while(j < arr.length){
            
            if(arr[j-1] != arr[j]){
                i++;
                arr[i] = arr[j-1];

                if( count > 1){
                    
                    String s = count+"";

                    for(int k=0; k<s.length(); k++){

                        i++;
                        arr[i] = s.charAt(k);
                    }
                }

                count = 0;
            }

            count++;
            j++;
        }

        i++;
        arr[i] = arr[j-1];

        if( count > 1){
            
            String s = count+"";

            for(int k=0; k<s.length(); k++){

                i++;
                arr[i] = s.charAt(k);
            }
        }

        return i+1;

    }
}