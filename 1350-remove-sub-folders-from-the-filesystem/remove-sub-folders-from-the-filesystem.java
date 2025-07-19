class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        String prev = folder[0] + "/";

        List<String>ans = new LinkedList<>();

        ans.add(folder[0]);

        for(int i=1; i<folder.length; i++){

            if( !folder[i].startsWith(prev)){
                prev = folder[i] + "/";
                ans.add(folder[i]);
            }
        }

        return ans;
    }
}