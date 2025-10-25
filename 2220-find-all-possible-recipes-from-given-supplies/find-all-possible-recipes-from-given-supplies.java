class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;

        HashSet<String> st = new HashSet<>();
        for(String s : supplies) st.add(s);

        HashMap<String, Integer> mp = new HashMap<>();
        Food[]graph = new Food[n];

        for(int i=0; i<n; i++){
            graph[i] = new Food( recipes[i] );
            mp.put(recipes[i], i);
        }

        for(int i=0; i<graph.length; i++){

            String s = recipes[i];
            Food f = graph[i];

            for(String ing : ingredients.get(i) ){

                if( !st.contains(ing) ){
                    f.inward++;

                    if( mp.containsKey(ing) ){

                        Food requiredFood = graph[ mp.get(ing) ] ;
                        requiredFood.neededBy.add(f);

                    }
                }
            }
        }

    //    for(var k : mp.keySet()) System.out.println(k + " " + mp.get(k).neededBy + " " + mp.get(k).inward);

        List<String> ans = new LinkedList<>();
        Queue<Food> q = new LinkedList<>();

        for( var item : graph ){
            if(item.inward == 0) q.add(item);
        }

        while(q.size() > 0){

            Food item = q.remove();

            ans.add(item.name);

            for( Food child : item.neededBy ){

                child.inward--;
                if(child.inward == 0) q.add(child);
            }
        }



        return ans;
    }

    public class Food{

        String name;
        int inward;
        List<Food> neededBy;

        Food(String n){
            name = n;
            inward = 0;
            neededBy = new LinkedList<>();
        }
    }
}