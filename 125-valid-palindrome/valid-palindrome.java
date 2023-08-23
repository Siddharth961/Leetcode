import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {      
        
        int i=0;
        int j=s.length()-1;

        while(i<=j){
            char currFirst = s.charAt(i);
        	char currLast = s.charAt(j);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		i++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		j--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		i++;
        		j--;
        	}
        }

        return true;
        
    }
}