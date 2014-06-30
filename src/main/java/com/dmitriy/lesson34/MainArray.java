package com.dmitriy.lesson34;

import java.util.Arrays;

/**
 * Created by dmitriy on 6/24/14.
 */
public class MainArray {

    public static void main(String [] args){
        int [] leftArray = {1,5,4,5,23,65,32,78,0,0,-49,5,555,3478};
        int [] rightArray = {7,3,5,0,0,23,5,4,1,34,45,32,-49};

        ArrayHelper arrayHelper = new ArrayHelper();
        int [] resultArray = arrayHelper.leftUnion(leftArray, rightArray);
        System.out.println(Arrays.toString(resultArray));

        int [] leftArrayInner = {1,5,4,23,65,32,78,-464,};
        int [] rightArrayInner = {3,5,24,4,1,2,34,45,32,-464,5};

        int [] innerUnionRes = arrayHelper.innerUnion(leftArrayInner,rightArrayInner);
        System.out.println(Arrays.toString(innerUnionRes));
    }
}
