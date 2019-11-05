package com.ymd.单线程实现单词抄写;

public class StudentClient {
    public static void main(String[] args) {
        Punishment punishment = new Punishment(100, "internationalization");
        Student student =  new Student("小明",punishment);
        student.copyWord();
    }
}
