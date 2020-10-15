public interface CupboardBuilder {
    Cupboard build();
    CupboardBuilder name(String name);
    CupboardBuilder price(int price);
    CupboardBuilder color(String color);
    CupboardBuilder size(String color);
}