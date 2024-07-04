package com.vladislav.homework.task_1;

import java.util.Comparator;

/**
 * A custom list interface that defines basic operations for a list data structure.
 *
 * @param <E> the type of elements held in this list
 */
interface CustomList<E> {

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added
     */
    void add(E element);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void add(int index, E element);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    void set(int index, E element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    E get(int index);

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param element element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    boolean remove(Object element);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    void clear();

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    boolean contains(E element);

    void sort();

}
