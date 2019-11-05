package com.ymd.单线程实现单词抄写;

public class Punishment {
    private int leftCopyCount;//剩余抄写次数
    private String worldToCopy;//需要抄写的单词

    public int getLeftCopyCount() {
        return leftCopyCount;
    }

    public void setLeftCopyCount(int leftCopyCount) {
        this.leftCopyCount = leftCopyCount;
    }

    public String getWorldToCopy() {
        return worldToCopy;
    }

    public void setWorldToCopy(String worldToCopy) {
        this.worldToCopy = worldToCopy;
    }

    public Punishment(int leftCopyCount, String worldToCopy) {
        this.leftCopyCount = leftCopyCount;
        this.worldToCopy = worldToCopy;
    }
}
