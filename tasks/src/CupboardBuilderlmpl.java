public class CupboardBuilderlmpl implements CupboardBuilder {

    private Cupboard cupboard;

    CupboardBuilderlmpl() {
        cupboard = new Cupboard();
    }

    @Override
    public Cupboard build() {
        return cupboard;
    }

    @Override
    public CupboardBuilder name(String name) {
        cupboard.setName(name);
        return this;
    }

    @Override
    public CupboardBuilder price(int price) {
        cupboard.setPrice(price);
        return this;
    }

    @Override
    public CupboardBuilder color(String color) {
        cupboard.setColor(color);
        return this;
    }

    @Override
    public CupboardBuilder size(String size) {
        cupboard.setSize(size);
        return this;
    }
}