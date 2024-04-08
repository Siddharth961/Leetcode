class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int remain = students.length;

        int top = 0;

        
        int temp=0;

        while(remain>0 ){
            temp = remain;

            for(int i=0; i<students.length; i++){
                if(students[i]==-1) continue;
                if(students[i]==sandwiches[top]){
                    remain--;
                    top++;
                    students[i] = -1;
                }

                
            }

            if(temp==remain) break;
        }

        return remain;
    }
}