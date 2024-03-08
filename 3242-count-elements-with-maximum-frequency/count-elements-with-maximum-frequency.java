class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(max < i) max = i;

        }

        int[]freq = new int[max+1];

        for(int i : nums) freq[i]++;

        int maxfreq = 0;

        for(int f : freq) if(maxfreq < f) maxfreq = f;

        int elements_with_maxfreq = 0;

        for(int i = 0; i<freq.length; i++){
            if(freq[i]==maxfreq) elements_with_maxfreq++;
        }

        return elements_with_maxfreq * maxfreq;
    }
}