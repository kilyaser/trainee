package collection;

import org.example.task_1.collection.CustomList;
import org.example.task_1.collection.MyArrayList;
import org.example.task_1.collection.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class QuickSortTest {
    CustomList<Integer> integers;
    CustomList<String> strings;
    @BeforeEach
    public void initialize() {
        integers = new MyArrayList<>();
        integers.add(12);
        integers.add(5);
        integers.add(7);
        integers.add(-1);

        strings = new MyArrayList<>();
        strings.add("bowl");
        strings.add("all");
        strings.add("second");
    }
    @Test
    public void quickSortTest() {
        QuickSort.quickSort(integers, 0, integers.size() - 1);
        QuickSort.quickSort(strings, 0, strings.size() - 1);

        Assertions.assertEquals(-1, integers.get(0));
        Assertions.assertEquals(5, integers.get(1));
        Assertions.assertEquals(7, integers.get(2));
        Assertions.assertEquals(12, integers.get(integers.size() - 1));

        Assertions.assertEquals("all", strings.get(0));
        Assertions.assertEquals("bowl", strings.get(1));
        Assertions.assertEquals("second", strings.get(strings.size() - 1));
    }
}
