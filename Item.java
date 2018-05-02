package ex01;

/**
 *
 * @author Naomichi ADACHI
 *
 */
public class Item {
    private String name; //アイテム名
    private int price; //価格

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**
     * アイテム名と価格を表示する
     */
    public void printItem() {
        System.out.println(name + " : " + price);
    }
}
