package repository;

import models.ModelsSuper;
import utility.EntityNotFoundException;

import java.util.Arrays;

public abstract class RepositorySuper <E extends ModelsSuper> implements Repository<E>{

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

    public void add(int index, E element) {    //This method can destroy the logic of other methods!
        if (index > (arraySuper.length - 1)) {
            arraySuper = Arrays.copyOf(arraySuper, index);
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
               } else {
                   throw new EntityNotFoundException("Елемента з таким індексом не існує!");
               }
           }
       } catch (NullPointerException e) {
           System.err.println("Ви звернулися до пустого масиву!");
           e.printStackTrace();
       }

        return null;
    }


    public void remove (int index) {  //Rename from deleteById
        for (int i = 0; i < arraySuper.length; i++) {
            if (arraySuper[i].getId() == index) {
                System.arraycopy(arraySuper, i+1, arraySuper, i, arraySuper.length - 1 - i);
                arraySuper[arraySuper.length-1] = null;
                break;
            } else {
                System.out.println("Елемента з таким ID не існує!");
            }
        }
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
       if (counter == 0) { return true;
       } else { return false;}
    }


    public E[] getArraySuper() {
        return arraySuper;
    }


}

