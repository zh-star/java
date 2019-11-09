package Book;

/**
 * Created with IntelliJ IDEA.
 * Description:所有书
 * User: STAR
 * Date: 2019 -11
 * Time: 20:41
 */
public class BookList {
    private Book[] books = new Book[100];
    private int usedSize;

    public BookList() {
        books[0] = new Book("Java编程思想","java",26,"计算机类",false);
        books[1] = new Book("Java基本语法","java",26,"计算机类",false);
        books[2] = new Book("Java核心卷一","java",26,"计算机类",false);
        this.usedSize = 3;
    }
    //给一个下表，就可以得到这本书
    public Book getBooks(int pos) {
        return this.books[pos];
    }
    //给一个下表，一本书，就放进图书馆
    public void setBooks(int pos,Book books) {
        this.books[pos] = books;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
