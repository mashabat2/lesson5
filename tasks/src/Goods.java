import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Goods {
    Random random = new Random();

    Vector<Cupboard> products = new Vector<>();

    List<String> colors = Arrays.asList("черный", "синий", "зеленый", "красный");
    List<String> sizes = Arrays.asList("big", "medium", "small");
    List<String> names = Arrays.asList("Кровать", "Шкаф", "Стол деревянный", "Стеллаж");

    public void produce() throws InterruptedException{
        while (true) {
            synchronized (this){
                while (products.size() == 5) {
                    System.out.println("Корзина переполнена");
                    wait();
                }

                CupboardBuilder builder = new CupboardBuilderlmpl();
                Cupboard newProduct = builder
                        .name(names.get(random.nextInt(names.size())))
                        .price(random.nextInt(800) + 200)
                        .color(colors.get(random.nextInt(colors.size())))
                        .size(sizes.get(random.nextInt(sizes.size())))
                        .build();

                products.add(newProduct);


                System.out.println("Произведен товар: " + newProduct);
                System.out.println("Все товары: " + products);

                notify();

                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (this) {

                while (products.size() == 0){
                    System.out.println("Корзина пуста");
                    wait();
                }

                Cupboard buy = products.get(random.nextInt(products.size()));
                products.remove(buy);

                System.out.println("Клиент купил: " + buy);

                notify();

                int sleep = random.nextInt(800) + 200;

                Thread.sleep(sleep);
            }
        }
    }
}