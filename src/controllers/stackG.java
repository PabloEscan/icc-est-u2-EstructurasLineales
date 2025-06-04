package controllers;
import java.util.EmptyStackException;

import Models.NodeGeneric;

public class stackG <T> {
    
    private NodeGeneric<T> top;
    private int size;

    public stackG(){
        this.top = null;
    }

    public void push(T value){
        NodeGeneric<T> newNode = new NodeGeneric<T>(value);
        newNode.setNext(top);
        top = newNode;
        size = size +1;
    }

    public T pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size = size -1;
        return value;
    }

    public T peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        T value = top.getValue();
        return value;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void printStack(){
        NodeGeneric<T> aux = top;

        while(aux != null){
            System.out.print(aux.getValue() +" | ");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public int size(){
        return size;
    }
}
