package com.ymd.单线程实现单词抄写;

public class StudentClient {
    public static void main(String[] args) {
        Punishment punishment = new Punishment(100, "internationalization");
//        Student student =  new Student("小明",punishment);
//        ThreadStudent student = new ThreadStudent("小明",punishment);
//        student.start();
        ThreadStudent xiaoming = new ThreadStudent("小明",punishment);
        xiaoming.start();

        ThreadStudent xiaozhang = new ThreadStudent("小张",punishment);
        xiaozhang.start();

        ThreadStudent xiaozhao = new ThreadStudent("小赵",punishment);
        xiaozhao.start();
    }
}
