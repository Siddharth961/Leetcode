/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];

        for(int[]a : arr) Arrays.fill(a,-1);
       

        ListNode ptr = head;

        int rs = 0;
        int cs = 0;
        int re = m-1;
        int ce = n-1;


        while(ptr!=null){
            for(int i=cs; i<=ce; i++){
                if(ptr==null) break;
                arr[rs][i]=ptr.val;
                ptr = ptr.next;
            }

            for(int i=rs+1; i<=re; i++){
                if(ptr==null) break;
                arr[i][ce] = ptr.val;
                ptr = ptr.next;
            }

            for(int i=ce-1; i>=cs; i--){
                if(ptr==null) break;
                arr[re][i] = ptr.val;
                ptr = ptr.next;
            }

            for(int i=re-1; i>rs; i--){
                if(ptr==null) break;
                arr[i][cs] = ptr.val;
                ptr = ptr.next;
            }

            rs++;
            cs++;
            ce--;
            re--;
        }

        return arr;
    }
}