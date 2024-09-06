class Solution {
    public int findKthLargest(int[] nums, int k) {
        Heap pq = new Heap(k);
        for(int i : nums){
            if( pq.size() < k) pq.add(i);
            else{
                if(pq.peek() < i){
                    pq.remove();
                    pq.add(i);
                }
            }
        }

        return pq.peek();
    }

    public static class Heap{
        int[]arr;
        int head = 0;
        int tail = -1;

        Heap(int size){
            arr = new int[size];
        }

        public void add(int val){
            if(head == 0 && tail == -1){
                arr[0] = val;
                head = 0;
                tail = 0;
                return ;
            }

            tail++;
            arr[tail] = val;

            int ptr = tail;
            while(ptr != 0){
                if( arr[ (ptr-1)/2 ] > arr[ptr]){
                    arr[ptr] = arr[ (ptr-1)/2 ] ;
                    arr[ (ptr-1)/2 ]  = val;
                    

                    ptr = (ptr-1)/2;
                }
                else break; 
            }


        }

        public int remove(){
            int val = arr[head];
            arr[head] = arr[tail];
            tail--;

            int ptr = head;
            int child = 2*(ptr+1) - 1;

            int smaller = 0;

            while(ptr<=tail && child<=tail){
                if(child+1 > tail){
                    smaller = child;
                }
                else{
                    smaller = arr[child] <= arr[child+1] ? child : child+1;
                }

                if( arr[ptr] <= arr[smaller] ) break;

                int temp = arr[smaller];
                arr[smaller] = arr[ptr];
                arr[ptr] = temp;

                ptr = smaller;
                child = 2*(ptr+1) - 1;
            }

            return val;
        }

        public int peek(){
            return arr[head];
        }

        public int size(){
            return tail - head  + 1;
        }

    }
}