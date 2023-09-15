package com.stankevich.threads;

public class Foo {
    private boolean firstPrinted = false;
    private boolean secondPrinted = false;

    public synchronized void first() {
        try {
            // для наглядности что потоки будут ждать пока не выполнится метод first
            wait(3000L);
        } catch (InterruptedException e) {
            return;
        }
        System.out.print("first");
        firstPrinted = true;
        notifyAll();
    }

    public synchronized void second() {
        while (!firstPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.print("second");
        secondPrinted = true;
        notifyAll();
    }

    public synchronized void third() {
        while (!secondPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.print("third");
    }

}
