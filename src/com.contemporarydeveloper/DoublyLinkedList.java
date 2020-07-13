package com.contemporarydeveloper;

import java.util.ArrayList;

public class DoublyLinkedList<T> {
    private Node head, tail;
    public LinkedListIterator iterator;

    private class Node {
        private T data;
        private Node next;
        private Node previous;

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

        public void previous() {
            if (current != null && current != head) {
                current = current.previous;
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
            if (current != tail) {
                Node newNode = new Node(item);
                newNode.next = iterator.current.next;
                newNode.previous = iterator.current;
                newNode.next.previous = newNode;
                iterator.current.next = newNode;
            } else {
                insertAtEnd(item);
            }
        }

        public void removeNodeAfterCurrent() {
            if (head != null && current != tail) {
                Node nodeToRemove = current.next;
                if (nodeToRemove != tail) {
                    current.next = nodeToRemove.next;
                    nodeToRemove.next.previous = current;
                } else {
                    removeLastNode();
                }
            }
        }
    }

    public void insertAtBeginning(T item) {
        Node newHead = new Node(item);
        if (head == null) {
            head = newHead;
            tail = head;
        } else {
            newHead.next = head;
            head.previous = newHead;
            head = newHead;
        }
        if (iterator != null) {
            iterator.resetToHead();
        }
    }

    public void insertAtEnd(T item) {
        Node newTail = new Node(item);
        if (tail == null) {
            tail = newTail;
            head = tail;
        } else {
            tail.next = newTail;
            newTail.previous = tail;
            tail = newTail;
        }
        if (iterator != null) {
            iterator.resetToHead();
        }
    }

    public void removeFirstNode() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            if (iterator != null) {
                iterator.resetToHead();
            }
        }
    }

    public void removeLastNode() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
            if (iterator != null) {
                iterator.resetToHead();
            }
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
