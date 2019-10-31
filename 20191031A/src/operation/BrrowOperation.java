package operation;


import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 18:11
 */
public class BrrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        //输入需要借阅书籍的名称
        System.out.println("请输入你要借的书籍名称");
        String name = scanner.next();
        //根据书籍名称查找书籍是否存在
        int i = 0;
        for (i = 0; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBook(i).getName())) {
                //System.out.println("书籍借阅成功");
                break;
            }
        }

        //拿到书籍的对象，将书籍对象的isBorrowed = true
        if(i >= bookList.getUsedSize()) {
            System.out.println("没有找到这本书");
            return;
        }
        //i为此时借阅的书籍的标

         Book book = bookList.getBook(i);
        if (book.isBorrowed()) {
            System.out.println("此书已经被借出去了");
        } else {
            book.setBorrowed(true);
            System.out.println("此书借阅成功");
        }

    }
}
