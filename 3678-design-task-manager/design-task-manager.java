class TaskManager {

    PriorityQueue< int[] >pq ;
    HashMap<Integer, List<Integer>> mp;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>( ( a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0];

            return b[1] - a[1];
        });

        mp = new HashMap<>();

        for(var al : tasks){
            pq.add( new int[]{al.get(1), al.get(2)});
            mp.put(al.get(1), al);
        }

        // System.out.println(pq);
    }
    
    public void add(int userId, int taskId, int priority) {
        List<Integer> al = new LinkedList<>();

        al.add(userId);
        al.add(taskId);
        al.add(priority);

        pq.add( new int[]{al.get(1), al.get(2)});
        mp.put(al.get(1), al);

        // System.out.println(pq);

    }
    
    public void edit(int taskId, int newPriority) {

        List<Integer> al = mp.get(taskId);
        
        al.set(2, newPriority);
        pq.add( new int[]{al.get(1), al.get(2)});


        // System.out.println(pq);

    }
    
    public void rmv(int taskId) {
        mp.remove(taskId);

        // System.out.println("pqemv "+ pq);

    }
    
    public int execTop() {
        

        while(pq.size() > 0){

            int[]arr = pq.remove();
            int task = arr[0];

            if( mp.containsKey(task) ){

                List<Integer> al = mp.get(task);

                if(arr[1] != al.get(2) ) continue;

                

                mp.remove( task );
                // System.out.println(pq);

                return al.get(0);
            }
            
        }

        // System.out.println(pq);

         return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */

 //  for exec top -> need priority queue with first factor priority second factor taskid

//  maybe tree map better
    
//  key -> priorityid+" "+taskid 
//  easy add - logn
//  edit - get list O(1) + remove logn + add logn
//  rmv - logn
//  exectop - access( priotiy, task) + remove - logn


//  hashmap + pq

//  add - logn + mp.put(tak id, list)
//  edit - mp look up O(1) edit list + O(n) remove from pq + logn add in pq
//  rmv - O(n) removal from pq
//  exectop - O(1) look up + logn removal