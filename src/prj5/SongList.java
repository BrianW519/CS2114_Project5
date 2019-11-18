package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description
 *
 * @author Brian Wood brianwood
 * @author Dave
 * @author David
 * @version Nov 13, 2019
 */
public class SongList<T extends Comparable<T>> implements Iterable<T> {
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new SongListIterator<T>();
    }


    /**
     * This represents a node in a doubly linked list
     *
     * @param <T>
     *            the type of object that this class will store
     */
    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T data;


        /**
         * Creates a new node with the provided data
         * 
         * @param dataOfNode
         *            the data to be place in the node
         */
        public Node(T dataOfNode) {
            data = dataOfNode;
        }


        /**
         * sets the next node
         * 
         * @param nextNode
         *            the node after this one
         */
        public void setNext(Node<T> nextNode) {
            next = nextNode;
        }


        /**
         * Sets the previous node
         * 
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<T> previousNode) {
            previous = previousNode;
        }


        /**
         * fetches the next node
         * 
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }


        /**
         * fetches the previous node
         * 
         * @return the node previous
         */
        public Node<T> previous() {
            return previous;
        }


        /**
         * Gets the data in this node
         * 
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
    }

    private int size;
    /**
     * is a sentinel node and thus null
     */
    private Node<T> head;
    /**
     * is a sentinel node and thus null
     */
    private Node<T> tail;


    /**
     * Create a new SongList object.
     */
    public SongList() {
        head = new SongList.Node<T>(null);
        tail = new SongList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * checks if the linked list size is zero
     * 
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the linked list
     * 
     * @return the number of elements
     */
    public int getSize() {
        return size;
    }


    /**
     * clears all values in the list
     */
    public void clear() {
        head = new SongList.Node<T>(null);
        tail = new SongList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     */
    public T getEntry(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param frontNode
     *            the element to add to the end
     */
    public void add(T frontNode) {
        add(getSize(), frontNode);
    }


    /**
     * Adds the object to a given position in the list
     *
     * @param index
     *            where the node will be inserted
     * @param obj
     *            the object to be added
     */
    public void add(int index, T obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("object can not be null");
        }
        Node<T> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<T> addition = new Node<T>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || getSize() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> current = head.next();
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * removes the node at that index
     *
     * @param index
     *            where the object is
     * @return true if successful
     */
    public boolean remove(int index) {
        Node<T> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that equals
     * the object inputed
     *
     * @param anEntry
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(T anEntry) {
        Node<T> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(anEntry)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list
     * 
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (!isEmpty()) {
            Node<T> currNode = head.next();
            while (currNode != tail) {
                T element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("]");
        return builder.toString();
    }

    /**
     * sorts the song list
     */
    public void insertionSort() {
        Node<T> current = head.next.next;
        while (current != null) {
            if (current.previous.data != null && current.data != null) {
                int compair = current.getData().compareTo(current.previous
                    .getData());
                while (compair < 0) {
                    T data = current.data;
                    Node<T> insertNode = new Node<T>(data);
                    insertNode.next = current.previous;
                    insertNode.previous = current.previous.previous;
                    current.previous.previous.next = insertNode;
                    current.previous.previous = insertNode;
                    current.previous().setNext(current.next());
                    current.next().setPrevious(current.previous());
                    current = insertNode;
                    if (current.previous.data != null && current.data != null) {
                        compair = current.getData().compareTo(current.previous
                            .getData());
                    }
                    else {
                        compair = 0;
                    }
                }
            }
            current = current.next;
        }
    }


    private class SongListIterator<T> implements Iterator<T> {
        private Node<T> current;
        private boolean seenNext;


        /**
         * Creates a new DLListIterator
         */
        @SuppressWarnings("unchecked")
        public SongListIterator() {
            seenNext = false;
            current = (Node<T>)head;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return current.next.data != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                seenNext = true;
                current = current.next;
                return current.data;
            }
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (!seenNext) {
                throw new IllegalStateException("there is no next value");
            }
            else {
                size--;
                seenNext = false;
                current.previous.setNext(current.next);
                current.next.setPrevious(current.previous);
            }
        }
    }
}
