class Solution {
    public int lastRemaining(int n) {
        

        int head = 1;
        int step = 1;
        int rem = n;
        char dir = 'l';

        while(rem>1){
            if(dir=='l' || rem%2!=0) head += step;

             step *= 2;
            rem /= 2;
            if(dir=='l') dir='r';
              else dir='l';
        }

        return head;

        
        
    }

//     public int last(int head,int step,int rem, char dir){

//         if(rem==1) return head;


//         if(dir=='l' || rem%2!=0) head += step;

//         step *= 2;
//         rem /= 2;

//         if(dir=='l') dir='r';
//         else dir='l';

//         return last(head, step, rem, dir );

//    }
}