class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = 0;
        double wait = 0;

        for(int[]arr : customers){
            if(time < arr[0]) time = arr[0];
            wait += time - arr[0]  + arr[1];
            time += arr[1];
        }

        return wait/customers.length;

    }
}