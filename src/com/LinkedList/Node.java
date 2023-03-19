package com.LinkedList;

public class Node {
    Object data;
    Node next;
    Node head;
    public Node(){

    }
    public Node(Object data){
        this.data = data;
        this.next = null;
    }
    public void create(int d){
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            System.out.println("First node " + newNode.data);
            return;
        }
            Node tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    public void display(){
        Node tempNode = head;
        if (tempNode == null){
            System.out.println("LinkedList does not exist");
        }else{
            System.out.println("LinkedList is ->");
            while (tempNode != null){
                System.out.println(tempNode.data);
                tempNode = tempNode.next;
            }
        }
    }
    public void delete(){
        Node tNode = head;
        tNode = tNode.next;
        head = tNode;
        System.out.println("Deleted");
        display();
    }

}
