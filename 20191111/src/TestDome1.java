import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 14:55
 */
public class TestDome1 {

    public static void main(String[] args){
        String str = "abcdef";
        System.out.println(str.substring(3));
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            StringBuffer ret = new StringBuffer();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!ret.toString().contains(ch +"")) {
                    ret.append(ch);
                }
            }
            System.out.println(ret.toString());
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                int j = 0;
                for (j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        str = remove(str,j);
                        break;
                    }
                }
            }
            System.out.println(str);
        }
    }
    public static String remove(String str, int index) {
        char[] chars = str.toCharArray();
        StringBuffer ret = new StringBuffer();
        for (int j = 0; j < chars.length; j++) {
            if(j != index) {
                ret.append(chars[j]);
            }
        }
        return ret.toString();
    }
}
