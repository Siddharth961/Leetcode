class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int modulo = 1000000007;
        
        int[][]arr = new int[n+1][2]; //arr[i][0] stores new people who gets to know secret on ith day while arr[i][1] stores old knowers of the secret

        arr[1][0] = 1; 

        for(int i=1; i<=n; i++){

            int propa = (arr[i][0] ) % modulo; // get people starting today then we will propagate through their impact

            for(int j = i+1; j < i + forget; j++){

                if(j>=arr.length || propa == 0) break;

               if(j>=i+delay) arr[j][0] = (int)((1L * arr[j][0] + propa) % modulo); // if we are out from delay we start adding new knowers of secret

                arr[j][1] = (int)((1L * arr[j][1] + propa) % modulo); // we add ourselves as old knowers
            }

            // System.out.println(arr[i][0] + " "+ arr[i][1]);
        }

        return (arr[n][0] + arr[n][1])%modulo; // on nth day we return new knowers of nth day plus old knowers who remember secret


    }
}
//  1     2   3    4    5    6



//  1,0  0,1  1,1  1,1
//                 1,2  1,1  1,1
//                      1,2  2,2
//                           2,3



           

      

     