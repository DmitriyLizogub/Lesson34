package com.dmitriy.lesson34;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertArrayEquals("Then left array is empty method leftUnion() doesn't work right.", expectedArray, resultArray);

        //verify mocks expectations
    }

}