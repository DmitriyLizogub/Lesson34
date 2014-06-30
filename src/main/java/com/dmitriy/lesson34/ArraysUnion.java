package com.dmitriy.lesson34;

/**
 * Created by dmitriy on 6/19/14.
 */
public interface ArraysUnion {

    public  int[] leftUnion(int[] leftArray, int[] rightArray);

    public  int[] innerUnion(int[] leftArray, int[] rightArray);

    public  int[] outerUnion(int[] leftArray, int[] rightArray);
}
