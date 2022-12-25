package repository;

import models.Lecture;

import java.util.Arrays;

public class LectureRepository {
    private final int STANDARD_CAPACITY = 7;


    private Lecture[] lecturesArray;

    public void setLecturesArray(Lecture[] lecturesArray) {
        this.lecturesArray = lecturesArray;
    }

    public Lecture[] getLecturesArray() {
        return lecturesArray;
    }

    public LectureRepository() {
        this.lecturesArray = new Lecture[STANDARD_CAPACITY];
    }

    public LectureRepository(int initCapacity) {
        if (initCapacity < 0) {

            System.out.println("Ви ввели некоректне значення аргументу списку. " +
                    "\nБуде створенний список стандартного розміру на " + STANDARD_CAPACITY + " лекцій!");
            this.lecturesArray = new Lecture[STANDARD_CAPACITY];
        } else {
            this.lecturesArray = new Lecture[initCapacity];
        }
    }

    private Lecture[] increaseArray(Lecture[] array) {
        int newCapacity = (array.length * 3) / 2 + 1;
        Lecture[] tmpArray = new Lecture[newCapacity];
        tmpArray = Arrays.copyOf(array, newCapacity);
        array = tmpArray;
        return array;
    }

    public void addLecture(Lecture[] array1, Lecture lecture) {

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == null) {
                array1[i] = lecture;

            } else {
                Lecture[] array2 = increaseArray(array1);
                array2[array2.length - 1] = lecture;
                setLecturesArray(array2);
            }

        }

    }
}
//                System.out.println(Arrays.toString(array1));
//              int freeCell =  Arrays.binarySearch(array1, null);
//               array1[freeCell] = lecture;
//                class models.Lecture cannot be cast to class java.lang.Comparable (models.Lecture is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//                at java.base/java.util.Arrays.binarySearch0(Arrays.java:2232)
















