package algorithms.sorting.selectionSort;

/*
 * Сортировка выбором разделяет массив на сортированный и несортированный подмассивы. Сортированный подмассив формируется
 * вставкой минимального элемента из неотсортированного подмассива в конец сортированного, заменой
 *
 * Реализация: в каждой итерации предполагается, что первый неотсортированный элемент минимален и итерирование идет по
 * всем оставшимся элементам в поисках меньшего. После нахождения текущего минимального элемента в неотсортированной части
 * массива происходит замена с первым неотсортированным элементом подмассива и он уже входит в отсортированный подмассив
 *
 * Пример: [3,5,1,2,4]
 * шаг 1:  [1,5,3,2,4]
 * шаг 2:  [1,2,3,5,4]
 * шаг 3:  [1,2,3,5,4]
 * шаг 4:  [1,2,3,4,5]
 * шаг 5:  [1,2,3,4,5]
 *
 * Временная сложность: при поиске минимума для длны массива проверяются все элементы, поэтому сложность равно O(n).
 * Поиск минимума для каждого элемента массива равен O(n^2)
 *
 * */

public class SelectionSort {

    private SelectionSort instance;

    private SelectionSort() {

    }

    public SelectionSort getInstance() {
        if (instance == null) {
            instance = new SelectionSort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int mini = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    mini = j;
                }
            }
            swap(array, i, mini);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
