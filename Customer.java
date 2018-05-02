package ex01;

/**
 *
 * @author Naomichi ADACHI
 *
 */
public class Customer {
    private String name; //ユーザ名
    private Cart myCart; //カート
    private int money; //所持金

    /**
     * コンストラクタ
     * @param name:ユーザ名
     */
    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
        myCart = new Cart();
    }

    public String getName() {
        return name;
    }

    /**
     * カートクラスのインスタンスを生成する
     */
    public void createCart() {
        myCart = new Cart();
    }

    /**
     * 指定されたショップの指定された番号の商品を購入する
     * @param shop:購入するショップ
     * @param itemNo:購入する商品の番号
     */
    public void buyItem(Shop shop, int itemNo) {
        myCart.addItem(shop.buyItem(itemNo));
        System.out.println(shop.getItemName(itemNo) + " add to cart");
    }

    /**
     * 名前とカートの情報を出力する
     */
    public void printCustomer() {
        System.out.println("///////////////////////////////");
        System.out.println("I'm " + name + ".");
        System.out.println("--In cart--");
        myCart.printCart();
        System.out.println("The total is " + myCart.getTotalPrice() + ".");
        System.out.println("///////////////////////////////");
        System.out.println();
    }

    /**
     * カートの中の商品を購入し、所持金を減らす
     * お金が足りなかったら購入しない
     */
    public void register() {
        System.out.println("********Buying produce********");
        System.out.println("The total is " + myCart.getTotalPrice() + ".");
        if (myCart.getTotalPrice() <= money) {
            System.out.println("Bought!!");
            money -= myCart.getTotalPrice();
        } else {
            System.out.println("The money is insufficient.");
            System.out.println("Could not buy:(");
        }
        System.out.println("I have " + money + " now.");
        System.out.println("******************************");
    }

    /**
     *カートの商品の総額を表示する
     */
    public void printTotalPrice() {
        System.out.println("The sum will be " + myCart.getTotalPrice() + " now.");
    }

    /**
     * カートの中を空にする
     */
    public void myCartClear() {
        myCart.cartClear();
    }

}
