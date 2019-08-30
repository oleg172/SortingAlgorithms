package test.algorithms.sorting;

import algorithms.sorting.bubbleSort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;
import test.utils.TestUtills;

public class TestBubbleSort {

    @Test
    public void testRandomArray(){
        int size = 100_000;
        int[] array = TestUtills.generateArray(size);
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
        TestUtills.sortArray(sortedArray);

        long startTime = System.nanoTime();
        BubbleSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения сортировки пузырьком произвольного массива длиины = " + size + " равна " + duration / 1_000_000 + " ms");

        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testSortSortedArray(){
        int size = 100_000;
        int[] array = TestUtills.generateArray(size);
        TestUtills.sortArray(array);
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        long startTime = System.nanoTime();
        BubbleSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения сортировки пузырьком сортированного массива длиины = " + size + " равна " + duration / 1_000_000 + " ms");

        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testSortReverseArray() {

        int size = 100_000;
        int[] array = TestUtills.generateArray(size);
        array = TestUtills.reverseSort(array);
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
        TestUtills.sortArray(sortedArray);

        long startTime = System.nanoTime();
        BubbleSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения сортировки пузырьком массива отсортированного в обратном порядке длиины = " + size + " равна " + duration / 1_000_000 + " ms");

        Assert.assertArrayEquals(array, sortedArray);
    }
}
