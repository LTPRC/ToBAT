package com.github.ltprc.jvm;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC instance = null;

    public void isAlive() {
        System.out.println("isAlive() activited");
    }

    @Override
    protected void finalize() throws Throwable {
// super.finalize();
        System.out.println("finalize method executed");
        instance = this;
    }

    public static void main(String[] args) throws InterruptedException {
        instance = new FinalizeEscapeGC();
        instance = null;
        System.gc();
        Thread.sleep(1000);
        instance.isAlive(); // ��û����дfinalize����ʱ���϶��ǻᱨnullpointerException��

        instance = null;
        System.gc();
        Thread.sleep(1000);
        if (instance == null) {
            System.out.println("instance does not exist");
        } else {
            System.out.println("instance exists");
        }
    }
}
