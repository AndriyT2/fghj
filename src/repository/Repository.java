package repository;

import models.ModelsSuper;

public interface Repository<E extends ModelsSuper> {

    int size();
    boolean isEmpty();
    void add(E element);
    void add(int index, E element);
    void getAll();
    E get(int index);
    void remove (int index);

}
