package repository;

import models.ModelsSuper;

import java.util.Arrays;

public class RepositorySuper {
   ModelsSuper[] arraySuper;
    final int STANDARD_CAPACITY = 7;


    public RepositorySuper() {
        this.arraySuper = new ModelsSuper[STANDARD_CAPACITY];
    }

    public RepositorySuper(int initCapacity) {
        if (initCapacity < 0) {

            System.out.println("Ви ввели некоректне значення аргументу списку. " +
                    "\nБуде створенний список стандартного розміру на " + STANDARD_CAPACITY + " значень!");
            this.arraySuper = new ModelsSuper[STANDARD_CAPACITY];
        } else {
            this.arraySuper = new ModelsSuper[initCapacity];
        }
    }

    private void increase() {
        int newCapacity = (arraySuper.length * 3) / 2 + 1;

        ModelsSuper[] tmp = Arrays.copyOf(arraySuper, newCapacity);

        arraySuper = tmp;
    }


    public void add(ModelsSuper modelsSuper) {
        if (arraySuper[arraySuper.length - 1] != null) {
        increase();
    }

        for (int i = 0; i < arraySuper.length; i++) {
            if (arraySuper[i] == null) {
                arraySuper[i] = modelsSuper;
                break;
            }
        }
    }


    public void getAll() { System.out.println(Arrays.toString(arraySuper)); }

    public void getById (int id) {
        for (ModelsSuper modelsSuper:arraySuper) {
            if (modelsSuper.getId()==id) {
                System.out.println(modelsSuper);
                break;
            }
            System.out.println("Елемента з таким ID не існує!");
        }
    }

    public void deleteById (int id) {
        for (int i = 0; i < arraySuper.length; i++) {
            if (arraySuper[i].getId() == id) {
                System.arraycopy(arraySuper, i+1, arraySuper, i, arraySuper.length - 1 - i);
                arraySuper[arraySuper.length-1] = null;
                break;
            } else {
                System.out.println("Елемента з таким ID не існує!");
            }
        }
    }

    public ModelsSuper[] getArraySuper() {
        return arraySuper;
    }


}

