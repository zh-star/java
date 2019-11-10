import Book.BookList;
import User.Admin;
import User.NormalUser;
import User.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 16:40
 */
public class Main {

    public static User login() {
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入您的身份（1：管理员；0：用户）:");
        int choice = scanner.nextInt();
        if(choice == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args){
        BookList bookList = new BookList();
        User user = login();

        while(true) {
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }
}
