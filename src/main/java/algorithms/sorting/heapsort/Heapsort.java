package algorithms.sorting.heapsort;

/*
* Пирамида или двоичная куча - это дерево, в котором каждый узел состоит в отношениях с дочерними узлами. Добавление нового
* узла начинается с левой позиции нижнего неполного уровня. По мере движения вниз по дереву значения уменьшаются(min-heap)
* или увеличиваются(max-heap)
* Позиция дочернего элемента по отношению к k-му элементу в массиве: 2*k+1 и 2*k+2 (при условии что индекс начинается с 0)
* Для k-го элемента родитель ищется по формуле: (k-1)/2
*
* Пример: [6,1,8,3,5,2,4]
* шаг 1(строим кучу/пирамиду length = 7): [6,1,8,3,5,2,4], i=2
*                                         [6,5,8,3,1,2,4], i=1
*                                         [6,5,8,3,1,2,4], i=4
*                                         [8,5,6,3,1,2,4], i=0
*                                         [8,5,6,3,1,2,4], i=2
* шаг 2(первый элемент переносим в конец):[4,5,6,3,1,2,8]
* шаг 3(строим кучу/пирамиду length = 6): [6,5,4,3,1,2,8], i=0
*                                         [6,5,4,3,1,2,8], i=2
* шаг 4(0-й элемент меняем с 5-м):        [2,5,4,3,1,6,8]
* шаг 5(строим кучу/пирамиду length = 5): [5,2,4,3,1,6,8], i=0
*                                         [5,3,4,2,1,6,8], i=1
* шаг 6(0-й элемент меняем с 4-м):        [1,3,4,2,5,6,8]
* шаг 7(строим кучу/пирамиду length = 4): [4,3,1,2,5,6,8], i=0
*                                         [4,3,1,2,5,6,8], i=2
* шаг 8(0-й элемент меняем с 3-м):        [2,3,1,4,5,6,8]
* шаг 9(строим кучу/пирамиду length = 3): [3,2,1,4,5,6,8], i=0
*                                         [3,2,1,4,5,6,8], i=1
* шаг 10(0-й элемент меняем с 2-м):       [1,2,3,4,5,6,8]
* шаг 11(строим кучу/пирамиду length = 2):[2,1,3,4,5,6,8], i=0
*                                         [2,1,3,4,5,6,8], i=1
* шаг 12(0-й элемент меняем с 1-м):       [1,2,3,4,5,6,8]
* шаг 13(строим кучу/пирамиду length = 1):[1,2,3,4,5,6,8], i=0
* шаг 14(0-й элемент меняем с 0-м):       [1,2,3,4,5,6,8]
*
*Временная сложность: В худшем случае рекурсивный вызов функции heapify() дойдет до самой вершины пирамиды прыжками к
* родителям каждого узла в отношении i/2. Всего потребуется logn шагов до вершины. В связи с циклами for, которые итерируются
* по всему массиву, сложность sort = O(n). Суммарная сложность пирамидальной сортировки: O(nlog n).
* */

public class Heapsort {

    private static Heapsort instance;

    private Heapsort() {
    }

    public static Heapsort getInstance() {
        if (instance == null) {
            instance = new Heapsort();
            return instance;
        } else {
            return instance;
        }
    }

    public void sort(int[] array) {
        if (array.length == 0) {
            return;
        }
        //строим кучу
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        //если левый дочерний больше родителя
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        //если правый дочерний больше родителя
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
