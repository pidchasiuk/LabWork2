package ua.kpi.comsys.iv7112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task1 {
    static int randomValue(int maxValue) {
        switch ((int) (Math.round(Math.random() * 5) + 1)) {
            case 1:
                return Math.round(maxValue * 0.7f);
            case 2:
                return Math.round(maxValue * 0.9f);
            case 3:
            case 4:
            case 5:
                return maxValue;
            default:
                return 0;
        }

    }

    static Integer[] makePoints() {
        int[] points = {5, 8, 15, 15, 13, 10, 10, 10, 15};
        Integer[] res = new Integer[points.length];
        for (int i = 0; i < points.length; i++) {
            res[i] = randomValue(points[i]);
        }
        return res;
    }

    static String refactorPoints(Integer[] arr){
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                res += "[" + arr[i] + ", ";
            }
            else if (i == arr.length - 1){
                res += arr[i] + "]";
            }
            else {
                res += arr[i] + ", ";
            }


        }
        return res;
    }

    static Integer countSum(Integer[] tempPoints) {
        Integer sum = 0;
        for (int i = 0; i < tempPoints.length; i++) {
            sum += tempPoints[i];
        }
        return sum;
    }

    static float countMiddle(HashMap<String, Integer> temp){
        List<String> keys = new ArrayList<String>(temp.keySet());
        Integer sum = 0;
        for(int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Integer value = temp.get(key);
            sum += value;
        }
        return sum / keys.size();
    }

    static List<String> moreThan(HashMap<String, Integer> temp){
        List<String> keys = new ArrayList<String>(temp.keySet());
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Integer value = temp.get(key);
            if (value >= 60){
                res.add(key);
            }
        }
        return res;
    }

}
