package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Naomichi ADACHI
 *
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //ショップの追加
        Shop toyota = new Shop("TOYOTA");
        System.out.println("Register shop : " + toyota.getName());
        shopAddItem(toyota);
        toyota.printShop();

        System.out.println();
        Customer ohka = new Customer("Ohka", 100000000);
        System.out.println("Register user : " + ohka.getName());

        do {
            ohka.printCustomer();
            buyItem(ohka, toyota);
            System.out.println();
            ohka.printCustomer();
            ohka.register();
            ohka.myCartClear();
        } while (!endCheck());

        System.out.println("Bye!");
    }

    /**
     * ショッピングを続けるか
     * @return:yes/no
     */
    static boolean endCheck() {
        boolean end = false;
        System.out.print("Continue shopping?[yes/no] : ");

        String str = sc.next();
        while (!str.equals("yes") && !str.equals("no")) {
            System.out.println("Invalid input. Input again.");
            str = sc.next();
        }

        if (str.equals("no")) {
            end = true;
        }
        return end;
    }

    /**
     * 終了のコマンドが入力されるまでショップのアイテムを購入し続ける
     * @param customer:購入者
     * @param shop:ショップ
     */
    static void buyItem(Customer customer, Shop shop) {
        System.out.println("Please select the items you want to buy. ");
        while (true) {
            System.out.print("Item number(\"q\" end, \"t\" sum) : ");
            String str = sc.next();
            if (str.equals("q")) {
                break;
            } else if (str.equals("t")) {
                customer.printTotalPrice();
            } else {
                int num = -1;
                try {
                    num = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    System.out.println("Illegal input. Input again.");
                    continue;
                }

                if (num >= 0 && num < shop.itemCount()) {

                    customer.buyItem(shop, num);
                } else {
                    System.out.println("Invalid number. Input again.");
                    continue;
                }
            }
        }
    }

    /**
     * 終了のコマンドが入力されるまでショップにアイテムを追加する
     * @param shop:アイテムを追加するショップ
     */
    static void shopAddItem(Shop shop) {
        shop.addItem(new Item("prius", 2350000));
        shop.addItem(new Item("aqua", 2000010));
        shop.addItem(new Item("wish", 2500000));
        shop.addItem(new Item("isis", 2800000));
    }

    /*
     * 手入力でショップの商品を入力するメソッド
     */
    static void shopAddItemInput(Shop shop) {
        while (true) {
            System.out.println("Input item and price. If input end, input \"q\"");
            System.out.print("Input item : ");
            String itemName = sc.next();
            if (itemName.equals("q")) {
                break;
            }

            System.out.print("Input price : ");
            int itemPrice = 0;
            try {
                //TODO どっち
                //itemPrice = sc.nextInt();
                itemPrice = Integer.parseInt(sc.next());
            } catch (InputMismatchException e) {
                System.out.println("Illegal input.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Illegal input.");
                continue;
            }
            shop.addItem(new Item(itemName, itemPrice));
        }
    }
}
