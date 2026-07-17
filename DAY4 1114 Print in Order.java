class Foo {
    
    private Semaphore sem2;
    private Semaphore sem3;

    public Foo() {
        // Initialize semaphores with 0 permits so they block initially
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // Release a permit to allow second() to execute
        sem2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() releases the permit
        sem2.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // Release a permit to allow third() to execute
        sem3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() releases the permit
        sem3.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
