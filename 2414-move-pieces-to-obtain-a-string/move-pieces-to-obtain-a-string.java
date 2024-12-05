class Solution {
    public boolean canChange(String start, String target) {
        char[]src = start.toCharArray();
        char[]tar = target.toCharArray();

        int i=0;
        int j=0;

        while(i<src.length && j<tar.length){
            if( src[i] == tar[j]){
                i++;
                j++;
            }
            else{

                if(tar[j] == 'L'){
                    if(src[i] == 'R') return false;
                    else{
                        int k = i;
                        while(k<src.length && src[k] != 'L'){
                            if( src[k] == 'R') return false;
                            k++;
                        }

                        if(k == src.length) return false;
                        src[k] = '_';
                    }
                }

                else if( tar[j] == 'R') return false;

                else if( src[i] == 'L') return false;

                else if(src[i] == 'R'){
                    if(tar[j] == 'L') return false;

                    int k = i;
                    while(k<src.length && src[k] != '_'){
                        if(src[k] == 'L') return false;
                        k++;
                    }

                    if(k==src.length) return false;
                    src[k] = 'R';
                }

                i++;
                j++;
            }
        }

        return true;
    }
}