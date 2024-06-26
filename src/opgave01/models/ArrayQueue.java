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
        E element = (E) front.getElement();
        if (isEmpty()){
            throw new NoSuchElementException("Listen er tom");
        }
        front = front.next;
        return element;
    }

    @Override
    public E element() {
        if (isEmpty()){
            throw new NoSuchElementException("Listen er tom");
        }
        return (E) front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = new Node<>(front);
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
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
