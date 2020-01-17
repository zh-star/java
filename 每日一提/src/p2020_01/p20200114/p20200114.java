package p2020_01.p20200114;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 17:11
 */
public class p20200114 {

    // 1. 说反话
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = reverseString(s);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
             sb.append(reverseString(str[i]));
             sb.append(" ");
        }
        System.out.println(sb);
    }
    private static String reverseString(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] str =  s.toCharArray();
        while(left < right) {
            char ch = str[left];
            str[left] = str[right];
            str[right] = ch;
            left ++;
            right --;
        }
        return new String(str);
    }



    // 2.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();//LinkedHashMap而不是hashmap！！！！！
        String key;
        String filename;
        String path;
        while(in.hasNext()){
            path = in.next();
            //将路径转换为文件名
            int id = path.lastIndexOf('\\');
            //如果找不到说明只有文件名没有路径
            filename = id<0  ? path : path.substring(id+1);
            int linenum = in.nextInt();
            //统计频率
            key = filename+" "+linenum;
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }

        in.close();

        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            //降序
            @Override
            public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }

        }

    }
}
