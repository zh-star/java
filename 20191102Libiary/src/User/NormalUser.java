package User;

import Operation.*;
/**
 * Created with IntelliJ IDEA.
 * Description:普通用户
 * User: STAR
 * Date: 2019 -11
 * Time: 18:15
 */
public class NormalUser extends User{

    //自己的构造方法
    public NormalUser(String name) {
        this. name = name;
        this.operations = new IOperation[] {
                new ExitOperation(),
                new DisplayOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };

    }
    @Override
    public int menu() {
        System.out.println("===hello" + this.name + "欢迎使用===");
        System.out.println("1.展示所有图书");
        System.out.println("2.查找书籍");
        System.out.println("3.借阅书籍");
        System.out.println("4.归还书籍");
        System.out.println("0.退出系统");
        System.out.println("==================================");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;
    }
}
