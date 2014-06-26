package com.dmitriy.lesson34;

import java.util.Arrays;

/**
 * Created by dmitriy on 6/24/14.
 */
public class ArrayHelper implements LeftUnion {

    @Override
    public int[] leftUnion(int[] a, int[] b) {

        int sumLength = a.length + b.length;
        int[] c = Arrays.copyOf(a, sumLength);
        int count = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++)

                if (c[i] == b[j]) {
                    c[count] = b[j];
                    count++;
                }
        }

        int[] d = new int[0];
        for (int k = c.length; k > 0; k--) {
            if (c[k - 1] == 0) {
                d = Arrays.copyOf(c, k - 1);
            }
        }
        return d;
    }
}
