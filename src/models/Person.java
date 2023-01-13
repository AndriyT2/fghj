package models;

public class Person extends ModelsSuper {

    private int courseId;
    private Enum role;

    public Person () { super();}

    public Person(Enum role) {
       this.role = role;
   }





    public int getCourseId() {
        return courseId;
    }

    public Enum getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "courseId=" + courseId +
                ", role=" + role +
                '}';
    }
}
