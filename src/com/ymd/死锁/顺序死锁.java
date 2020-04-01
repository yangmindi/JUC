package com.ymd.死锁;

public class 顺序死锁 {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void leftRight() throws InterruptedException {
        synchronized (object1){
            Thread.sleep(100);
            synchronized (object2){
                System.out.println("leftRight");
            }
        }
    }

    public static void rightLeft() throws InterruptedException {
        synchronized (object2){
            Thread.sleep(90);
            synchronized (object1){
                System.out.println("rightleft");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    leftRight();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rightLeft();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
