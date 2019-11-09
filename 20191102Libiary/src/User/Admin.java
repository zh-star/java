package User;

import Operation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:管理员
 * User: STAR
 * Date: 2019 -11
 * Time: 18:07
 */
public class Admin extends User{
    public Admin(String name) {
        this.name = name;
        this.operations = new IOperation[] {
                new ExitOperation(),
                new DisplayOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
        };
    }
    @Override
    public int menu() {
        System.out.println("===hello" + this.name + "欢迎使用===");
        System.out.println("1.展示所有图书");
        System.out.println("2.查找书籍");
        System.out.println("3.新增书籍");
        System.out.println("4.删除书籍");
        System.out.println("0.退出系统");
        System.out.println("==================================");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;
    }
}
