package com.example.algorithm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.difficult.Four;
import com.example.algorithm.difficult.FourtyTwo;
import com.example.algorithm.difficult.ThirtyTwo;
import com.example.algorithm.easy.Sum;
import com.example.algorithm.medium.Five;
import com.example.algorithm.medium.FortySix;
import com.example.algorithm.medium.ThirtyNine;
import com.example.algorithm.medium.ThirtyOne;
import com.example.algorithm.medium.ThirtyThree;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testOneSum();
        //testFour();
        //testFive();
        //testThirtyTwo();
        //testThirtyThree();
        //testThirtyNine();
        //testFourtyTwo();
        testFortySix();
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

    private void testThirtyThree() {
        ThirtyThree thirtyThree = new ThirtyThree();
        int result = thirtyThree.search(new int[]{9, 25, 38, 0, 3, 7}, 7);
        Log.d("test", "======" + result);
    }

    private void testThirtyNine() {
        ThirtyNine thirtyNine = new ThirtyNine();
        List<List<Integer>> result = thirtyNine.combinationSum(new int[]{9, 2, 4, 0, 3, 7}, 7);
        Log.d("test", "======" + result);
    }

    private void testFourtyTwo() {
        FourtyTwo fourtyTwo = new FourtyTwo();
        int result = fourtyTwo.trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        Log.d("test", "======" + result);
    }

    private void testFortySix() {
        FortySix fortySix = new FortySix();
        List<List<Integer>> a = fortySix.permute2(new int[]{1, 2, 3, 4});
        Log.d("test", "====排列总数：" + a.size());
        for (List temp:a) {
            Log.d("test", "====排列: [" + temp.get(0) + ", " + temp.get(1) + ", " + temp.get(2) + ", " + temp.get(3) + "]");
        }
    }
}