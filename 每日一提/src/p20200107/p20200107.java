package p20200107;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 17:53
 */
public class p20200107 {
    // 1.学分绩点  qian一个循环对
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 总的课程数
        int[] creditVallue = new int[n]; //学分数组
        Map<Integer,Integer> map = new HashMap<>();
        int sum1 = 0;// 课程学分之和
        for(int i = 0; i < n; i++) {
            creditVallue[i] = in.nextInt();
            sum1 += creditVallue[i];
        }
        int[] scoreVallue = new int[n]; //课程的实际分数
        for(int i = 0; i < n; i++) {
            scoreVallue[i] = in.nextInt();
        }
//        for (int i = 0; i < n; i++) {
//            map.put(scoreVallue[i],creditVallue[i]);
//        }
        //System.out.println(Arrays.toString(creditVallue));
        //System.out.println(Arrays.toString(scoreVallue));
        double sum = 0;
        for(int i = 0; i < n; i++) {
            double CreditGradePoint = 0.0;
            if(scoreVallue[i] >= 90 && scoreVallue[i] <= 100) {
                CreditGradePoint = creditVallue[i]*4.0;
            } else if(scoreVallue[i] >= 85 && scoreVallue[i] <= 89) {
                CreditGradePoint = creditVallue[i]*3.7;
            } else if(scoreVallue[i] >= 82 && scoreVallue[i] <= 84) {
                CreditGradePoint = creditVallue[i]*3.3;
            } else if(scoreVallue[i] >= 78 && scoreVallue[i] <= 81) {
                CreditGradePoint = creditVallue[i]*3.0;
            } else if(scoreVallue[i] >= 75 && scoreVallue[i] <= 77) {
                CreditGradePoint = creditVallue[i]*2.7;
            } else if(scoreVallue[i] >= 72 && scoreVallue[i] <= 74) {
                CreditGradePoint = creditVallue[i]*2.3;
            } else if(scoreVallue[i] >= 68 && scoreVallue[i] <= 71) {
                CreditGradePoint = creditVallue[i]*2.0;
            } else if(scoreVallue[i] >= 64 && scoreVallue[i] <= 67) {
                CreditGradePoint = creditVallue[i]*1.5;
            } else if(scoreVallue[i] >= 60 && scoreVallue[i] <= 63) {
                CreditGradePoint = creditVallue[i]*1.0;
            } else if(scoreVallue[i] < 60) {
                CreditGradePoint = 0.0;
            }
            sum += CreditGradePoint;
        }

        System.out.println((double) Math.round((sum/sum1)*100) / 100);



        for(int i = 0; i < n; i++) {
            double CreditGradePoint = 0.0;
            if(scoreVallue[i] >= 90 && scoreVallue[i] <= 100) {
                CreditGradePoint = map.get(scoreVallue[i])*4.0;
            } else if(scoreVallue[i] >= 85 && scoreVallue[i] <= 89) {
                CreditGradePoint = map.get(scoreVallue[i])*3.7;
            } else if(scoreVallue[i] >= 82 && scoreVallue[i] <= 84) {
                CreditGradePoint = map.get(scoreVallue[i])*3.3;
            } else if(scoreVallue[i] >= 78 && scoreVallue[i] <= 81) {
                CreditGradePoint = map.get(scoreVallue[i])*3.0;
            } else if(scoreVallue[i] >= 75 && scoreVallue[i] <= 77) {
                CreditGradePoint = map.get(scoreVallue[i])*2.7;
            } else if(scoreVallue[i] >= 72 && scoreVallue[i] <= 74) {
                CreditGradePoint = map.get(scoreVallue[i])*2.3;
            } else if(scoreVallue[i] >= 68 && scoreVallue[i] <= 71) {
                CreditGradePoint = map.get(scoreVallue[i])*2.0;
            } else if(scoreVallue[i] >= 64 && scoreVallue[i] <= 67) {
                CreditGradePoint = map.get(scoreVallue[i])*1.5;
            } else if(scoreVallue[i] >= 60 && scoreVallue[i] <= 63) {
                CreditGradePoint = map.get(scoreVallue[i])*1.0;
            } else if(scoreVallue[i] < 60) {
                CreditGradePoint = 0.0;
            }
            sum += CreditGradePoint;
        }
    }


    // 2. 人民币转换
    // 151121.15         150021.15
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String money = in.nextLine();
        System.out.println("人民币");
        Map<Integer,Character> map = new HashMap<>();
        map = fullMap(map);
        char[] value = new char[] {'零','壹','贰','叁','肆','伍','陆','柒','玐',
                        '玖','拾','佰','仟','万','亿','元','角','分','整'};
        for (int i = 0; i < money.length(); i++) {

            if(money.charAt(i) != 0) {
                System.out.print(value[money.charAt(i)]);
            } else {

            }
        }

    }

    private static Map<Integer, Character> fullMap(Map<Integer, Character> map) {
        map.put(0,'零');
        map.put(1,'壹');
        map.put(2,'贰');
        map.put(3,'叁');
        map.put(4,'肆');
        map.put(5,'伍');
        map.put(6,'陆');
        map.put(7,'柒');
        map.put(8,'玐');
        map.put(9,'玖');
        map.put(10,'拾');
        map.put(11,'千');
        map.put(12,'万');
        map.put(13,'亿');
        map.put(14,'元');
        map.put(15,'角');
        map.put(16,'分');
        map.put(18,'整');

        return null;
    }
}
