package com.contemporarydeveloper;

import java.util.ArrayList;

public class SinglyLinkedList<T> {
    private Node head, tail;
    private int length;
    public LinkedListIterator iterator;

    public SinglyLinkedList() {
        length = 0;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    public class LinkedListIterator {
        private Node current;

        private LinkedListIterator() {
            current = head;
        }

        public void next() {
            if (current != null && current != tail) {
                current = current.next;
            }
        }

        public T getData() {
            if (current == null) {
                return null;
            }
            return current.data;
        }

        public void resetToHead() {
            iterator.current = head;
        }

        public void insertAfterCurrentNode(T item) {
            if (head == null) {
                insertAtEnd(item);
            } else {
                Node newNode = new Node(item);
                newNode.next = iterator.current.next;
                iterator.current.next = newNode;
                length++;
            }
        }

        public void removeNodeAfterCurrent() {
            if (head != null && current != tail) {
                current.next = current.next.next;
                length--;
            }
        }
    }

    public void insertAtBeginning(T item) {
        Node newHead = new Node(item);
        newHead.next = head;
        head = newHead;
        if (tail == null) {
            tail = head;
        }
        if (iterator != null) {
            iterator.resetToHead();
        }
        length++;
    }

    public void insertAtEnd(T item) {
        Node newTail = new Node(item);
        if (tail == null) {
            tail = newTail;
            head = tail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }
        if (iterator != null) {
            iterator.resetToHead();
        }
        length++;
    }

    public void removeFirstNode() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            if (iterator != null) {
                iterator.resetToHead();
            }
            length--;
        }
    }

    public void removeLastNode() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                LinkedListIterator removeNodeIterator = new LinkedListIterator();
                for (int i = 0; i < length - 2; i++) {
                    removeNodeIterator.next();
                }
                removeNodeIterator.current.next = null;
                tail = removeNodeIterator.current;
            }
            if (iterator != null) {
                iterator.resetToHead();
            }
            length--;
        }
    }

    public void beginTraversal() {
        iterator = new LinkedListIterator();
    }

    @Override
    public String toString() {
        Node current = head;
        ArrayList<T> listItems = new ArrayList<>();
        while (current != null) {
            listItems.add(current.data);
            current = current.next;
        }

        return listItems.toString();
    }
}
