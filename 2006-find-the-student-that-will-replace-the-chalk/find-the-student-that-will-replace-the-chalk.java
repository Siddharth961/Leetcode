class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for(int i : chalk) total += i;
        long rem = k % total;

        for(int i=0; i<chalk.length; i++){
            if(chalk[i] > rem) return i;
            rem -= chalk[i];

        }

        return -1;

    }
}