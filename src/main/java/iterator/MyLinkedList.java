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

    class ListItr<E> implements Iterator{
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

    }

    public void add(E element) {
        Node newNode = new Node(element, this.lastElement, null);
        if(this.position == null) {
            this.lastElement = newNode;
            this.firstElement = this.lastElement;
            this.position = 0;
        } else {
            this.lastElement.next = newNode;
            this.position++;
        }
    }

    public E get(Integer pos) {
        Integer i = 0;
        Node<E> seek = this.firstElement;
        while(i < pos) {
            i++;
            seek = seek.next;
        }
        return seek.getData();
    }

    public Integer getPosition() {
        return this.position;
    }

}
