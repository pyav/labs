/**
 * https://leetcode.com/problems/simple-bank-system/description/
 *
 * Output:
 * ------
 * true
 * true
 * true
 * false
 * false
 */

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    class Account {
        int accountId;
        long balance;
        Account(int _acc, long _bal) {
            this.accountId = _acc;
            this.balance = _bal;
        }
    }

    private Map<Integer, Account> map = null;

    public BankSystem(long[] balance) {
        map = new HashMap<>();
        int i = 1;
        for (long bal : balance) {
            map.put(i, new Account(i, bal));
            i++;
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isAccountExist(account1) || !isAccountExist(account2)) {
            return false;
        }
        if (withdraw(account1, money)) {
            if (deposit(account2, money)) {
                return true;
            } else {
                deposit(account1, money);
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!isAccountExist(account)) {
            return false;
        }
        Account acc = map.get(account);
        acc.balance += money;
        return true;
    }

    private boolean isAccountExist(int accountId) {
        return this.map.containsKey(accountId);
    }

    public boolean withdraw(int account, long money) {
        if (!isAccountExist(account)) {
            return false;
        }
        Account acc = map.get(account);
        if (money > acc.balance) {
            return false;
        }
        acc.balance -= money;
        return true;
    }

    public static void main (String[] args) {
        BankSystem obj = new BankSystem(new long[]{10, 100, 20, 50, 30});
        System.out.println(obj.withdraw(3, 10));
        System.out.println(obj.transfer(5, 1, 20));
        System.out.println(obj.deposit(5, 20));
        System.out.println(obj.transfer(3, 4, 15));
        System.out.println(obj.withdraw(10, 50));
    }
}

