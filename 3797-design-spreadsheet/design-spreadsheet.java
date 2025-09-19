class Spreadsheet {

    HashMap<String, Integer> mp;

    public Spreadsheet(int rows) {
        mp = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell, value);
    }
    
    public void resetCell(String cell) {
        if(mp.containsKey(cell) ) mp.remove(cell);
    }
    
    public int getValue(String formula) {
        String[]arr = formula.substring(1).split("\\+");

        int val = 0;

        char ch = arr[0].charAt(0);

        if( ch >= 'A' && ch <='Z'){
            val += mp.getOrDefault( arr[0], 0 );
        }
        else val += Integer.parseInt(arr[0]);

        ch = arr[1].charAt(0);
        if( ch >= 'A' && ch <='Z'){
            val += mp.getOrDefault( arr[1], 0 );
        }
        else val += Integer.parseInt(arr[1]);

        return val;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */