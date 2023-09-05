class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> al = new ArrayList<>();
        int part = 0;
        int count=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int x = s.lastIndexOf(c);

            if(part<x) part=x;

            count++;

            if(i==part){
                al.add(count);
                count=0;
            }

        }

        return al;
    }
}