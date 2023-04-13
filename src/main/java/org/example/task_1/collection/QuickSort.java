package org.example.task_1.collection;

/** This class implements a quick sort algorithm */
public class QuickSort<T extends Comparable<T>> {
    /** a method implementing a quick sort algorithm
     * @param <T> takes CustomList as an argument
     * @param from index in the collection from which sorting begins
     * @param to the index in the collection to which sorting takes place */
    public static <T extends Comparable<T>> void quickSort(CustomList<T> list, int from, int to) {
        if (from < to) {
            int leftIndex = from, rightIndex = to;
            T pivot = list.get((leftIndex + rightIndex) / 2);

            do {
                while (list.get(leftIndex).compareTo(pivot) < 0) leftIndex++;
                while (pivot.compareTo(list.get(rightIndex)) < 0) rightIndex--;
                if (leftIndex <= rightIndex) {
                    swap(list, leftIndex, rightIndex);
                    leftIndex++;
                    rightIndex--;
                }
            } while (leftIndex <= rightIndex);

            quickSort(list, from, rightIndex);
            quickSort(list, leftIndex, to);
        }
    }
    private static<T extends Comparable<T>> void swap(CustomList<T> list, int a, int b ) {
        T tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }


}
