class Solution {
    public class Frac{
        int num;
        int deno;

        Frac(int n, int d){
            num = n;
            deno = d;
        }
    }
    public String fractionAddition(String expression) {
        char[]arr = expression.toCharArray();
        int i=0;
        int j=0;

        ArrayList<Frac> fractions = new ArrayList();

        while(j<arr.length){
            
            while(j<arr.length && arr[j]!= '/'){
                j++;
            }

            int num = convert(i, j, arr);

            i=j;

            while(j<arr.length && (arr[j]!= '-' && arr[j]!='+') ){
                j++;
            }

            int den = convert(i, j, arr);
            i=j;


            fractions.add( new Frac(num, den));
        }

        int lcm = lcm(fractions);

        int num = 0;

        for(Frac f : fractions){
            num += f.num*(lcm/f.deno);
        }

        boolean minus = false;
        if(num<0){
            minus = true;
            num *= -1;
        }

        int hcf = hcf(Math.min(num, lcm) , Math.max(num, lcm) ) ;

        StringBuilder sb = new StringBuilder();
        if(minus==true) sb.append('-');

        if(hcf>0){
            sb.append(num/hcf);
        }
        else sb.append(num);

        sb.append('/');

        if(hcf>0){
            sb.append(lcm/hcf);
        }
        else sb.append(1);


        return sb.toString();
    }

    public int convert(int i, int j, char[]arr){
        boolean minus = false;
        
        if(arr[i] == '-') minus = true;
        if(arr[i] < '0' || arr[i] > '9') i++;
        if(j>=arr.length || arr[j] < '0' || arr[j] > '9' ) j--;

        int ans = 0;
        int pow = 1;

        // int num = 0;

        while(i<=j){
            ans = ans + ( arr[j]-'0')*pow;
            pow = pow*10;
            j--;
        }

        if(minus==true) ans *= -1;


        return ans;
    }

    public int lcm( ArrayList<Frac> al){

        boolean[]check = new boolean[11];

        int lcm = 1;
        for(Frac f : al){
            if(check[f.deno] == false){
                lcm *= f.deno;
                check[f.deno] = true;
            }
        }

        return lcm;
    }

    public int hcf(int a, int b){
        if(a==0) return 0;
        if(b%a == 0) return a;

        return hcf( b%a , a);

    }
}