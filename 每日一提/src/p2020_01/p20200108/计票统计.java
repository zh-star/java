package p2020_01.p20200108;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 16:11
 */


public class 计票统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candidateNum = in.nextInt();
        in.nextLine();
        String candidateName = in.nextLine();
        String votePersonNum = in.next();//投票人数
        in.nextLine();
        String vote = in.nextLine();//投票
        // 添加候选人
        String[] candidateNameValue =  candidateName.split(" ");
        Map<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < candidateNameValue.length; i++) {
            map.put(candidateNameValue[i],0);
        }
        map.put("Invalid",0);//弃权的



        String[] voteValue = vote.split(" ");
        for (int i = 0; i < voteValue.length; i++) {
            if(map.containsKey(voteValue[i])) {
                map.put(voteValue[i],map.get(voteValue[i])+1);
            } else {
                map.put("Invalid",map.get("Invalid")+1);
            }
            for (Map.Entry<String, Integer> m : map.entrySet()){
                if(m.getKey() == voteValue[i]) {
                    map.put(m.getKey(),m.getValue()+1);
                }
            }
            map.put("Invalid",map.get("Invalid")+1);

        }

        for (Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue());
        }

    }

}
