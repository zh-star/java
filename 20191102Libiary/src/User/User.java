package User;

import Book.BookList;
import Operation.IOperation;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:所有用户共同有的
 * User: STAR
 * Date: 2019 -11
 * Time: 18:07
 */
public abstract class User  {
    private String name;
    protected IOperation[] operations;

    Scanner scanner = new Scanner(System.in);
    //public abstract int menu();

    //根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
