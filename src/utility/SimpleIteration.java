package utility;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SimpleIteration<E> implements SimpleIterationInterface<E> {

    private E[] iterationArray;

    private static int index;

    public SimpleIteration(E[] iterationArray) {
        this.iterationArray = iterationArray;
    }


       @Override
    public boolean hasNext() {

       return iterationArray[0] != null;
    }


        @Override
    public E next() {
        try {

            if (iterationArray[index] != null) {
                return iterationArray[index++];
            } else {
                throw new NoSuchElementException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }

    }


    @Override
    public void remove() {
        if (hasNext()) {
                if (iterationArray[iterationArray.length - 1] != null) {
                    iterationArray[iterationArray.length - 1] = null;
                    System.out.println(Arrays.toString(iterationArray));
                }else {
                    for (int i = 0; i < iterationArray.length; i++) {
                        if (iterationArray[i] == null) {
                            iterationArray[i - 1] = null;
                            System.out.println(Arrays.toString(iterationArray));
                            break;
                        }
                    }
            }
        }else {
                    throw new IllegalStateException();
        }

    }
}
