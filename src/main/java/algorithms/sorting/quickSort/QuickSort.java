package algorithms.sorting.quickSort;

/*
 * Быстрая сортировка выбирает один элемент массива в качестве опорного и сортирует остальные элементы вокруг него
 * (меньшие элементы налево, большие направо).
 *
 * Алгоритм:
 *   1) выбрать из массива элемент, называемый опорным. Это может быть любой из элементов массива. От выбора опорного
 *      элемента не зависит корректность алгоритма, но в отдельных случаях может зависить его эффективность.
 *   2) сравнить все остальные элементы с опорным и переставить их в массиве так, чтобы разбить массив на три
 *      непрерывных отрезка, следующих друг за другом: меньшие, равные, больше
 *   3) для отрезков меньших и больших значений выполнить рекурсивно ту же последовательность операций, если длина
 *     отрезка больше единицы
 *
 * Временная сложность:
 *
 * */

public class QuickSort {

    private static QuickSort instance;

    private QuickSort() {

    }

    public static QuickSort getInstance() {
        if (instance == null) {
            instance = new QuickSort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array, int begin, int end) {
        int leftMarker = begin;
        int rightMarker = end;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    swap(array, leftMarker, rightMarker);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < end) {
            sort(array, leftMarker, end);
        }
        if (rightMarker > begin) {
            sort(array, begin, rightMarker);
        }

    }


    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
