package com.ymd.死锁;

class Account{
    int money;
    public Account(Integer money){
        this.money = money;
    }
}

public class 动态顺序死锁 {
    //银行取钱
    public static void transferMoney(Account from, Account to,Integer money) throws Exception {
        synchronized (from){
            Thread.sleep(1000);
            System.out.println("from："+from.getClass()+" 请求 to:"+to.getClass());
            synchronized (to){
                if(from.money < money){
                    throw new Exception();
                }else {
                    from.money -= money;
                    to.money += money;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Account my = new Account(50);
        Account your = new Account(30);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transferMoney(my,your,5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transferMoney(your,my,5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
    }
}