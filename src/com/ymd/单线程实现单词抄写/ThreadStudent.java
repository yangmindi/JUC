package com.ymd.单线程实现单词抄写;

public class ThreadStudent extends Thread{
    private String name;
    private Punishment punishment;

    public ThreadStudent(String name, Punishment punishment){
        //2.调用Thread的构造方法，设置ThreadName
        super(name);
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWorld(){
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while(true){
            if(punishment.getLeftCopyCount() > 0){
                int leftCopyCount = punishment.getLeftCopyCount();
                System.out.println(threadName + "线程-" + name + "抄写" + punishment.getWorldToCopy() + "。还要抄写" + --leftCopyCount + "次");
                punishment.setLeftCopyCount(leftCopyCount);
                count++;
            }else {
                break;
            }
        }
        System.out.println(threadName + "线程-" + name + "一共抄写了" + count + "次！");
    }
    //3.重写run方法，调用copyWorld完成任务
    public void run(){
        copyWorld();
    }
}

