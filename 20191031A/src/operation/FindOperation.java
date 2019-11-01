package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:34
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        //1.输入查找图书的名字
        System.out.println("请输入要查找的书籍名称");
        String name = scanner.next();
        //2.根据书籍的名称查找书籍是否存在 index
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        if(i >= bookList.getUsedSize()) {
            System.out.println("没有找到此书籍");
        } else {
            System.out.println("查找书籍完毕");
        }

    }
}
