package MultiThreading;

import java.util.concurrent.Semaphore;

class FooBar {
        private int n;
        Semaphore s1 ;
        Semaphore s2;

        public FooBar(int n) {
            this.n = n;
            s1 = new Semaphore(1); // has 1 lock , ready to acquire
            s2 = new Semaphore(0);// has 0 lock, someone has to release , which increase the value by 1
        }

        public void foo(Runnable printFoo) throws InterruptedException {

                for (int i = 0; i < n; i++) {
                s1.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                s2.release();
                }
        }

        public void bar(Runnable printBar) throws InterruptedException {

                for (int i = 0; i < n; i++) {
                    s2.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                s1.release();
                }
        }

    public static void main(String[] args)throws InterruptedException{
        FooBar fooBar = new FooBar(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        });

        fooBar.bar(t2);
        fooBar.foo(t1);
    }


}
