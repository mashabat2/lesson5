public class CupboardMain {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    goods.produce();
                } catch (InterruptedException e) {
                    System.out.println("Поток producer прерван" );
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    goods.consume();
                } catch (InterruptedException e) {
                    System.out.println("Поток consumer прерван" );
                }

            }
        });

        long start = System.currentTimeMillis();  //  возвращает время с 1 января 1970 года в миллисекундах
        long end = start + 10000;

        while (System.currentTimeMillis() < end) {
            if (!(producer.isAlive() && consumer.isAlive())) {  //  isAlive() - проверка исполняется ли ещё поток (true/false)
                producer.start();
                consumer.start();
            }
        }
        producer.interrupt();
        consumer.interrupt();
    }
}