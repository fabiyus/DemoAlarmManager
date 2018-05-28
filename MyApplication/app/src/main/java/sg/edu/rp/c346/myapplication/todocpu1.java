package sg.edu.rp.c346.myapplication;

public class todocpu1 {
    private String title;
    private String date;
    private int price;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public todocpu1(String title, String date, int price) {
        this.title = title;
        this.date = date;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    //POINT A Missing Setter and Getter codes


    public String getDateString() {
        return date;
    }
    public int getPriceInt() { return price;}
    @Override
    public String toString() {
        return "ToDoItem{" +
                "title='" + title + '\'' +
                ", date=" + getDateString() +
                ", price=" + getPriceInt() +
                '}';
    }
}
