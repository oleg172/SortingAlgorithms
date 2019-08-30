package algorithms.sorting.bubbleSort;

/*
 * Сортировка пузырьком.
 * Реализаиця: алгоритм просматривает массив и сравнивает каждую пару соседних элементов. Когда он встречает пару
 * элементов, расположенных не по порядку, происходит замена двух элементов местами. Все элементы упорядочены в том
 * случае, когда очередная итерация пройдет без замены соседних элементов.
 *
 * Пример: [4,2,1,5,3]
 * шаг 1: [2,4,1,5,3]
 *        [2,1,4,5,3]
 *        [2,1,4,5,3]
 *        [2,1,4,3,5]
 * шаг 2: [1,2,4,3,5]
 *        [1,2,4,3,5]
 *        [1,2,3,4,5]
 *        [1,2,3,4,5]
 *
 * Временная сложность: в наихудшем случае, когда массив отсортирован в обратном порядке - для каждого элемента нужно
 * по n пераций + цикл while минимум будет запускаться 5 раз. В наихудшем случае временная сложность равно O(n^2)
 * */

public class BubbleSort {

    private static BubbleSort instance;

    private BubbleSort() {

    }

    public static BubbleSort getInstance() {
        if (instance == null) {
            instance = new BubbleSort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array) {

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


}
