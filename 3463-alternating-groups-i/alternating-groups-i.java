class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int groups = 0;

        int n = colors.length;

        if(colors[n-2]==colors[0] && colors[0]!= colors[n-1]) groups++;
        if(colors[n-1]==colors[1] && colors[1]!= colors[0]) groups++;

        for(int i=2; i<n; i++){
            if(colors[i-2]==colors[i] && colors[i]!=colors[i-1]) groups++;
        }


        return groups;
    }
}