package org.example.Models;

public class Node<G> {
    private G data;
    private Node next;//composition

    //Singly linkedList;
    //Doubly linkedList;
    //Cyclical linkedList;
    public Node(G data) {
        this.data = data;
        this.next = null;
    }

    public G getData() {
        return data;
    }

    public void setData(G data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
