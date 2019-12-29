package p20191228;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 20:11
 */
public class p20191228 {

    // 1. 统计同成绩学生人数
    //读入N名学生的成绩，将获得某一给定分数的学生人数输出。
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt(); // 读取N
            if(n == 0) {
                return;
            }
            Map<Integer,Integer> map = new HashMap<>();// 读取成绩
            for (int i = n; i > 0; i--) {
                int temp = scanner.nextInt();
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            int score = scanner.nextInt();
            for (Map.Entry<Integer,Integer> m : map.entrySet()) {
                if(m.getKey() == score) {
                    System.out.println(m.getValue());
                }
            }
        }
    }

    // 2. 洗牌
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 数据组数 需要洗几把牌
        for(int i = 0; i < T; i++) {
            // n 总共有2n张牌   k 这副牌要洗几次
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            // 两组牌 分别放进去
            List<Integer> card = new ArrayList<>();
            List<Integer> card1 = new ArrayList<>();
            List<Integer> card2 = new ArrayList<>();

            for (int j = 0; j < 2*n; j++) {
                card.add(scanner.nextInt());
            }
            for (int m = 0; m < k; m++) {
                // 放在这里 一组牌 需要多次洗
                card1.clear();
                card2.clear();
                for(int j = 0; j < n; j++) {
                    card1.add(card.get(j));
                }
                //System.out.println("card1 : "+card1);
                for(int j = n; j < 2*n; j++) {
                    card2.add(card.get(j));
                }
                //System.out.println("card2 : " + card2);
                // 洗牌

                card.clear();
                for (int j = 0; j < n; j++) {
                    card.add(card1.get(j));
                    card.add(card2.get(j));
                }

            }

            // 每幅牌 洗完之后打印一行
            //System.out.println(card);
            System.out.println(
                    card.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
           // System.out.println(card.toString());


        }


    }
}
