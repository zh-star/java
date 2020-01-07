package liu;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 10:28
 */
public class TestDemo {

    private static void listDirectory(File root,int level) {
        File[] files = root.listFiles();
        if(files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            for (int i = 0; i < level*4; i++) {
                System.out.print(" ");
            }
            System.out.println(file.getName());
            if(file.isDirectory()) {
                listDirectory(file,level+1);
            }
        }
    }
    public static void main(String[] args){
        File root = new File("C:\\Users\\STAR\\Desktop\\JAVA课件");
        System.out.print(root.getAbsoluteFile());
        listDirectory(root,1);
    }
}
