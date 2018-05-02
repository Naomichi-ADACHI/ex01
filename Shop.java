package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Naomichi ADACHI
 *
 */
public class Shop {
    private String name; //ショップ名
    private List<Item> listItem; //商品リスト
    static Scanner sc = new Scanner(System.in);

    public Shop(String name) {
        this.name = name;
        listItem = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getItemName(int itemNo) {
        return listItem.get(itemNo).getName();
    }

    /**
     * アイテムを購入する
     * @param itemNo:買うアイテムの番号
     * @return 買うアイテムのインスタンス
     */
    public Item buyItem(int itemNo) {
        return listItem.get(itemNo);
    }

    /**
     * 商品リストにアイテムを追加する
     * @param item:追加するアイテム
     */
    public void addItem(Item item) {
        listItem.add(item);
    }

    /**
     * 商品リストのアイテム数をカウントする
     * @return 商品リストのアイテム数
     */
    public int itemCount() {
        return listItem.size();
    }

    /**
     * 商品リストを表示する
     */
    public void printShop() {
        System.out.println("--------" + name + "--------");
        for (int i = 0; i < listItem.size(); i++) {
            System.out.print(i + " ");
            listItem.get(i).printItem();
        }
        System.out.println("----------------------");
    }

}
