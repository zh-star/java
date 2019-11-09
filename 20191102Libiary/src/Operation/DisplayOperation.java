package Operation;

import Book.BookList;


/**
 * Created with IntelliJ IDEA.
 * Description:显示所有图书（管理员，普通用户）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:22
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        for(int i = 0; i < bookList.getUsedSize(); i ++) {
            System.out.println(bookList.getBooks(i));
        }
        System.out.println("所有图书显示完成！");
    }
}
