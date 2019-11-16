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


    //657. 机器人能否返回原点
    // 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
    //
    //移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
    //
    //注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
    //示例 1:
    //
    //输入: "UD"
    //输出: true
    //解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
    //
    public boolean judgeCircle(String moves) {
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; i < moves.length(); i ++) {
            if(moves.charAt(i) == 'R') {
                temp1 ++;
            } else if(moves.charAt(i) == 'L') {
                temp1 --;
            } else if(moves.charAt(i) == 'U') {
                temp2 ++;
            } else if(moves.charAt(i) == 'D'){
                temp2 --;
            }
        }
        if( temp1 == temp2 && temp1 == 0) {
            return true;
        }
        return false;
    }
}