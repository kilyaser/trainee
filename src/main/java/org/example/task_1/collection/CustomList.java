package org.example.task_1.collection;

/** This interface defines the main methods of data manipulation for implementation in its own collection */
public interface CustomList<E> extends Iterable<E> {

    /** checks for the presence of items in the collection */
    boolean isEmpty();

    /** @return the size of the collection */
    int size();

    /** adds an element to the end of the collection in if the operation was successful
     *  @return true otherwise false */
    boolean add(E e);

    /** adds an element to the specified location of the collection according to the index value in if the operation was successful
     *  @return true otherwise false */
    boolean add(int index, E e);

    /** removes the first found item from the collection by value */
    void remove(E e);

    /** @return an item from the collection by index */
    E get(int index);

    /** replaces an item in the collection by index */
    void set(int index, E e);

    /** checks for the presence of an element in the collection,
     * @return true if there is an element, otherwise false */
    boolean contains(E e);

    /** deletes all items in the collection */
    void clear();

    /** @return the elements of the collection as an array */
    E[] toArray();
}
