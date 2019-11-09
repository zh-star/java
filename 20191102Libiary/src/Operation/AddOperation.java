package Operation;

import Book.Book;
import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:新增书籍（管理员）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:18
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入书籍的名称：");
        String name = scanner.next();
        System.out.println("请输入书籍的作者：");
        String author = scanner.next();
        System.out.println("请输入书籍的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入书籍的类型：");
        String type = scanner.next();

        //将所输入的书 构成一本书
        Book book = new Book(name,author,price,type,false);

        //插入到BookList中
        int size = bookList.getUsedSize();// 获取到usedSize

        bookList.setBooks(size,book);//将这本书放到BookList

        bookList.setUsedSize(size + 1);//usedSize + 1

        System.out.println("新增图书完成！");

    }
}
