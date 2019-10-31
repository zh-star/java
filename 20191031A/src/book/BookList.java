package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 17:08
 */
public class BookList {
    private Book[] books = new Book[100];
    private int usedSize;

    public BookList() {
        books[0] = new Book("java编程思想","java1",12,"学习");
        books[1] = new Book("java核心卷一","java2",15,"学习");
        books[2] = new Book("java基本语法","java3",21,"学习");
        this.usedSize = 3;
    }
    public Book getBook(int pos) {
        return this.books[pos];
    }

    public void setBook(int pos,Book book) {
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }


}
