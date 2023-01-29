package repository;

import models.ModelsSuper;
import utility.EntityNotFoundException;
import utility.SimpleIteration;

import java.util.Arrays;
import java.util.NoSuchElementException;

public abstract class RepositorySuper <E extends ModelsSuper<E>> implements Repository<E>{

   E[] arraySuper;
    final int STANDARD_CAPACITY = 7;


    private void increase() {
        int newCapacity = (arraySuper.length * 3) / 2 + 1;

        arraySuper = Arrays.copyOf(arraySuper, newCapacity);
    }


    public void add(E element) {
        if (arraySuper[arraySuper.length - 1] != null) {
        increase();
    }

        for (int i = 0; i < arraySuper.length; i++) {
            if (arraySuper[i] == null) {
                arraySuper[i] = element;
                break;
            }
        }
    }

    public void add(int index, E element) {
        if (index > (arraySuper.length - 1)) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (arraySuper[index]==null & arraySuper[index-1]==null) {
            throw new NoSuchElementException();
        }
        arraySuper[index] = element;
    }


    public void getAll() { System.out.println(Arrays.toString(arraySuper)); }


    public void exist(int id) {
        boolean result = false;
       for (E modelsSuper : arraySuper) {
           if(modelsSuper == null) {continue;}
           if (modelsSuper.getId() == id) {
               result = true;
               break;
           }
       }
       if (result) {
               System.out.println("Елемент з таким ID існує!");
       } else {
               System.out.println("Елемент з таким ID не існує!");
       }
    }

    public E get(int index) throws EntityNotFoundException {             // Rename from getById
       try {
           for (E modelsSuper : arraySuper) {
               if (modelsSuper.getId() == index) {
                   return modelsSuper;
               }
           }
       } catch (NullPointerException e) {
           System.err.println("Ви звернулися до пустого масиву!");
           e.printStackTrace();
       }
        throw new EntityNotFoundException("Елемента з таким індексом не існує!");

    }


    public void remove (int index) {  //Rename from deleteById
        for (int i = 0; i < arraySuper.length; i++) {
            if (arraySuper[i].getId() == index) {
                System.arraycopy(arraySuper, i+1, arraySuper, i, arraySuper.length - 1 - i);
                arraySuper[arraySuper.length-1] = null;
                break;
            }
        }
        throw new NoSuchElementException();
    }


    public int size() {
        int counter = 0;
        for (E object :
                arraySuper) {
            if (object != null) {
                ++counter;
            }
        }
        return counter;
    }

    public boolean isEmpty() {
       int counter = size();
        return counter == 0;
    }


    public E[] getArraySuper() {
        return arraySuper;
    }


    public void findAll() {
        getAll();
        int counter = 0;
        SimpleIteration<E> simpleIteration = new SimpleIteration<>(arraySuper);
        for (E element :
                arraySuper) {
            if (element != null) {
                ++counter;
            }
        }
            for (int i = 0; i < counter; i++) {
                System.out.println(simpleIteration.next());

        }
    }
}

