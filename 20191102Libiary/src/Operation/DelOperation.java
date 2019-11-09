package Operation;

import Book.Book;
import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:删除图书（管理员）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:21
 */
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要删除的书籍名称：");
        String name = scanner.next();
        int i = 0;
        //遍历查找要删除的书籍
        for(; i < bookList.getUsedSize(); i ++) {
            if(name.equals(bookList.getBooks(i).getName())) {
                break;
            }
        }
        //没找到要删除的书籍
        if(i >= bookList.getUsedSize()) {
            System.out.println("没有找到此书籍");
            return;
        }

        // 删除书籍（从要删除书籍的下表位置的后一位开始前移）
        for (int j = i; j < bookList.getUsedSize(); j++) {
            Book book = bookList.getBooks(j + 1);
            bookList.setBooks(j,book);
            //bookList.setBooks(j,bookList.getBooks(j + 1));
        }
        //让存放数量的有效值减1
        bookList.setUsedSize(bookList.getUsedSize()-1);
        System.out.println("删除成功");
    }
}
