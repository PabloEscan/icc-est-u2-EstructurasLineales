package controllers;

import java.util.EmptyStackException;

import Models.NodeGeneric;
import Models.Persona;

public class QueueG <T>{
        
    private NodeGeneric<T> primero; //Tambien llamado head - front
    private NodeGeneric<T> ultimo;
    private int size;

    public QueueG(){
        this.primero = null;
        this.ultimo = null;
    }

    public void add(T value){
        NodeGeneric<T> newNode = new NodeGeneric<T>(value);
        if(isEmpty()){
            primero = newNode;
            ultimo = newNode;
        } else{
            ultimo.setNext(newNode);
            ultimo = newNode;
        }
        size ++;
    }

    public T remove(){
        if(isEmpty())
            throw new EmptyStackException();
        T aux = primero.getValue();
        primero = primero.getNext();
        size --;
        return aux;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException(); return primero.getValue();
    }

    public void printCola(){
        NodeGeneric<T> aux = primero;

        while(aux != null){
            System.out.print(aux.getValue() +" | ");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return primero == null;
    }

    public T findByName(String name){
        NodeGeneric<T> aux = primero;
        
        while(aux != null){
            if(aux.getValue() instanceof Persona){
                Persona p = (Persona) aux.getValue();
                if(p.getNombre().equals(name)){
                    return aux.getValue();
                }
            }
            aux = aux.getNext();
        }
        return null;
    }   



public Persona deleteByName(String nombre) {
        NodeGeneric<T> actual = primero;
        NodeGeneric<T> anterior = null;

        while (actual != null) {
            T value = actual.getValue();
            if (value instanceof Persona persona) {
                if (persona.getNombre().equalsIgnoreCase(nombre)) {
                    if (anterior == null) {
                        // Está al frente
                        primero = actual.getNext();
                        if (primero == null) ultimo = null;
                    } else {
                        anterior.setNext(actual.getNext());
                        if (actual == ultimo) ultimo = anterior;
                    }
                    size--;
                    return persona;
                }
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return null;
    }
}
