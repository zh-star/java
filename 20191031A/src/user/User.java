package user;

import book.BookList;
import operation.IOperation;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 20:53
 */
public abstract class User {
    public String name;
    protected IOperation[] operations;

    Scanner scanner = new Scanner(System.in);
    public abstract int menu();


    //根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
