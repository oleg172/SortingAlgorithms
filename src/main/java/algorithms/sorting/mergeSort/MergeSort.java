package algorithms.sorting.mergeSort;


/*
 * Сортировка слиянием использует рекурсию и подход "разделяй и влавствуй".
 *
 * Реализация: массив делится на два подмассива, а заметм происходит:
 *   1) сортировка левой половины массива(рекурсивно)
 *   2)сортировка правой половины массива(рекурсивно)
 *   3)слияние
 *
 * Пример:                          [3,5,4,2,1]
 *                                  [1,2,3,4,5]
 *                         [3,5,4]               [2,1]
 *                         [3,4,5]               [1,2]
 *                  [3,5]           [4]      [1]        [2]
 *                  [3,5]           [4]      [1]        [2]
 *              [3]        [5]
 *              [3]        [5]
 * Временная сложность: для вычисления временной сложности потребуется теорема о рекурентных соотношениях. Временную
 * сложность рекурсивных алгоритмов сортировки можно описать следующих образом:
 *   T(n) = aT(n/b) + cn^k.
 *     n - размер задачи
 *     a - количество подзадач в рекурсии
 *     b - входная величина рекурсивных вызовов
 *     n/b - размер каждой подзадачи
 * По теореме получаем:
 *          O(n^(logb(a)), a>b^k
 *   T(n) = O(n^k*log(n)), a=b^k
 *          O(n^k),        a<b^k
 * T(n) - это время выполнения алгоритма для сортировки массива длиной n, сортировка слиянием запустится дважды для
 * массива длиной вполовину от оригинального. Если a = 2, b=2, то шаг слияния занимает O(n) памяти при k=1. Это означает,
 * что уравнение для сортировки слиянием будет выглядеть:
 *   T(n) = 2T(n/2) + cn
 * a=b^k, так как 2=2^1.
 * Значит сложность равна O(nlogn).
 * */
public class MergeSort {

    private static MergeSort instance;

    private MergeSort() {
    }

    public static MergeSort getInstance() {
        if (instance == null) {
            instance = new MergeSort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        //вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        //создаем временные подмассивы
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        //копируем отсортированные подмассивы во временные
        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[mid + i + 1];
        }

        //итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        //копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются неотсортированные элемнеты в leftArray и в rightArray, копируется минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            //если все элементы были скопированы из rightArray, осталось скопировать leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            //если все элементы были скопированы из leftArray, осталось скопировать rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

}
