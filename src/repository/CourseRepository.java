package repository;

import models.Course;

public class CourseRepository {

        private final int STANDARD_CAPACITY = 5;

        private Course[] courseArray;

        public CourseRepository() {
            this.courseArray = new Course[STANDARD_CAPACITY];
        }

        public CourseRepository(int initCapacity) {
            if (initCapacity < 0) {

                System.out.println("Ви ввели некоректне значення аргументу списку. " +
                        "\nБуде створенний список стандартного розміру в " + STANDARD_CAPACITY + " курсів!");
            } else {
                this.courseArray = new Course[initCapacity];
            }
        }
    }
