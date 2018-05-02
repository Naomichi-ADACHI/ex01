package ex01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Naomichi ADACHI
 *
 */
public class Cart {
    private List<Item> listItem = new ArrayList<Item>();

    /**
     * カートの中身を表示する
     */
    public void printCart() {
        if (listItem.isEmpty()) { //カートが空の場合
            System.out.println("Nothing");
        } else {
            for (Item item : listItem) {
                System.out.println(item.getName() + " : " + item.getPrice());
            }
        }
    }

    /**
     *カートに購入するアイテムを追加する
     * @param item 追加するアイテム
     */
    public void addItem(Item item) {
        listItem.add(item);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Item item : listItem) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void cartClear() {
        listItem.clear();
    }
}
