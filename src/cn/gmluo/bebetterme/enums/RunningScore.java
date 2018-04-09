package cn.gmluo.bebetterme.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Change myself（改变自我）
 * 完成跑步公里数分值设置
 * Running   跑步（(0:没完成，1：完成了1公里....以此类推)
 * Created by gmluo on 2018/4/9.
 */
public class RunningScore {
    public int getRunningScore(float value) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -2);
        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);
        map.put(4, 8);
        map.put(5, 10);
        map.put(6, 12);
        map.put(7, 14);
        map.put(8, 16);
        map.put(9, 18);
        map.put(10, 25);
        map.put(11, 30);
        map.put(12, 35);
        map.put(13, 40);
        map.put(14, 45);
        map.put(15, 60);
        map.put(16, 70);
        map.put(17, 80);
        map.put(18, 90);
        map.put(19, 100);
        map.put(20, 150);
        map.put(21, 200);

        return map.get((int) value);
    }

    public static void main(String[] args) {
        float distance= (float) 0;
        int score= new RunningScore().getRunningScore(distance);
        System.out.println(score);
    }
}
