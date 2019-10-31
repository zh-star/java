package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:02
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        //1.输入删除图书的名字
        System.out.println("请输入要删除的书籍名称");
        String name = scanner.next();
        //2.根据书籍的名称查找书籍是否存在 index
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        //3.删除的逻辑  i = i+1 对象
        if (i >= bookList.getUsedSize()) {
            System.out.println("没要找到您要删除的书籍");
        }
        //Book book = bookList.getBook(i);
        for (int j = i; j < bookList.getUsedSize(); j++) {
            Book book = bookList.getBook(j + 1);
            bookList.setBook(j,book);
        }
        //     1.拿到i+1下表的对象
        //      2.把i+1下表的对象赋值给i
        bookList.setUsedSize(bookList.getUsedSize() - 1);
        System.out.println("删除成功");
    }
}
