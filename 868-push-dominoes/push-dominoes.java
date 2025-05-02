class Solution {
    public String pushDominoes(String dominoes) {
        
        int n = dominoes.length();
        int[]left = new int[n];
        int[]right = new int[n];
        char[]ans = new char[n];

        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        Arrays.fill(ans, '.');

        int count = 0;
        boolean encounter = false;

        for(int i=0; i<n; i++){

            char c = dominoes.charAt(i);

            if( encounter == false && c!='R') continue;

            if(c == 'R'){
                encounter = true;
                count = 0;
            }

            if(c == 'L'){
                encounter = false;
                continue;
            }

            right[i] = count;
            count++;

            
        }

        // System.out.println();

        encounter = false;

        for(int i=n-1; i>=0; i--){

            char c = dominoes.charAt(i);

            if( encounter == false && c!='L') continue;

            if(c == 'L'){
                encounter = true;
                count = 0;
            }

            if(c == 'R'){
                encounter = false;
                continue;
            }

            left[i] = count;
            count++;
            // System.out.print(left[i]+" ");
        }


        // for(int i: right)System.out.print( i == Integer.MAX_VALUE ? "- " : i+" ");

        // System.out.println();

        // for(int i: left)System.out.print( i == Integer.MAX_VALUE ? "- " : i+" ");



        for(int i=0; i<n; i++){

            if(right[i] == 0){
                while( i<n && right[i]<left[i]){
                    ans[i] = 'R';
                    i++;
                }
            }
        }
        for(int i=n-1; i>=0; i--){

            if(left[i] == 0){
                while( i>=0 && right[i]>left[i]){
                    ans[i] = 'L';
                    i--;
                }
            }
        }

        return new String(ans);

    }
}