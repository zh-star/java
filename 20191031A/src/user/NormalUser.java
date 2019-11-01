package user;

import operation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 20:50
 */
public class NormalUser extends User {
    public NormalUser(String name) {
        this.name = name;
        this.operations = new IOperation[]{
                new ExitOpration(),
                new FindOperation(),
                new BrrowOperation(),
                new ReturnOperation(),
                new DisplayOperation()
        };
    }
    @Override
    public int menu() {
        System.out.println("===hello" + this.name + "欢迎使用===");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出");
        System.out.println("=========================");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;
    }
}
