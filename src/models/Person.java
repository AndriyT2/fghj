package models;

public class Person extends ModelsSuper implements Comparable<Person> {

    private int courseId;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public Person(String lastname, String firstname, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public Person(String lastname, Role role) {
        this.lastname = lastname;
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    private Role role;

    public Person() {
        super();
    }

    public Person(Role role) {
        this.role = role;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseId() {
        return courseId;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "courseId=" + courseId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", Id" + getId() +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        int result = this.lastname.toLowerCase().compareTo(person.getLastname().toLowerCase());
        if (result == 0) {
            result = this.firstname.toLowerCase().compareTo(person.getFirstname().toLowerCase());
        }
        return result;
    }
}
