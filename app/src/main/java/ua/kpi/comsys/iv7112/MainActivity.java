package ua.kpi.comsys.iv7112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String students = "Бортнік Василь - ІВ-72; Чередніченко Владислав - ІВ-73; Гуменюк Олександр - ІВ-71; Корнійчук Ольга - ІВ-71; Киба Олег - ІВ-72; Капінус Артем - ІВ-73; Овчарова Юстіна - ІВ-72; Науменко Павло - ІВ-73; Трудов Антон - ІВ-71; Музика Олександр - ІВ-71; Давиденко Костянтин - ІВ-73; Андрющенко Данило - ІВ-71; Тимко Андрій - ІВ-72; Феофанов Іван - ІВ-71; Гончар Юрій - ІВ-73";

            // Task 1
            // Create dictionary:
            // - key is a group name
            // - value is sorted array with students

            List<String> studentsIV71 = new ArrayList<String>();
            List<String> studentsIV72 = new ArrayList<String>();
            List<String> studentsIV73 = new ArrayList<String>();

            String[] studentsArray = students.split("; ");
            for (String s : studentsArray) {
                int len = s.length();
                if (s.endsWith("1")) {
                    studentsIV71.add(s.substring(0, len - 8));
                }
                if (s.endsWith("2")) {
                    studentsIV72.add(s.substring(0, len - 8));
                }
                if (s.endsWith("3")) {
                    studentsIV73.add(s.substring(0, len - 8));
                }
            }

            Collections.sort(studentsIV71);
            Collections.sort(studentsIV72);
            Collections.sort(studentsIV73);

            HashMap<String, List<String>> res1 = new HashMap<>();
            res1.put("ІВ-71", studentsIV71);
            res1.put("ІВ-72", studentsIV72);
            res1.put("ІВ-73", studentsIV73);

            // Task 2, 3, 4, 5
            // Create dictionary:
            // - key is a group name
            // - value is dictionary:
            //     - key is student
            //     - value is array with points (fill it with random values, use function `randomValue(maxValue: Int) -> Int` )
            // - value is dictionary:
            //     - key is student
            //     - value is sum of student's points
            // - value is average of all students points
            // - value is array of students that have >= 60 points

            HashMap<String, HashMap<String, String>> res2 = new HashMap<>(); // result of task 2
            HashMap<String, HashMap<String, Integer>> res3 = new HashMap<>(); // result of task 3
            HashMap<String, Float> res4 = new HashMap<>(); // result of task 4
            HashMap<String, List<String>> res5 = new HashMap<>(); // result of task 5

            HashMap<String, String> temp1 = new HashMap<>();
            HashMap<String, Integer> temp1_1 = new HashMap<>();
            for (String s : studentsIV71) {
                Integer[] tempPoints = Task1.makePoints();
                temp1.put(s, Task1.refactorPoints(tempPoints));
                temp1_1.put(s, Task1.countSum(tempPoints));
            }
            res2.put("ІВ-71", temp1);
            res3.put("ІВ-71", temp1_1);
            res4.put("ІВ-71", Task1.countMiddle(temp1_1));
            res5.put("ІВ-71", Task1.moreThan(temp1_1));

            HashMap<String, String> temp2 = new HashMap<>();
            HashMap<String, Integer> temp2_2 = new HashMap<>();
            for (String s : studentsIV72) {
                Integer[] tempPoints = Task1.makePoints();
                temp2.put(s, Task1.refactorPoints(tempPoints));
                temp2_2.put(s, Task1.countSum(tempPoints));
            }
            res2.put("ІВ-72", temp2);
            res3.put("ІВ-72", temp2_2);
            res4.put("ІВ-72", Task1.countMiddle(temp2_2));
            res5.put("ІВ-72", Task1.moreThan(temp2_2));

            HashMap<String, String> temp3 = new HashMap<>();
            HashMap<String, Integer> temp3_3 = new HashMap<>();
            for (String s : studentsIV73) {
                Integer[] tempPoints = Task1.makePoints();
                temp3.put(s, Task1.refactorPoints(tempPoints));
                temp3_3.put(s, Task1.countSum(tempPoints));
            }
            res2.put("ІВ-73", temp3);
            res3.put("ІВ-73", temp3_3);
            res4.put("ІВ-73", Task1.countMiddle(temp3_3));
            res5.put("ІВ-73", Task1.moreThan(temp3_3));

            Log.i("Task1", res1.toString()); // result of task 1
            Log.i("Task2", res2.toString()); // result of task 2
            Log.i("Task3", res3.toString()); // result of task 3
            Log.i("Task4", res4.toString()); // result of task 4
            Log.i("Task5", res5.toString()); // result of task 5

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TimeHP t1 = new TimeHP();
            TimeHP t2 = new TimeHP(10, 27, 11);;
            TimeHP t3 = new TimeHP(new Time(10, 27,12));

            Log.i("toString", t2.toString()); //10:27:11 AM
            Log.i("sum", t1.sum(t2).toString()); // 10:27:11 AM
            Log.i("difference", t1.diff(t3).toString()); //1:32:48 PM
            Log.i("static sum", TimeHP.sum(t2, t3).toString()); // 8:54:23 PM
            Log.i("static difference", TimeHP.diff(t2, t3).toString()); //11:59:59 PM
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}