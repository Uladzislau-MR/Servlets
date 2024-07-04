package com.vladislav.homework.task_1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A custom implementation of an ArrayList.
 *
 * @param <E> the type of elements held in this list
 */
public class CustomArrayList<E> implements CustomList<E> {
    private Object[] elements = new Object[10];
    private int elementIndex = 0;

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added
     */
    @Override
    public void add(E element) {
        if (elements.length <= elementIndex) {
            Object[] tempArray = elements.clone();
            elements = new Object[tempArray.length + 5];
            System.arraycopy(tempArray, 0, elements, 0, tempArray.length);
        }
        elements[elementIndex] = element;
        elementIndex++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > elements.length)
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > elementIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to array size equal to " + elements.length);
        } else if (elements[index] == null) {
            elements[index] = element;
        } else {
            Object[] tempArray = elements.clone();
            elements = new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, elements, 0, index);
            System.arraycopy(tempArray, index, elements, index + 1, tempArray.length - index);
            elements[index] = element;
        }
        elementIndex++;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= elements.length)
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= elementIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to array size equal to " + elements.length);
        } else {
            elements[index] = element;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= elements.length)
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= elementIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to array size equal to " + elements.length);
        } else {
            return (E) elements[index];
        }
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= elements.length)
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= elementIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to array size equal to " + elements.length);
        }
        E removedElement = (E) elements[index];
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[elements.length - 1] = null;
        elementIndex--;
        return removedElement;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param element element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object element) {
        for (int i = 0; i < elements.length; i++) {
            if ((elements[i] == null && element == null) || (elements[i] != null && elements[i].equals(element))) {
                for (int j = i; j < elements.length - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[elements.length - 1] = null;
                elementIndex--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return elementIndex;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        for (Object o : elements) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        elements = new Object[10];
        elementIndex = 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < elements.length; i++) {
            if ((elements[i] == null && element == null) || (elements[i] != null && elements[i].equals(element))) {
                return true;
            }
        }
        return false;
    }
    /**
     * Sorts the elements in this list according to their natural order.
     * The natural order is determined by the {@link Comparable} interface implemented by the elements.
     * If an element is null, it is considered greater than any non-null element.
     *
     * <p>
     * This method sorts the elements using the QuickSort algorithm as implemented by {@link Arrays#sort(Object[], int, int, Comparator)}.
     * </p>
     *
     * @throws ClassCastException if any element in this list does not implement {@link Comparable}
     */
    @Override
    public void sort() {

        Comparator<E> comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return 1;
                if (o2 == null) return -1;
                return ((Comparable<E>) o1).compareTo(o2);
            }
        };


        Arrays.sort((E[]) elements, 0, elementIndex, comparator);
    }

}

