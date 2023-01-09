package models;

public class Person extends ModelsSuper {
   public Person () { super();}

    public Person(Enum role) { super();
       this.role = role;
   }
    private int courseId;
    private Enum role;





    public int getCourseId() {
        return courseId;
    }

    public Enum getRole() {
        return role;
    }
}
