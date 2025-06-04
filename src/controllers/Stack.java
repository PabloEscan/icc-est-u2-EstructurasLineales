package controllers;
import java.util.EmptyStackException;

import Models.Node;

public class Stack {

    private int contador;
    private Node top;   //Nodeo en la cima de la pila

    public Stack(){
        this.top = null;    //No existe un tope la pila no a sido creada
    }

    public void push(int value){
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        contador= contador ++;
    }

    public int pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        int value = top.getValue();
        top = top.getNext();
        contador= contador --;
        return value;
    }

    public int peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        int value = top.getValue();
        return value;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void printStack(){
        Node aux = top;

        while(aux != null){
            System.out.print(aux.getValue() +" | ");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public int size(){
        return contador;
    }

}
