package repository;

import models.ModelsSuper;
import utility.EntityNotFoundException;

public interface Repository<E extends ModelsSuper> {

    int size();
    boolean isEmpty();
    void add(E element);
    void add(int index, E element);
    void getAll();
    E get(int index) throws EntityNotFoundException;
    void remove (int index);

}
