public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        // Create first thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    writer("first");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create second thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Create third thread
                    Thread t3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                System.out.println("Thread 3");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t3.start();
                    t3.join(); // приостановить выполнение текущего потока до тех пор, пока другой поток не закончит свое выполнение
                    Thread.sleep(900);
                    writer("second");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
            Жизненный цикл потока t2
         */
        System.out.println(t2.getState()); //NEW

        t1.start();
        t2.start();
        System.out.println(t2.getState()); //RUNNABLE

        Thread.sleep(1500);
        System.out.println(t2.getState()); // WAITING

        Thread.sleep(1000);
        System.out.println(t2.getState()); // TIMED-WAITING

        Thread.sleep(1000);
        System.out.println(t2.getState());  // BLOCKED

        Thread.sleep(15000);
        System.out.println(t2.getState());  // TERMINATED
    }

    public static synchronized void writer(String num) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Thread number: "+ num);
    }


}