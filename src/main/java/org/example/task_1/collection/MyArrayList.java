package org.example.task_1.collection;

import java.util.Arrays;
import java.util.Iterator;

/** This list implements the Custom List interface and provides the implementation of the main methods for data manipulation.
 * List is an ordered collection of data and supports the ability to store identical items */
public class MyArrayList<E> implements CustomList<E> {
    private E[] elements;
    private int size;

    /** a list constructor with a single argument defining the size of the list
     * @param initialSize defines the initial size of the list */
    public MyArrayList(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("size must be bigger then: " + initialSize);
        }
        this.elements =(E[]) new Object[initialSize];
    }

    /** a list constructor without any arguments */
    public MyArrayList() {
        this.elements =(E[]) new Object[10];
    }

    /** checks for the presence of elements in the list,
     * @return true if there are elements */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /** @return the size of the elements in the list*/
    @Override
    public int size() {
        return this.size;
    }
    private void checkCapacity(int requiringCapacity) {
        if (requiringCapacity > elements.length) {
            Object[] oldElements = this.elements;
            int newSize = this.size * 2 + 1;
            this.elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    /** adds an element to the list */
    @Override
    public boolean add(E e) {
        checkCapacity(this.size + 1);
        elements[this.size++] = e;
        return true;
    }

    /** adds an element to the list according to the specified index */
    @Override
    public boolean add(int index, E e) {
        if (index < 0 || index > (this.size + 1)) throw new IllegalArgumentException();
        checkCapacity(this.size + 1);
        System.arraycopy(this.elements, index, elements, index + 1, size - index);
        elements[index] = e;
        this.size++;
        return true;
    }

    /** deletes the first found item in the list */
    @Override
    public void remove(E e) {
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.elements[i])) {
                fastRemove(i);
            }
        }
    }

    private void fastRemove(int index) {
        int numberToRemove = this.size - index - 1;
        if (numberToRemove > 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, numberToRemove);
        }
        this.elements[--this.size] = null;
    }

    /** @return an element from the list according to the index value */
    @Override
    public E get(int index) {
        if (index < 0 || index > (this.size + 1)) throw new IllegalArgumentException();
        return this.elements[index];
    }

    /** replaces an element in the list according to the index value */
    @Override
    public void set(int index, E e) {
        if (index < 0 || index > (this.size + 1)) throw new IllegalArgumentException();
        checkCapacity(this.size + 1);
        this.elements[index] = e;
    }

    /** checks for the presence of an element in the list and
     *  @return true if there is an element */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size(); i++) {
            if (this.elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /** deletes all items in the list */
    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    /** @return an array of items in the list */
    @Override
    public E[] toArray() {
        return this.elements;
    }

    /** @return the iterator of this list */
    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<>();
    }

    /** Returns a string of sheet elements */
    @Override
    public String toString() {
        if (size == 0)
            return "null";

        int iMax = this.size - 1;
        if (iMax == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(elements[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    /** This class implements the iterator interface for sequential traversal of all elements of the collection */
    public class CustomIterator<E> implements Iterator<E> {
        private int current = 0;

        /** checks for the presence of the next element in the collection
         *  @return true if present */
        @Override
        public boolean hasNext() {
            return this.current < size();
        }

        /** @return the next element of the collection. */
        @Override
        public E next() {
            E value = (E) elements[current++];
            return value;
        }
    }


}
