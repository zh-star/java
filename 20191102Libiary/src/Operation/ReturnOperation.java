package Operation;

import Book.Book;
import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:归还书籍（普通用户）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:23
 */
public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要归还的书籍名称：");
        String name = scanner.next();
        Book book = null;
        int i = 0;
        for(; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName())) {
                book = bookList.getBooks(i);
            }
        }
        //没找到
        if (i > bookList.getUsedSize()) {
            System.out.println("没找到此书籍");
            return;
        }
        //找到了

        if (book != null && !book.isBorrowed()) {
            System.out.println("此书没有被您借阅！");
            return;
        }
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
        }
        System.out.println("归还书籍成功！");
    }
}
