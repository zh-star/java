package Operation;

import Book.Book;
import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:借阅图书（普通用户）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:26
 */
public class BorrowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要借阅书籍的名称：");
        String name = scanner.next();
        //根据书名获取本书的下表
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (name.equals(bookList.getBooks(i).getName())) {
                break;
            }
        }

        if (i >= bookList.getUsedSize()) {
            System.out.println("没有此书籍");
            return;
        }
        Book book = bookList.getBooks(i);
        if (book.isBorrowed()) {
            //默认是false 表示书在图书馆，true表示被借出
            System.out.println("此书被借出去了！");
        } else {
            book.setBorrowed(true);
            System.out.println("借书成功");
        }
    }
}
