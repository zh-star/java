package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 18:08
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
