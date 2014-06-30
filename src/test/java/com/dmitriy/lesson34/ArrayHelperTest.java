package com.dmitriy.lesson34;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class ArrayHelperTest {//Ctrl+Shift+T create test class

    @Test
    public void testLeftUnion_LeftArrayIsEmpty (){
        //initialize variable inputs
        int [] leftArray = {};
        int [] rightArray = {3,5,24,4,1,2,34,45,32,5};
        int [] expectedArray = {};

        //initialize mocks

        //initialize object of class to test
        ArrayHelper arrayHelper = new ArrayHelper();

        //invoke method on class to test
        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        //assertion block
        Assert.assertArrayEquals("When left array is empty the method leftUnion() doesn't work right.", expectedArray, resultArray);

        //verify mocks expectations
    }

    @Test
    public void testLeftUnion_RightArrayIsEmpty (){

        int [] leftArray = {0,-445,-5,1,2,5,8,999};
        int [] rightArray = {};
        int [] expectedArray = {0,-445,-5,1,2,5,8,999};

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When right array is empty the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_BothArraysAreEmpty (){

        int [] leftArray = {};
        int [] rightArray = {};
        int [] expectedArray = {};

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When both arrays are empty the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_BothArraysInitWithZeros (){

        int [] leftArray = {0,0,0,0,0};
        int [] rightArray = {0,0,0,0,0};
        int [] expectedArray = {0,0,0,0,0,0,0,0,0,0};

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When both arrays have just zero values the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_MaxInt (){

        int [] leftArray = {1,2147483647};
        int [] rightArray = {2147483647,2};
        int [] expectedArray = {1,2147483647, 2147483647};

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When both arrays have Max Int values the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_FirstArrayIsNull (){

        int [] leftArray = null;
        int [] rightArray = {2147483647,2,6,-5,0};
        int [] expectedArray = null;

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When first array is NULL the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_SecondArrayIsNull (){

        int [] leftArray = {2147483647,2,6,-5,0};
        int [] rightArray = null;
        int [] expectedArray = null;

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When second array is NULL the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test //TODO:fix problem with negative values
    public void testLeftUnion_BothArraysContainsJustNegativeValues (){

        int [] leftArray = {-7,-5,-10000,-6,-300}; //kill -7 and -300
        int [] rightArray = {-78,-5,-6,-6,-100,-300,-4}; //don't see -300 and second -6
        int [] expectedArray = {-10000, -6, -6, -5, -5};

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);
        System.out.println(Arrays.toString(resultArray));
        Assert.assertArrayEquals("When both arrays contains just negative values the method leftUnion() doesn't work right.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_SecondArrayReallyTooLarge(){ //TEST FAILED

        int [] leftArray = {};
        int [] rightArray = new int[Integer.MAX_VALUE]; //java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        int [] expectedArray = null;                    // or java.lang.OutOfMemoryError: Java heap space

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);

        Assert.assertArrayEquals("When second array get Integer.MAX_VALUE length the method leftUnion() doesn't work totally.", expectedArray, resultArray);
    }

    @Test
    public void testLeftUnion_BothArraysAreLarge(){ //without Assert but execute for more than 3 mins with such arrays lengths

        int [] leftArray = randomArray(Integer.MAX_VALUE/100);
        int [] rightArray = randomArray(Integer.MAX_VALUE/100);

        ArrayHelper arrayHelper = new ArrayHelper();

        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);
        System.out.println(Arrays.toString(resultArray));

    }

    private int[] randomArray(int arrayLength){
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*10000000 - 5000000);
        }
        return array;
    }
}