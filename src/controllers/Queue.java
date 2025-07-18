package controllers;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.EmptyStackException;

import Models.Node;

public class Queue {
    
    private Node primero; //Tambien llamado head - front
    private Node ultimo;
    private int size;

    public Queue(){
        this.primero = null;
        this.ultimo = null;
    }

    public void add(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            primero = newNode;
            ultimo = newNode;
        } else{
            ultimo.setNext(newNode);
            ultimo = newNode;
        }
        size ++;
    }

    public int remove(){
        if(isEmpty())
            throw new EmptyStackException();
        int aux = primero.getValue();
        primero = primero.getNext();
        size --;
        return aux;
    }

    public int size(){
        return size;
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException(); return primero.getValue();
    }

    public boolean isEmpty(){
        return primero == null;
    }
}
