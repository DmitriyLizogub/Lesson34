package com.dmitriy.lesson34;

import java.util.Arrays;

/**
 * Created by dmitriy on 6/24/14.
 */
public class ArrayHelper implements ArraysUnion {

    @Override
    public int[] leftUnion(int[] leftArray, int[] rightArray) {

        if (leftArray != null && rightArray != null && (leftArray.length + rightArray.length) < Integer.MAX_VALUE) {
            int resultLength = leftArray.length + rightArray.length;
            int[] resultArray = Arrays.copyOf(leftArray, resultLength);
            int count = leftArray.length;
            Arrays.sort(resultArray);

            for (int i = 0; i < rightArray.length; i++) {
                if (Arrays.binarySearch(resultArray, rightArray[i]) >= 0) {
                    resultArray[i] = rightArray[i];
                    count++;
                }
            }
            return removeUnneededZerosFromArray(leftArray, rightArray, resultArray, true);
        }
        return null;
    }


    @Override
    public int[] innerUnion(int[] leftArray, int[] rightArray) {
        if (leftArray != null && rightArray != null && (leftArray.length + rightArray.length) < Integer.MAX_VALUE) {

            int resultLength = leftArray.length + rightArray.length;
            int[] resultArray = new int[resultLength];
            for (int i = 0; i < leftArray.length; i++) {
                for (int j = 0; j < rightArray.length; j++) {
                    if (leftArray[i] == rightArray[j]) resultArray[i] = leftArray[i];
                }
            }
            int[] rezArray = setDuplicatesAsZero(resultArray);

            return removeUnneededZerosFromArray(leftArray, rightArray, rezArray, false);

        }
        return null;

    }


    @Override
    public int[] outerUnion(int[] leftArray, int[] rightArray) {
        if (leftArray != null && rightArray != null && (leftArray.length + rightArray.length) < Integer.MAX_VALUE) {
            int resultLength = leftArray.length + rightArray.length;

            Arrays.sort(leftArray);
            for (int k = 0; k < leftArray.length - 1; k++) {
                if (leftArray[k] == leftArray[k + 1]) leftArray[k + 1] = 0;
            }

            Arrays.sort(rightArray);
            for (int z = 0; z < leftArray.length - 1; z++) {
                if (rightArray[z] == rightArray[z + 1]) rightArray[z + 1] = 0;
            }

            int[] resArray = Arrays.copyOf(leftArray, resultLength);
            for (int t = 0; t < rightArray.length; t++) {
                resArray[leftArray.length + t] = rightArray[t];
            }

            Arrays.sort(resArray);
            for (int i = 0; i < resArray.length - 1; i++) {

                if (resArray[i] == resArray[i + 1]) resArray[i] = resArray[i + 1] = 0;

            }

            return removeUnneededZerosFromArray(leftArray, rightArray, resArray, false);


        }
        return null;
    }


    private int[] removeUnneededZerosFromArray(int[] leftArray, int[] rightArray, int[] resultArray, boolean flagLeft) {
        int zerosInResultArray = countAllZerosInArray(resultArray);
        int neededZeros = countNeededZeros(leftArray, rightArray, flagLeft);
        int numberOfElementsForRemove = zerosInResultArray - neededZeros;
        int newArrayLength = resultArray.length - numberOfElementsForRemove;

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] == 0) {
                resultArray[i] = -2147483648;
            }
        }

        Arrays.sort(resultArray);

        int[] destArray = new int[newArrayLength];
        System.arraycopy(resultArray, numberOfElementsForRemove, destArray, 0, newArrayLength);

        for (int t = 0; t < neededZeros; t++) {
            destArray[t] = 0;
        }
        return destArray;
    }

    private int countNeededZeros(int[] leftArray, int[] rightArray, boolean flagLeft) {
        int counter = 0;

        if (flagLeft) {
            if (isZerosInArray(leftArray)) {
                for (int k = 0; k < leftArray.length; k++) {
                    if (leftArray[k] == 0) counter++;
                }
                if (isZerosInArray(rightArray)) {
                    for (int z = 0; z < rightArray.length; z++) {
                        if (rightArray[z] == 0) counter++;
                    }
                }
            }
        } else {
            if (isZerosInArray(rightArray) && isZerosInArray(leftArray)) counter = 1;
            else counter = 0;
        }
        return counter;
    }

    private int countAllZerosInArray(int[] inputArray) {
        int coun = 0;

        if (isZerosInArray(inputArray)) {
            for (int k = 0; k < inputArray.length; k++) {
                if (inputArray[k] == 0) coun++;
            }

        }
        return coun;

    }

    private boolean isZerosInArray(int[] inputArray) {
        boolean isZeros = false;
        for (int k = 0; k < inputArray.length; k++) {
            if (inputArray[k] == 0) {
                isZeros = true;
                break;
            }
        }
        return isZeros;
    }

    private int[] setDuplicatesAsZero(int[] inputArray) {
        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) inputArray[i] = 0;

        }
        return inputArray;
    }

}
