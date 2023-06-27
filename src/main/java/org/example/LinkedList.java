package org.example;

import org.example.Models.Node;

public class LinkedList<G> {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(G data){
        Node dataNode = new Node(data);
        if (head == null){
            head = dataNode;
        }
        else{
            Node currentNode = head;
            while(currentNode.getNext()!=null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(dataNode);
        }
    }


    //TODO: DEBUG insert(String data) method
    //TODO: Get visualizer for a doubly linked list

    public void printLinkedList(){
        if (head == null){
            System.out.println("Empty LinkedList");
        }
        else{
            Node currentNode = head;
            System.out.print("[");
            while(currentNode!=null){
                System.out.print(currentNode.getData()+" ");
                currentNode = currentNode.getNext();
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
