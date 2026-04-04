class EventManager {

    PriorityQueue<int[]> event_queue ;
    HashMap<Integer, Integer> mp;

    public EventManager(int[][] events) {
        event_queue = new PriorityQueue<>( (a,b) -> {

            if(a[1] != b[1]){
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        mp = new HashMap<>();

        for(var event : events){
            event_queue.add(event);
            mp.put(event[0], event[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {

        if(!mp.containsKey(eventId)) return;

        event_queue.add(new int[]{eventId, newPriority});

        mp.put(eventId, newPriority);

    }
    
    public int pollHighest() {

        int ans = -1;
        
        while(event_queue.size() > 0){

            int[]candi_event = event_queue.remove();
            
            if(mp.containsKey(candi_event[0]) && mp.get(candi_event[0]) == candi_event[1]){

                ans = candi_event[0];
                mp.remove(candi_event[0]);
                break;
            }

        }

        return ans;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */

//   we can use priority queue to keep track of which priority is highest
//   and a hasmap< priorityqueue, 

//   i think Treemap< priority, Treeset<eventid> > would work

//   - insert -> o(logn) for inserting new priority + o(logn) for new eventid in that priority
//      in worst case where all event have same priority -> o(1) + o(log n)  ( n is total no of events)
//      or if each event have different priority -> o(logn) + o(1) ( n is total no of events)

//      we also need to keep a hashmap<eventid, priority> to check event priority by eventid directly

//   - update (below 4 steps will be part of delete function)
//            -> use hashmap to get current priority  - O(1)
//            -> use that priority to get Treeset of events in that priority - O(1)
//            -> remove event from that treeset - O(log n)
//            -> if(treeset is empty now) remove priority from treemap - O(logn)
//            -> remove from hashmap - O(1)
//            (below are insert steps , so we will use insert function only)
//            -> if( new priority is not in treemap) insert priority in treemap - O(logn)
//            -> insert event in that treeset - O(log n)
//            -> make entry in hashmap - O(1)

//   - remove highest -> in treemap use ceil to get treeset of highest priority
//                    -> from treeset store smallest event id.. floor value

//                    -> use delete function

// --------------------------BETTER-----------------------------
//   OR WE WILL USE LAZY PROPAGATION
//   - maintain priortiyqueue of events with first comparision on priority and then on eventid
//   - even in update function insert values as if a unique event
//   - MAINTAIN A HASHMAP TO KEEP TRACK OF ACTUAL EVENTID, PRIORITY COMBINATION, update it on updates and inserts
//   - for delete keep remove elements until active event comes up
