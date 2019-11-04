package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 20:34
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("程序退出");
        System.exit(0);
    }
}
