class Solution {
    public boolean canReach(int[] arr, int start) {
        
        boolean[] visited = new boolean[arr.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(q.size() > 0){

            int node = q.remove();

            if(arr[node] == 0)  return true;

            if(node-arr[node] >= 0 && visited[node-arr[node]] == false) {
                visited[ node-arr[node] ] = true;

                q.add(node-arr[node] );
            }         

            if(node+arr[node] < arr.length && visited[node+arr[node]] == false){

                visited[ node+arr[node] ] = true;

                q.add(node+arr[node] );
            }         
        }

        return false;
    }
}