package org.example;

import org.example.task_1.collection.CustomList;
import org.example.task_1.collection.MyArrayList;


public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new MyArrayList<>();
        list.add("first");
        list.add("second");
        System.out.println(list);
        list.add(0, "test");
        System.out.println(list);

    }
}