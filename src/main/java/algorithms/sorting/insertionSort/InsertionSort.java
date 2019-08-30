package algorithms.sorting.insertionSort;

/*
 * Этот алгоритм разделяет оригинальный массив на сортированный и неотсортированный подмассивы.
 *
 * Реализация: длина сортированной части равна 1 в начале и соответсвует первому элементу в массиве. После этого
 * остается итерировать массив и расширять отсортированную часть массива одним элементом с каждой новой итерацией.
 *
 * Пример: [3,2,4,1]:
 * шаг 1: [2,3,4,1]
 * шаг 2: [2,3,4,1]
 * шаг 3: [2,3,1,4]
 *        [2,x,3,4]
 *        [1,2,3,4]
 *
 * Временная сложность: если рассматривать худший вариант - отсортированный массив в убывающем порядке, тогда в каждом
 * случае каждая итерация сдвигает отсортированный массив на единицу O(n). Придется делать это для каждого элемента в
 * каждом массиве, что приведет к сложности O(n^2).
 * */

public class InsertionSort {

    private static InsertionSort instance;

    private InsertionSort() {

    }

    public static InsertionSort getInstance() {
        if (instance == null) {
            instance = new InsertionSort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
