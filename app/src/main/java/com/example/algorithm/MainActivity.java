package com.example.algorithm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.easy.Sum;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testOneSum();
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
}