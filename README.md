# Алгоритмы сортировки:
 ## 1. Сортировка пузырьком:
 ### Реализаиця:
 Алгоритм просматривает массив и сравнивает каждую пару соседних элементов. Когда он встречает пару элементов, расположенных не по порядку,
 происходит замена двух элементов местами. Все элементы упорядочены в том случае, когда очередная итерация пройдет без замены
 соседних элементов.
 ### Пример: [4,2,1,5,3]
 
  шаг 1: 
  
         [2,4,1,5,3], i=0
         [2,1,4,5,3], i=1
         [2,1,4,5,3], i=2
         [2,1,4,3,5], i=3
         
  шаг 2: 
  
         [1,2,4,3,5], i=0
         [1,2,4,3,5], i=1
         [1,2,3,4,5], i=2
         [1,2,3,4,5], i=3
         
  Результат сортировки: [1,2,3,4,5]        
### Временная сложность:
 В наихудшем случае, когда массив отсортирован в обратном порядке - для каждого элемента нужно по n пераций + цикл while минимум
 будет запускаться 5 раз. В наихудшем случае временная сложность равно O(n^2)
 
## 2. Сортировка вставками

Этот алгоритм разделяет оригинальный массив на сортированный и неотсортированный подмассивы.
### Реализация:
Длина сортированной части равна 1 в начале и соответсвует первому элементу в массиве. После этого остается итерировать массив и расширять отсортированную часть одним элементом с каждой новой итерацией.
### Пример: [3,2,4,1]

шаг 1(i=1):

        [2,3,4,1]

шаг 2(i=2):  

        [2,3,4,1]
        
шаг 3(i=3):  

        [2,3,1,4]
        [2,1,3,4]
        [1,2,3,4]
        
Результат сортировки: [1,2,3,4]        
### Временная сложность:
Если рассматривать худший вариант - отсортированный массив в убывающем порядке, тогда в каждом случае каждая итерация сдвигает отсортированный массив на единицу и сложность этого равна O(n). Придется делать это для каждого элемента в каждом массиве, что приведет к результирующей сложности O(n^2).

## 3. Сортировка выбором
Сортировка выбором разделяет массив на сортированный и несортированный подмассивы. Сортированный подмассив формируется вставкой минимального элемента из неотсортированного подмассива в конец сортированного, заменой.
### Реализация:
При первой итерации длина отсортированная части равно 0, а длина неотсортированной части равна длине массива. В каждой итерации предполагается, что первый неотсортированный элемент минимален и итерирование идет по всем оставшимся элементам в поисках меньшего. После нахождения текущего минимального элемента в неотсортированной части массива происходит его замена с ппервым неотсортированным элементом подмассива и он уже входит в отсортированный подмассив.
### Пример: [3,5,1,2,4]

шаг 1(i=0):

         [1,5,3,2,4]

шаг 2(i=1):
  
        [1,2,3,5,4]

шаг 3(i=2):
     
        [1,2,3,5,4]

шаг 4(i=3):

        [1,2,3,4,5]
        
шаг 5(i=4):

        [1,2,3,4,5]
        
Результат сортировки: [1,2,3,4,5]
### Временная сложность:
При поиске минимума проверяются все элементы массива, поэтому сложность равно O(n). Поиск минимума для каждого элемента массива равен O(n^2).

## 4. Сортировка слиянием:
Сортировка слиянием использует рекурсию и подход "разделяй и влавствуй".
### Реализация:
Массив делится на два подмассива, а заметм происходит:
 1) Сортировка левой половины массива(рекурсивно);
 2) Сортировка правой половины массива(рекурсивно);
 3) Слияние.
### Пример: [3,5,4,2,1]

                           [3,5,4,2,1]
                           [1,2,3,4,5]
                [3,5,4]                   [2,1]
                [3,4,5]                   [1,2]
         [3,5]           [4]          [2]       [1]
         [3,5]           [4]          [2]       [1]
      [3]     [5]        
      [3]     [5]
      
Результат сортировки: [1,2,3,4,5]
### Временная сложность:
Для вычисления временной сложности потребуется теорема о рекурентных соотношениях. Временную сложность рекурсивных алгоритмов сортировки можно описать следующих образом:

  T(n) = aT(n/b) + cn^k.
    n - размер задачи
    a - количество подзадач в рекурсии
    b - входная величина рекурсивных вызовов
    n/b - размер каждой подзадачи
    
По теореме получаем:
       O(n^(logb(a)), a>b^k
T(n) = O(n^k*log(n)), a=b^k
       O(n^k),        a<b^k
T(n) - это время выполнения алгоритма для сортировки массива длиной n, сортировка слиянием запустится дважды для массива длиной вполовину от оригинального. Если a = 2, b=2, то шаг слияния занимает O(n) памяти при k=1. Это означает, что уравнение для сортировки слиянием будет выглядеть:
  T(n) = 2T(n/2) + cn
    a=b^k, так как 2=2^1.
Значит сложность равна O(nlogn).

## 5. Пирамидальная сортировка:
Пирамида или двоичная куча - это дерево, в котором каждый узел состоит в отношениях с дочерними узлами. Добавление нового узла начинается с левой позиции нижнего неполного уровня. По мере движения вниз по дереву значения уменьшаются(min-heap) или увеличиваются(max-heap). Позиция дочернего элемента по отношению к k-му элементу в массиве: 2*k+1 и 2*k+2 (при условии что индекс начинается с 0). Для k-го элемента родитель ищется по формуле: (k-1)/2.
### Пример: [6,1,8,3,5,2,4]

шаг 1(строим кучу/пирамиду length = 7):

               [6,1,8,3,5,2,4], i=2
               [6,5,8,3,1,2,4], i=1
               [6,5,8,3,1,2,4], i=4
               [8,5,6,3,1,2,4], i=0
               [8,5,6,3,1,2,4], i=2

шаг 2(первый элемент переносим в конец):

               [4,5,6,3,1,2,8]
               
шаг 3(строим кучу/пирамиду length = 6): 

               [6,5,4,3,1,2,8], i=0
               [6,5,4,3,1,2,8], i=2
               
шаг 4(0-й элемент меняем с 5-м):        
 
                [2,5,4,3,1,6,8]

шаг 5(строим кучу/пирамиду length = 5):

                [5,2,4,3,1,6,8], i=0
                [5,3,4,2,1,6,8], i=1

шаг 6(0-й элемент меняем с 4-м):    
        
                [1,3,4,2,5,6,8]
                
шаг 7(строим кучу/пирамиду length = 4):

                [4,3,1,2,5,6,8], i=0
                [4,3,1,2,5,6,8], i=2

шаг 8(0-й элемент меняем с 3-м): 

                [2,3,1,4,5,6,8]

шаг 9(строим кучу/пирамиду length = 3): 

                [3,2,1,4,5,6,8], i=0
                [3,2,1,4,5,6,8], i=1
                
шаг 10(0-й элемент меняем с 2-м):

                [1,2,3,4,5,6,8]

шаг 11(строим кучу/пирамиду length = 2):

                [2,1,3,4,5,6,8], i=0
                [2,1,3,4,5,6,8], i=1
                
шаг 12(0-й элемент меняем с 1-м):

                [1,2,3,4,5,6,8]

шаг 13(строим кучу/пирамиду length = 1):

                [1,2,3,4,5,6,8], i=0

шаг 14(0-й элемент меняем с 0-м):

                [1,2,3,4,5,6,8]
                
Результат сортировки: [1,2,3,4,5,6,8]
### Временная сложность:
В худшем случае рекурсивный вызов функции heapify() дойдет до самой вершины пирамиды прыжками к родителям каждого узла в отношении i/2. Всего потребуется logn шагов до вершины. В связи с циклами for, которые итерируются по всему массиву, сложность sort = O(n). Суммарная сложность пирамидальной сортировки: O(nlog n).

## 6. Быстрая сортировка
Быстрая сортировка выбирает один элемент массива в качестве опорного и сортирует остальные элементы вокруг него(меньшие элементы налево, большие направо).
### Алгоритм:
  1) Выбрать из массива элемент, называемый опорным. Это может быть любой из элементов массива. От выбора опорного элемента не зависит корректность алгоритма, но в отдельных случаях может зависить его эффективность;
  2) Сравнить все остальные элементы с опорным и переставить их в массиве так, чтобы разбить массив на три непрерывных отрезка, следующих друг за другом: меньшие, равные, больше;
  3) Для отрезков меньших и больших значений выполнить рекурсивно ту же последовательность операций, если длина отрезка больше единицы.
