package iterator;

import java.util.Iterator;

/**
 * Author: timofeevdv
 * Date: 01.02.2017
 */
public class MyLinkedList<E> {

    private Integer position = null;
    private Node<E> lastElement;
    private Node<E> firstElement;

    class Node<E> {
        private E element;
        private Node previous;
        private Node next;

        public Node(E element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return this.element;
        }
    }

    class ListItr<E> implements Iterator {

        public boolean hasNext() {
            return getNode(position).next != null;
        }

        public E next() {
            Node<E> retNode = (Node<E>) getNode(position);
            position++;
            return retNode.getData();
        }
    }

    public Iterator listIterator() {
        return new ListItr();
    }

    public void add(E element) {
        Node newNode = new Node(element, this.lastElement, null);
        if (this.position == null) {
            // List is empty
            this.lastElement = newNode;
            this.firstElement = this.lastElement;
            this.position = 0;
        } else {
            this.lastElement.next = newNode;
            this.lastElement = newNode;
            newNode.previous = this.lastElement;
            this.position++;
        }
    }

    public E get(Integer pos) {
        return getNode(pos).getData();
    }

    public Node<E> getNode(Integer pos) {
        Integer i = 0;
        Node<E> seek = this.firstElement;
        while (i < pos) {
            i++;
            seek = seek.next;
        }
        return seek;
    }

    public Integer getPosition() {
        return this.position;
    }

}
