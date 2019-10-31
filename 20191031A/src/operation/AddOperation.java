package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:新增图书
 * User: STAR
 * Date: 2019 -10
 * Time: 17:27
 */
public class AddOperation implements IOperation{


    @Override
    public void work(BookList bookList) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字");
        String name = scanner.next();
        System.out.println("请输入图书的作者");
        String aulther = scanner.next();
        System.out.println("请输入图书的价格");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type = scanner.next();

        //根据你所输入的书籍信息 构成一本书的对象
        Book book = new Book(name,aulther,price,type);

        //插入到bookList当中，尾插法
        int size = bookList.getUsedSize();

        bookList.setBook(size,book);

        bookList.setUsedSize(size + 1);

        System.out.println("插入图书成功");
    }
}
