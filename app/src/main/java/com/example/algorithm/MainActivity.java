package com.example.algorithm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.difficult.Four;
import com.example.algorithm.difficult.ThirtyTwo;
import com.example.algorithm.easy.Sum;
import com.example.algorithm.medium.Five;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testOneSum();
        //testFour();
        //testFive();
        testThirtyTwo();
    }

    private void testOneSum() {
        int[] array = {1, 8, 9, 3, 5, 6, 7, 3};
        int target = 6;
        Sum sum = new Sum(array, target);
        List<int[]> result = sum.getSum();
        Log.d("test", "=====size: " + result.size());
        for (int i = 0 ; i<result.size();i++){
            int[] temp = result.get(i);
            Log.d("test", "=====index: [" + temp[0] + ", " + temp[1] + "]");
        }
    }

    private void testFour() {
        int[] a = {4, 7, 98, 111};
        int[] b = {0, 4, 8, 111, 123};

        Four four = new Four();
        int[] result = four.merge(a, b);
        for (int i = 0 ; i<result.length;i++){
            Log.d("test", result[i] + ", ");
        }
    }

    private void testFive() {
        Five five = new Five();
        String result = five.getResult("jofiuofiowefijjfjsldfjuawef");
        Log.d("test", "======" + result);
    }

    private void testThirtyTwo() {
        ThirtyTwo thirtyTwo = new ThirtyTwo();
        int result = thirtyTwo.longestValidParentheses2("(())");
        Log.d("test", "======" + result);
    }
}