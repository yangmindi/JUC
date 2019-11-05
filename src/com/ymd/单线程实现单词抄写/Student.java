package com.ymd.单线程实现单词抄写;

public class Student {
    private String name;
    private Punishment punishment;

    public Student(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord(){
        int count = 0;//记录抄写的总次数
        //本线程的名称
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
}
