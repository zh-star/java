package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 16:37
 */
public class TestDemo1 {
    public static void main(String[] args){

    }
    //1108. IP 地址无效化
    //给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
    //
    //所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
    //    示例 1：
    //
    //    输入：address = "1.1.1.1"
    //    输出："1[.]1[.]1[.]1"
    public static String defangIPaddr(String address) {
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < address.length(); i ++) {
            if(address.charAt(i) == '.') {
                str.append("[");
                str.append(".");
                str.append("]");
            } else {
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }

    //1221. 分割平衡字符串
    // 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
    //
    //给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
    //
    //返回可以通过分割得到的平衡字符串的最大数量。
    //示例 1：
    //
    //输入：s = "RLRRLLRLRL"
    //输出：4
    //解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
    //示例 2：
    public static int balancedStringSplit(String s) {
        int count = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                temp ++;
            } else {
                temp --;
            }
            if(temp == 0){
                count ++;
            }

        }
        return count;
    }


}
