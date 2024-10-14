package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Custom implementation of a Set for managing {@link Tariff} objects using a doubly linked list.
 * This class implements all the required methods from the {@link Set} interface.
 */
public class TariffSet implements Set<Tariff> {

    /**
     * Reference to the first node in the doubly linked list.
     */
    private Node head;

    /**
     * Reference to the last node in the doubly linked list.
     */
    private Node tail;

    /**
     * The number of elements in the set.
     */
    private int size;

    /**
     * Internal class representing a node in the doubly linked list.
     */
    private static class Node {
        /**
         * The {@link Tariff} object contained in this node.
         */
        Tariff tariff;

        /**
         * Reference to the previous node.
         */
        Node prev;

        /**
         * Reference to the next node.
         */
        Node next;

        /**
         * Constructor to create a node with a given {@link Tariff}.
         *
         * @param tariff the tariff to store in this node
         */
        Node(Tariff tariff) {
            this.tariff = tariff;
        }
    }

    /**
     * Default constructor that initializes an empty {@link TariffSet}.
     */
    public TariffSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructor that initializes the {@link TariffSet} with a single {@link Tariff}.
     *
     * @param tariff the initial {@link Tariff} to add to the set
     */
    public TariffSet(Tariff tariff) {
        this();
        add(tariff);
    }

    /**
     * Constructor that initializes the {@link TariffSet} with a collection of tariffs.
     *
     * @param tariffs a collection of {@link Tariff} objects to add to the set
     */
    public TariffSet(Collection<? extends Tariff> tariffs) {
        this();
        addAll(tariffs);
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if the set contains no elements.
     *
     * @return {@code true} if the set is empty, otherwise {@code false}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the set contains the specified element.
     *
     * @param o the object to check for containment
     * @return {@code true} if the set contains the specified object, otherwise {@code false}
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Tariff tariff))
            return false;

        Node current = head;
        while (current != null) {
            if (current.tariff.equals(tariff))
                return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<Tariff> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Tariff next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                Tariff tariff = current.tariff;
                current = current.next;
                return tariff;
            }
        };
    }

    /**
     * Returns an array containing all the elements in this set.
     *
     * @return an array containing all the elements in this set
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.tariff;
            current = current.next;
        }
        return array;
    }

    /**
     * Returns an array containing all the elements in this set; the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose
     * @return an array containing all the elements in this set
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) java.util.Arrays.copyOf(toArray(), size, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Adds the specified {@link Tariff} to this set if it is not already present.
     *
     * @param tariff the tariff to be added
     * @return {@code true} if the set has not already contained the specified tariff, {@code false} otherwise
     */
    @Override
    public boolean add(Tariff tariff) {
        if (contains(tariff))
            return false;

        Node newNode = new Node(tariff);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the specified object from this set, if it is present.
     *
     * @param o the object to be removed
     * @return {@code true} if the set contained the specified object, {@code false} otherwise
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Tariff tariff))
            return false;

        Node current = head;
        while (current != null) {
            if (current.tariff.equals(tariff)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Removes the specified node from the linked list.
     *
     * @param node the node to be removed
     */
    private void unlink(Node node) {
        if (node.prev == null)
            head = node.next;
        else
            node.prev.next = node.next;

        if (node.next == null)
            tail = node.prev;
        else
            node.next.prev = node.prev;

        size--;
    }

    /**
     * Returns {@code true} if this set contains all the elements in the specified collection.
     *
     * @param c the collection to be checked for containment in this set
     * @return {@code true} if this set contains all the elements in the specified collection, {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    /**
     * Adds all the elements in the specified collection to this set if they're not already present.
     *
     * @param c the collection containing elements to be added to this set
     * @return {@code true} if this set changed as a result of the call, {@code false} otherwise
     */
    @Override
    public boolean addAll(Collection<? extends Tariff> c) {
        boolean modified = false;
        for (Tariff tariff : c) {
            if (add(tariff))
                modified = true;
        }
        return modified;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c the collection containing elements to be retained in this set
     * @return {@code true} if this set changed as a result of the call, {@code false} otherwise
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (!c.contains(current.tariff)) {
                unlink(current);
                modified = true;
            }
            current = next;
        }
        return modified;
    }

    /**
     * Removes from this set all of its elements that are contained in the specified collection.
     *
     * @param c the collection containing elements to be removed from this set
     * @return {@code true} if this set changed as a result of the call, {@code false} otherwise
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o))
                modified = true;
        }
        return modified;
    }

    /**
     * Removes all the elements from this set. The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
}
