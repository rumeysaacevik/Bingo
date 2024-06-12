/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author Rümeysa
 */
public class LinkedList <T>{
    
    public Node<T> head;
    private int size;

    public int size() {
        return size;
    }
    
    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode; 
            size++;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
    }

    void insertAfter(T data, T search) {
        Node<T> temp = head;

        while (temp != null && !temp.data.equals(search)) {
            temp = temp.next;
        }

        if (temp != null) {
            Node<T> newNode = new Node<>(data); 
            newNode.next = temp.next;
            temp.next = newNode; 
        } else {
            addLast(data);
        }
    }

    boolean remove(T data) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.data.equals(data)) { 
                head = head.next;
                return true;
            } else {
                Node<T> temp = head.next;
                Node<T> prev = head; 
                while (temp != null && !temp.data.equals(data)) {
                    prev = temp; 
                    temp = temp.next; 

                }

                if (temp != null) { 
                    prev.next = temp.next; 
                    return true;
                } else {
                    System.out.println(data + " not found !");
                }
            }
        }
        return false;
    }

    void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public T get(int index) {

        if (index >= size || index < 0) {
            System.out.println("Size: " + size + ", given index: " + index);
            throw new IndexOutOfBoundsException();
        }

        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp.data;
    }
    
    public  T getFromChild(int index) {
    Node<T> temp = head;

    int currentIndex = 0; 
    while (temp != null && currentIndex != index) {
        
        if (currentIndex % 5 == 4) {
            if (temp.child != null) {
                temp = temp.child;
            } else {
                return null; 
            }
        } else {
            temp = temp.next;
        }
        currentIndex++;
    }
    
    if (temp != null) {
        return temp.data;
    } else {
        return null;
    }
}


public void removeWithData(T data) {
        Node<T> temp = head;
        Node<T> prev = null;
        while (temp != null) {
            if (temp.data == data) {
                if (temp == head) {
                    head = head.next;
                } else if (prev != null && prev.next == null) {
                    prev.child = temp.next;
                } else if (prev != null && prev.child == null) {
                    prev.next = temp.next;
                }
                size--;
            }
            prev = temp;
            temp = (temp.next == null && temp.child != null) ? temp.child : temp.next;
        }

    }

public void addToIndex(int index, T data) {
        
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        
        Node<T> temp = head;
        Node<T> prev = null;
        
        int currentIndex = 0;
        while (temp != null && currentIndex != index) {
            prev = temp;
            
            if (currentIndex % 5 == 4) {
                temp = temp.child;
            }else{
                temp = temp.next;
            }
            currentIndex++;
        }
        
        if (index % 5 == 0) {
            prev.child = newNode;
            newNode.next = temp;
            System.out.println("Added to the child");
        }else{
            prev.next = newNode;
            newNode.next = temp;
            System.out.println("Added to the next");
        }
        
        size++;

    }

public boolean contains(T data) {
    Node<T> temp = head; 

    while (temp != null) {
        if (temp.data.equals(data)) {
            return true;
        }
        temp = temp.next;
    }
    return false;
}

public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new Error();
        }
        return head.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new Error();
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }
}