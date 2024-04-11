package opgave01.models;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private Node back = null;
    private Node front = null;
    @Override
    public void add(E element) {
        Node newNode = new Node(element);
        if (back == null) {
            front = newNode;
            back = newNode;
        }
        back.setNext(newNode);
        back = newNode;
    }

    @Override
    public E remove() {
        Node current = new Node<>(front);
        if (isEmpty()){
            throw new NoSuchElementException("Listen er tom");
        }
        current.getNext();
        return (E) current;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
    public class Node<E> {
        private E element;
        private Node next;


        public Node(E element) {
            this.element = element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
