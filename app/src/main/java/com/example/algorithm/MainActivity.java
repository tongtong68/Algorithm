package com.example.algorithm;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithm.difficult.Four;
import com.example.algorithm.difficult.FourtyTwo;
import com.example.algorithm.difficult.HundredAndTwentyEight;
import com.example.algorithm.difficult.ThirtyTwo;
import com.example.algorithm.difficult.TwoHundredAndNinetySeven;
import com.example.algorithm.easy.FourHundredAndFortyEight;
import com.example.algorithm.easy.FourHundredAndSixtyOne;
import com.example.algorithm.easy.HundredAndFour;
import com.example.algorithm.easy.HundredAndSixtyNine;
import com.example.algorithm.easy.HundredAndThirtySix;
import com.example.algorithm.easy.Seventy;
import com.example.algorithm.easy.Sum;
import com.example.algorithm.easy.TwoHundredAndEighty;
import com.example.algorithm.easy.TwoHundredAndSix;
import com.example.algorithm.easy.TwoHundredAndThirtyFour;
import com.example.algorithm.easy.TwoHundredAndTwentySix;
import com.example.algorithm.medium.FiftyFive;
import com.example.algorithm.medium.Five;
import com.example.algorithm.medium.FiveHundredAndEightyOne;
import com.example.algorithm.medium.FortyEight;
import com.example.algorithm.medium.FortySix;
import com.example.algorithm.medium.FourHundredAndSix;
import com.example.algorithm.medium.HundredAndFiftyTwo;
import com.example.algorithm.medium.HundredAndFourteen;
import com.example.algorithm.medium.HundredAndThirtyNine;
import com.example.algorithm.medium.HundredAndTwo;
import com.example.algorithm.medium.NinetyEight;
import com.example.algorithm.medium.SeventyFive;
import com.example.algorithm.medium.SeventyNine;
import com.example.algorithm.medium.ThirtyNine;
import com.example.algorithm.medium.ThirtyThree;
import com.example.algorithm.medium.ThreeHundredAndFortySeven;
import com.example.algorithm.medium.ThreeHundredAndThirtyEight;
import com.example.algorithm.medium.ThreeHundredAndThirtySeven;
import com.example.algorithm.medium.ThreeHundredAndTwentyTwo;
import com.example.algorithm.medium.TwoHundredAndEightySeven;
import com.example.algorithm.medium.TwoHundredAndFifteen;
import com.example.algorithm.medium.TwoHundredAndThirtyEight;
import com.example.algorithm.structure.BinaryTree;
import com.example.algorithm.structure.ListNode;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.LinkedList;
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
        //testFortySix();
        //testFortyEight();
        //testFiftyFive();
        //testFiftyFive();
        //testSeventy();
        //testSeventyFive();
        //testSeventyNine();
        //testNinetyEight();
        //testHundredAndTwo();
        //testHundredAndFour();
        //testHundredAndFourteen();
        //testHundredAndTwentyEight();
        //testHundredAndThirtySix();
        //testHundredAndFiftyTwo();
        //testHundredAndSixtyNine();
        //testTwoHundredAndSix();
        //testTwoHundredAndFifteen();
        //testTwoHundredAndTwentySix();
        //testTwoHundredAndThirtyFour();
        //testTwoHundredAndThirtyEight();
        //testTwoHundredAndEighty();
        //testTwoHundredAndEightySeven();
        //testTwoHundredAndNinetySeven();
        //testThreeHundredAndTwentyTwo();
        //testThreeHundredAndThirtySeven();
        //testThreeHundredAndThirtyEight();
        //testThreeHundredAndFortySeven();
        //testFourHundredAndSix();
        //testFourHundredAndFortyEight();
        //testFourHundredAndSixtyOne();
        testFiveHundredAndEightyOne();
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

    private void testFortyEight() {
        FortyEight fortyEight = new FortyEight();
        int[][] matrix = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20},{21, 22,23,24,25}};
        for(int i=0; i<5; ++i) {
            for(int j=0; j<5; ++j)
                System.out.print(matrix[i][j] + ", ");
            System.out.print("\n");//显示成数组的表现形式
        }

        System.out.print("\nmatrix length is: " + matrix.length + "\n");//显示成数组的表现形式

        fortyEight.rotate2(matrix);

        for(int i=0; i<5; ++i) {
            for(int j=0; j<5; ++j)
                System.out.print(matrix[i][j] + ", ");
            System.out.print("\n");//显示成数组的表现形式
        }

    }

    private void testFiftyFive() {
        FiftyFive fiftyFive = new FiftyFive();
        boolean result = fiftyFive.canJump2();
        Log.d("test", "======result: " + result);
    }

    private void testSeventy() {
        Seventy seventy = new Seventy();
        int result1 = seventy.climbStairs(20);
        int result2 = seventy.getResult(20);
        Log.d("test", "======result1: " + result1);
        Log.d("test", "======result2: " + result2);
    }

    private void testSeventyFive() {
        SeventyFive five = new SeventyFive();
        int[] nums = new int[] {1, 2, 0, 1, 2, 0, 0, 2};
        five.sortColors2(nums);
        System.out.print("====result: ");
        for (int j=0; j<nums.length; ++j) {
            System.out.print(nums[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testSeventyNine() {
        SeventyNine seventyNine = new SeventyNine();
        char[][] board = new char[][]{{'a', 'd', 'c'}, {'e', 'd', 'b'},{'a', 'b', 'e'}};
        String word = "bcd";
        boolean result = seventyNine.exist(board, word);
        Log.d("test", "======result: " + result);
    }

    private void testNinetyEight() {
        NinetyEight ninetyEight = new NinetyEight();
        int[] tree = new int[] {5,1,8,0,2,7,9};

        BinaryTree a = new BinaryTree(tree);
        boolean result = ninetyEight.isValidBST(a.getRoot());
        Log.d("test", "======result: " + result);
    }

    private void testHundredAndTwo() {
        HundredAndTwo hundredAndTwo = new HundredAndTwo();
        int[] tree = new int[] {5,1,8,0,2,7,9};
        BinaryTree a = new BinaryTree(tree);
        List<List<Integer>> b = hundredAndTwo.levelOrder2(a.getRoot());
        for (int j=0; j<b.size(); ++j) {
            System.out.print(b.get(j) + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testHundredAndFour() {
        HundredAndFour hundredAndFour = new HundredAndFour();
        int[] tree = new int[] {5,1,8,0,2,7,9};
        BinaryTree a = new BinaryTree(tree);
        int result = hundredAndFour.maxDepth(a.getRoot());
        Log.d("test", "======result: " + result);
    }

    private void testHundredAndFourteen() {
        HundredAndFourteen hundredAndFourteen = new HundredAndFourteen();
        int[] tree = new int[] {5,1,8,0,2,7,9};
        BinaryTree a = new BinaryTree(tree);
        a.show(a.getRoot());
        BinaryTree b = hundredAndFourteen.getLinkedListTree2(a.getRoot());
        b.show(b.getRoot());

    }

    private void testHundredAndTwentyEight() {
        HundredAndTwentyEight hundredAndTwentyEight = new HundredAndTwentyEight();
        int[] nums = new int[] {1, 4, 5, 3, 12};
        int result = hundredAndTwentyEight.longestConsecutive(nums);
        Log.d("test", "======result: " + result);
    }

    private void testHundredAndThirtySix() {
        HundredAndThirtySix hundredAndThirtySix = new HundredAndThirtySix();
        int[] nums = new int[] {1, 1, 3, 3, 5, 9, 5};
        int result = hundredAndThirtySix.getResult2(nums);
        Log.d("test", "======result: " + result);
    }

    private void testHundredAndFiftyTwo() {
        HundredAndFiftyTwo hundredAndFiftyTwo = new HundredAndFiftyTwo();
        int[] nums = new int[] {1, 1, -3, 1, 5, -3, 5};
        int result = hundredAndFiftyTwo.maxProduct(nums);

        Log.d("test", "======result: " + result);
    }

    private void testHundredAndSixtyNine() {
        HundredAndSixtyNine hundredAndSixtyNine = new HundredAndSixtyNine();
        int[] nums = new int[] {2, 2, 3, 3, 5, 5, 5, 3, 3, 1, 4};
        int result = hundredAndSixtyNine.majorityElement(nums);
        Log.d("test", "======result: " + result);
    }

    private void testTwoHundredAndSix() {
        TwoHundredAndSix twoHundredAndSix = new TwoHundredAndSix();
        ListNode head = ListNode.createListFromArray(new int[]{1, 2, 3, 4, 5});
//        while (head != null) {
//            Log.d("test", head.value + ", ");
//            head = head.next;
//        }

        ListNode reverse = twoHundredAndSix.getReverse(head);
        while (reverse != null && reverse.value != 0) {
            Log.d("test", reverse.value + ", ");
            reverse = reverse.next;
        }
    }

    private void testTwoHundredAndFifteen() {
        TwoHundredAndFifteen twoHundredAndFifteen = new TwoHundredAndFifteen();
        int[] nums = new int[]{3, 5, 8, 11, 4, 0, 7, 2, 9};
        twoHundredAndFifteen.quickSort(nums);
        for (int j=0; j<nums.length; ++j) {
            System.out.print(nums[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式

    }

    private void testTwoHundredAndTwentySix() {
        TwoHundredAndTwentySix twoHundredAndTwentySix = new TwoHundredAndTwentySix();
        int[] tree = new int[] {5,1,8,0,2,7,9};
        BinaryTree a = new BinaryTree(tree);
        a.show(a.getRoot());
        twoHundredAndTwentySix.reverseTree(a.getRoot());
        a.show(a.getRoot());
    }

    private void testTwoHundredAndThirtyFour() {
        TwoHundredAndThirtyFour twoHundredAndThirtyFour = new TwoHundredAndThirtyFour();
        int[] nums = new int[] {1, 2, 2, 1};
        ListNode a = ListNode.createListFromArray(nums);
        boolean result = twoHundredAndThirtyFour.isReverseWord(a);
        Log.d("test", "=========result: " + result);
    }

    private void testTwoHundredAndThirtyEight() {
        TwoHundredAndThirtyEight twoHundredAndThirtyEight = new TwoHundredAndThirtyEight();
        int[] nums = new int[] {1, 2, 3, 3, 1};
        int[] result = twoHundredAndThirtyEight.getMultiply(nums);
        for (int j=0; j<result.length; ++j) {
            System.out.print(result[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testTwoHundredAndEighty() {
        TwoHundredAndEighty twoHundredAndEighty = new TwoHundredAndEighty();
        int[] nums = new int[] {1, 0, 2, 3, 0, 1};
        twoHundredAndEighty.moveZeroes(nums);
        Log.d("test", "=========result: ");
        for (int j=0; j<nums.length; ++j) {
            System.out.print(nums[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testTwoHundredAndEightySeven() {
        TwoHundredAndEightySeven twoHundredAndEightySeven = new TwoHundredAndEightySeven();
        int[] nums = new int[] {1, 2, 2, 3, 4, 5};
        int result = twoHundredAndEightySeven.searchDuplicate(nums);
        Log.d("test", "=========result: " + result);
    }

    private void testTwoHundredAndNinetySeven() {
        TwoHundredAndNinetySeven twoHundredAndNinetySeven = new TwoHundredAndNinetySeven();
        int[] tree = new int[] {5,1,8};
        BinaryTree a = new BinaryTree(tree);
        a.show(a.getRoot());
        String serialize = twoHundredAndNinetySeven.serialize(a.getRoot());
        Log.d("test", "=========result: " + serialize);
        BinaryTree.TreeNode temp = twoHundredAndNinetySeven.deserialize(serialize);
        BinaryTree b = new BinaryTree(temp);
        b.show(b.getRoot());
    }

    private void testThreeHundredAndTwentyTwo() {
        ThreeHundredAndTwentyTwo threeHundredAndTwentyTwo = new ThreeHundredAndTwentyTwo();
        int[] coins = new int[] {186, 419, 83, 408};
        int amount = 6249;
        int result = threeHundredAndTwentyTwo.coinChange(coins, amount);
        Log.d("test", "=========result: " + result);
    }

    private void testThreeHundredAndThirtySeven() {
        ThreeHundredAndThirtySeven threeHundredAndThirtySeven = new ThreeHundredAndThirtySeven();
        int[] tree = new int[] {5,1,8,0,2,7,9};
        BinaryTree a = new BinaryTree(tree);
        a.show(a.getRoot());
        int result = threeHundredAndThirtySeven.getMaxValue(a.getRoot());
        Log.d("test", "=========result: " + result);
    }

    private void testThreeHundredAndThirtyEight() {
        ThreeHundredAndThirtyEight threeHundredAndThirtyEight = new ThreeHundredAndThirtyEight();
        int[] result = threeHundredAndThirtyEight.countBits(4);
        for (int j=0; j<result.length; ++j) {
            System.out.print(result[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void testThreeHundredAndFortySeven() {
        ThreeHundredAndFortySeven threeHundredAndFortySeven = new ThreeHundredAndFortySeven();
        int[] nums = new int[]{1, 2};
        int[] result = threeHundredAndFortySeven.getHighestFrequencyNum(nums, 2);
        for (int j=0; j<result.length; ++j) {
            System.out.print(result[j] + ", ");
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testFourHundredAndSix() {
        FourHundredAndSix fourHundredAndSix = new FourHundredAndSix();
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = fourHundredAndSix.reconstructQueue(people);
        for (int j=0; j<result.length; ++j) {
            System.out.println(Arrays.toString(result[j]));
        }
        System.out.print("\n");//显示成数组的表现形式
    }

    private void testFourHundredAndFortyEight() {
        FourHundredAndFortyEight fourHundredAndFortyEight = new FourHundredAndFortyEight();
        int[] a = new int[]{4, 3, 2, 2};
        List<Integer> result = fourHundredAndFortyEight.findDisappearedNumbers(a);
//        for (int j=0; j<result.size(); ++j) {
//            System.out.print(result.get(j) + ", ");
//        }
//        System.out.print("\n");//显示成数组的表现形式
    }

    private void testFourHundredAndSixtyOne() {
        FourHundredAndSixtyOne fourHundredAndSixtyOne = new FourHundredAndSixtyOne();
        int result = fourHundredAndSixtyOne.getHanMingDistance(1, 4);
        Log.d("test", "=========result: " + result);
    }

    private void testFiveHundredAndEightyOne() {
        FiveHundredAndEightyOne fiveHundredAndEightyOne = new FiveHundredAndEightyOne();
        int[] a = new int[]{2, 6, 4, 8, 10, 9, 15};
        int result = fiveHundredAndEightyOne.findUnsortedSubarray2(a);
        Log.d("test", "=========result: " + result);
    }
}