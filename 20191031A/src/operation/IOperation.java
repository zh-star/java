package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 17:26
 */
public interface IOperation {
    void work(BookList bookList);
    Scanner scanner = new Scanner(System.in);
}
