class Solution {
    public List<List<String>> wordSquares(String[] words) {
        
        List<List<String>> ans = new LinkedList<>();

        Arrays.sort(words);

        for(int top = 0; top < words.length; top++){

            for(int left = 0; left < words.length; left++){

                if(left == top) continue;

                if(words[top].charAt(0) == words[left].charAt(0)){

                    for(int right=0; right<words.length; right++){

                        if(right == top || right == left) continue;

                        if(words[top].charAt(3) == words[right].charAt(0)){

                            for(int bottom = 0; bottom<words.length; bottom++){
                                if(bottom == top || bottom == left || bottom == right) continue;

                                if( words[bottom].charAt(0) == words[left].charAt(3) ){
                                    if(words[bottom].charAt(3) == words[right].charAt(3)){

                                        List<String> ll = new LinkedList<>();

                                        ll.add(words[top]);
                                        ll.add(words[left]);
                                        ll.add(words[right]);
                                        ll.add(words[bottom]);

                                        ans.add(ll);

                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}

// ae aa eo ao