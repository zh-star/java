package Book;

/**
 * Created with IntelliJ IDEA.
 * Description:一本书
 * User: STAR
 * Date: 2019 -11
 * Time: 20:41
 */
public class Book {
    private String name;//书籍名称
    private String author;//书籍作者
    private int price;//书籍价格
    private String type;//书籍用于什么类型
    private boolean isBorrowed;//是否被借出

    public Book(String name, String author, int price, String type, boolean isBorrowed) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                (isBorrowed ? ", 状态：已被借出" : ", 状态：未被借出") +
                '}';
    }
}
