package collection;

import org.example.task_1.collection.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MyArrayListTest {
    MyArrayList<String> list;
    @BeforeEach
    public void initialize() {
        list = new MyArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }
    @Test
    @DisplayName("MyArrayList size() test")
    public void sizeTest() {
        Assertions.assertEquals(list.size(), 3);
    }
    @Test
    @DisplayName("MyArrayList add() test")
    public void addTest() {
        boolean isAdded = list.add("fourth");

        Assertions.assertTrue(isAdded);
        Assertions.assertEquals(list.size(), 4);
    }
    @Test
    @DisplayName("MyArrayList remove() test")
    public void removeTest() {
        Assertions.assertEquals(list.size(), 3);

        list.remove("first");

        Assertions.assertNotEquals(list.size(), 3);
        Assertions.assertEquals(list.size(), 2);
    }
    @Test
    @DisplayName("MyArrayList get() test")
    public void getTest() {
        String getFirst = list.get(0);
        String getSecond = list.get(1);
        String getThird  = list.get(2);

        Assertions.assertEquals(getFirst, "first");
        Assertions.assertEquals(getSecond, "second");
        Assertions.assertEquals(getThird, "third");
    }

    @Test
    @DisplayName("MyArrayList set() test")
    public void setTest() {
        Assertions.assertEquals(list.get(0), "first");

        list.set(0, "fourth");

        Assertions.assertNotEquals(list.get(0), "first");
        Assertions.assertEquals(list.get(0), "fourth");
    }
    @Test
    @DisplayName("MyArrayList contains() test")
    public void containsTest() {
        Assertions.assertTrue(list.contains("first"));
        Assertions.assertTrue(list.contains("second"));
        Assertions.assertTrue(list.contains("third"));
        Assertions.assertFalse(list.contains("fourth"));
    }
    @Test
    @DisplayName("MyArrayList clear() test")
    public void clearTest() {
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertTrue(list.contains("first"));
        Assertions.assertTrue(list.contains("second"));
        Assertions.assertTrue(list.contains("third"));

        list.clear();

        Assertions.assertEquals(list.size(), 0);
        Assertions.assertFalse(list.contains("first"));
        Assertions.assertFalse(list.contains("second"));
        Assertions.assertFalse(list.contains("third"));
    }
}
