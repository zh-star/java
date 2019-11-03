package Operation;

import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:接口（连接用户和系统的接口）
 * User: STAR
 * Date: 2019 -11
 * Time: 18:24
 */
public interface IOperation {
    void work(BookList bookList);
    Scanner scanner = new Scanner(System.in);
}
