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
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要归还的书籍名称：");
        String name = scanner.next();
        int i = 0;
        for(; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName())) {
                break;
            }
        }
        //没找到
        if (i <= bookList.getUsedSize()) {
            System.out.println("没找到此书籍");
            return;
        }

        //找到了
        if
        Book book = bookList.getBooks(i);
        book.setBorrowed(false);
        System.out.println("规划书籍成功！");

    }
}
