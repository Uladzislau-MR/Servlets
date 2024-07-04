package com.vladislav.homework.task_1;

import java.util.Comparator;

/**
 * A doubly linked list implementation of the CustomList interface.
 *
 * @param <E> the type of elements held in this list
 */
public class CustomLinkedList<E> implements CustomList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                  ({@code index < 0 || index > size})
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to list size equal to " + size);
        }

        Node<E> newNode = new Node<>(element);

        if (index == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<E> current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                  ({@code index < 0 || index >= size})
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to list size equal to " + size);
        }

        Node<E> current = getNode(index);
        current.data = element;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                  ({@code index < 0 || index >= size})
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to list size equal to " + size);
        }

        Node<E> current = getNode(index);
        return current.data;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                  ({@code index < 0 || index >= size})
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " cannot be used due to list size equal to " + size);
        }

        Node<E> toRemove = getNode(index);

        if (toRemove == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (toRemove == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
        }

        size--;
        return toRemove.data;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     *
     * @param element element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object element) {
        Node<E> current = head;

        while (current != null) {
            if ((element == null && current.data == null) || (element != null && element.equals(current.data))) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(E element) {
        Node<E> current = head;

        while (current != null) {
            if ((element == null && current.data == null) || (element != null && element.equals(current.data))) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Node class representing each element in the linked list.
     *
     * @param <E> the type of elements held in this node
     */
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        /**
         * Constructs a new node with the specified data.
         *
         * @param data the data to be stored in this node
         */
        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Returns the node at the specified index.
     *
     * @param index the index of the node to return
     * @return the node at the specified index
     */
    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    @Override
    public void sort() {
        /**
         * Sorts the elements of this linked list according to their natural order.
         * If the elements are null, they are considered greater than non-null elements.
         */
        Comparator<E> comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return 1;
                if (o2 == null) return -1;
                return ((Comparable<E>) o1).compareTo(o2);
            }
        };


        head = mergeSort(head, comparator);

        // Update the tail reference after sorting
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    /**
     * Recursively sorts a linked list using merge sort.
     *
     * @param head       the head of the linked list to sort
     * @param comparator the comparator to use for comparing elements
     * @return the sorted linked list
     */
    private Node<E> mergeSort(Node<E> head, Comparator<E> comparator) {
        if (head == null || head.next == null) {
            return head;
        }


        Node<E> middle = getMiddle(head);
        Node<E> nextOfMiddle = middle.next;
        middle.next = null;


        Node<E> left = mergeSort(head, comparator);
        Node<E> right = mergeSort(nextOfMiddle, comparator);


        return sortedMerge(left, right, comparator);
    }

    /**
     * Merges two sorted linked lists into a single sorted list.
     *
     * @param a          the first sorted linked list
     * @param b          the second sorted linked list
     * @param comparator the comparator to use for comparing elements
     * @return the merged sorted linked list
     */
    private Node<E> sortedMerge(Node<E> a, Node<E> b, Comparator<E> comparator) {
        if (a == null) return b;
        if (b == null) return a;

        Node<E> result;
        if (comparator.compare(a.data, b.data) <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b, comparator);
            result.next.prev = result;
            result.prev = null;
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, comparator);
            result.next.prev = result;
            result.prev = null;
        }
        return result;
    }

    /**
     * Finds the middle of the linked list.
     *
     * @param head the head of the linked list
     * @return the middle node of the linked list
     */
    private Node<E> getMiddle(Node<E> head) {
        if (head == null) {
            return head;
        }
        Node<E> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }





}
