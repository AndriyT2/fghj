package os.osHibernate;

import java.util.Objects;

public class StudentOnCourse {
    private String lastname;
    private String firstname;
    private int courseTotalCount;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getCourseTotalCount() {
        return courseTotalCount;
    }

    public void setCourseTotalCount(int courseTotalCount) {
        this.courseTotalCount = courseTotalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOnCourse that = (StudentOnCourse) o;
        return courseTotalCount == that.courseTotalCount && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, courseTotalCount);
    }

    @Override
    public String toString() {
        return "StudentOnCourse{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", courseTotalCount=" + courseTotalCount +
                '}';
    }
}
