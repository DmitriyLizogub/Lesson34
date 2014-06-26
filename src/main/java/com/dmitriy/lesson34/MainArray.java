package com.dmitriy.lesson34;

import java.util.Arrays;

/**
 * Created by dmitriy on 6/24/14.
 */
public class MainArray {

    public static void main(String [] args){
        int [] leftArray = {1,5,4,23,65,32,78};
        int [] rightArray = {3,5,24,4,1,2,34,45,32,5};

        ArrayHelper arrayHelper = new ArrayHelper();
        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);
        System.out.println(Arrays.toString(resultArray));
    }
}
