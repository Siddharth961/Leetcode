class Bank {
    long[]bal;

    public Bank(long[] balance) {
        bal=balance;
    }
    
    public boolean transfer(int acc1, int acc2, long mon) {
        if(acc1>bal.length || acc2>bal.length) return false;
        if(bal[acc1-1]<mon) return false;
        bal[acc1-1] -= mon;
        bal[acc2-1] += mon;
        return true;
    }
    
    public boolean deposit(int acc, long mon) {
        if(acc>bal.length) return false;
        bal[acc-1] += mon;
        return true;
    }
    
    public boolean withdraw(int acc, long mon) {
        if(acc>bal.length) return false;

        if(bal[acc-1]<mon) return false;
        bal[acc-1] -= mon;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(acc1,acc2,mon);
 * boolean param_2 = obj.deposit(acc,mon);
 * boolean param_3 = obj.withdraw(acc,mon);
 */