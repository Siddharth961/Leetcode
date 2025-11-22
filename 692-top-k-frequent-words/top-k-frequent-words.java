class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();

        for(String s : words){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        List<String>[]arr = new List[words.length];

        for(var s : mp.keySet() ){

            int idx = mp.get(s);

            if(arr[idx] == null) arr[idx] = new LinkedList<>();

            arr[idx].add(s);
        }

        List<String> ans = new LinkedList<>();

        for(int i=arr.length-1; i >= 0; i--){


            if(arr[i] == null) continue;

            Collections.sort(arr[i]);

            for(String s : arr[i]){

                ans.add(s);
                k--;
                if(k == 0) break;
            }
            if(k == 0) break;
        }

        return ans;
    }
}