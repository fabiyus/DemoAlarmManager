package sg.edu.rp.c346.myapplication;

/**
 * Created by 16023068 on 14/11/2017.
 */

public class test {

    String name;
    int price;

    public test(){

    }

    public test(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
