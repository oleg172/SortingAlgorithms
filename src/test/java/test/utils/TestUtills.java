package test.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class TestUtills {

    public static int[] generateArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static int[] generateArray(int size, int min, int max) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static int[] reverseSort(int[] array) {

        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
