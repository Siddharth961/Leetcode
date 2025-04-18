class Solution {
    public String countAndSay(int n) {
        // return helper(n).toString();

        StringBuilder prev = new StringBuilder();
        prev.append('1');
        StringBuilder curr = new StringBuilder();

        for (int i = 2; i <= n; i++) {

            int count = 1;
            int j = 1;
            for (; j < prev.length(); j++) {

                if (prev.charAt(j - 1) != prev.charAt(j)) {

                    curr.append(count);
                    curr.append(prev.charAt(j - 1));
                    count = 1;
                }

                else
                    count++;
            }

            curr.append(count);
            curr.append(prev.charAt(j - 1));

            prev = curr;
            curr = new StringBuilder();

        }

        return prev.toString();
    }

    public StringBuilder helper(int n) {

        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            return sb;
        }

        StringBuilder s = helper(n - 1);

        StringBuilder sb = new StringBuilder();

        int count = 1;
        int i = 1;
        for (; i < s.length(); i++) {

            if (s.charAt(i - 1) != s.charAt(i)) {

                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }

            else
                count++;
        }

        sb.append(count);
        sb.append(s.charAt(i - 1));

        return sb;

    }
}
