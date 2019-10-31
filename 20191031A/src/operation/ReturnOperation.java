package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:54
 */
public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要归还的书籍");
        String name = scanner.next();
        Book book = null;
        int i = 0;
        for(; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                book = bookList.getBook(i);
            }
        }
        if(i > bookList.getUsedSize()) {
            System.out.println("没有此书籍");
            return;
        }
        if(book != null && !book.isBorrowed()) {
            System.out.println("此书没有被您借阅");
            return;
        }
        if(book != null && book.isBorrowed()) {
            book.setBorrowed(false);
        }
        System.out.println("归还完成");
    }
}
