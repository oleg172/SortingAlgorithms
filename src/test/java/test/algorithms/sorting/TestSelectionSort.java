package test.algorithms.sorting;

import algorithms.sorting.selectionSort.SelectionSort;
import org.junit.Assert;
import org.junit.Test;
import test.utils.TestUtills;

public class TestSelectionSort {

    @Test
    public void testRandomArray(){
        int size = 100_000;
        int[] array = TestUtills.generateArray(size);
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);
        TestUtills.sortArray(sortedArray);

        long startTime = System.nanoTime();
        SelectionSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения cортировки выбором произвольного массива длиины = " + size + " равна " + duration / 1_000_000 + " ms");

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
        SelectionSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения cортировки выбором сортированного массива длиины = " + size + " равна " + duration / 1_000_000 + " ms");

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
        SelectionSort.getInstance().sort(array);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Время выполнения cортировки выбором массива отсортированного в обратном порядке длиины = " + size + " равна " + duration / 1_000_000 + " ms");

        Assert.assertArrayEquals(array, sortedArray);
    }
}
