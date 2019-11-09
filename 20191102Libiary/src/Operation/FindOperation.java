package Operation;

import Book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:查找书籍（管理员，普通用户）
 * User: STAR
 * Date: 2019 -11
 * Time: 19:22
 */
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入您要查找的书籍：");
        String name = scanner.next();
        int i = 0;
        for(; i < bookList.getUsedSize(); i++) {
            if(name.equals(bookList.getBooks(i).getName())) {
                break;
            }
        }
        //没找到
        if(i >= bookList.getUsedSize()) {
            System.out.println("没有找到您要查找的书籍");
            return;
        }
        //找到
        System.out.println(bookList.getBooks(i));
        System.out.println("查找图书完毕！");
    }
}
