class Solution {
    public long maximumPoints(int[] energy, int curr) {
        long points=0;
        
        int i=0;
        int j=energy.length-1;

        Arrays.sort(energy);

        while(i<=j){
            points += curr/energy[i];
            curr = curr%energy[i];

            if(points==0) break;
            
            curr += energy[j];
            j--;
        }

        return points;

    }
}