package com.contemporarydeveloper;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertAtBeginning(10);
        singlyLinkedList.insertAtEnd(20);
        singlyLinkedList.beginTraversal();
        singlyLinkedList.iterator.insertAfterCurrentNode(15);
        System.out.println(singlyLinkedList);
        singlyLinkedList.iterator.next();
        System.out.println(singlyLinkedList.iterator.getData());
        singlyLinkedList.iterator.removeNodeAfterCurrent();
        System.out.println(singlyLinkedList);
        singlyLinkedList.iterator.resetToHead();
        System.out.println(singlyLinkedList.iterator.getData());
        singlyLinkedList.removeLastNode();
        System.out.println(singlyLinkedList);
        singlyLinkedList.removeFirstNode();
        System.out.println(singlyLinkedList + "\n");

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertAtBeginning(50);
        doublyLinkedList.insertAtEnd(60);
        doublyLinkedList.beginTraversal();
        doublyLinkedList.iterator.insertAfterCurrentNode(55);
        System.out.println(doublyLinkedList);
        doublyLinkedList.iterator.next();
        System.out.println(doublyLinkedList.iterator.getData());
        doublyLinkedList.iterator.removeNodeAfterCurrent();
        System.out.println(doublyLinkedList);
        doublyLinkedList.iterator.previous();
        System.out.println(doublyLinkedList.iterator.getData());
        doublyLinkedList.removeLastNode();
        System.out.println(doublyLinkedList);
        doublyLinkedList.removeFirstNode();
        System.out.println(doublyLinkedList + "\n");
    }
}
