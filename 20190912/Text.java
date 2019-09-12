import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Text {
    //3.1. 编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main(String[] args) {
        int i = 1;
        int num = 0;
        for (i = 1; i <= 100; i ++) {
            //9,19,29,39...89;99
            if (i % 10 == 9) {
                num ++;
            //90,91,92..98
            }else if (i / 10 == 9) {
                num ++;
            }
        }
        System.out.println("num = " + num);
    }
}