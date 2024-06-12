/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author Rümeysa
 */
public class Node <T> {

    
    public T data;
    public Node<T> next;
    public Node<T> child;
    public Node<T> prev;
    

    public Node(T data) {
        this.data = data; 
        this.next = null; 
    }
    
}