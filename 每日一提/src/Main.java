import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -04
 * Time: 14:50
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Map<Integer,Integer> map = new HashMap<>();
        int lsNum = 0;//连胜次数
        int count = 0; // 比赛次数
        //System.out.println(n +"," + m+"," +list);

        while (true) {
            boolean flag = false;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if(entry.getValue() == m) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            int i = 0;
            if(list.get(i) < list.get(i+1)) {
                map.put(list.get(i+1),map.getOrDefault(list.get(i+1),0)+1);
                int temp = list.remove(i);
                list.add(temp);

            } else {
                map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
                int temp = list.remove(i);
                list.add(temp);

            }
            count ++;
        }
        System.out.println(count);
    }
}
