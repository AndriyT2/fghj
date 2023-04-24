package os.service11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import os.osHibernate.PersonEntity;
import os.osHibernate.StudentOnCourse;
import os.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository pr;
    @Autowired
    public List<PersonEntity> personGetAll() {
        return pr.findAll();
    }

    public PersonEntity findById(Integer id) {
        return pr.findById(id).orElse(null);
    }

    @Transactional
    public void addPerson(String lastname, String firstname, String phone, String email, String role) {
        PersonEntity person = new PersonEntity();
        person.setLastname(lastname);
        person.setFirstname(firstname);
        person.setPhone(phone);
        person.setEmail(email);
        person.setRole(role);
        pr.save(person);
    }

    public List<PersonEntity> studentByLastname() {
        return pr.findAllByRoleOrderByLastname("student");
    }

    public List<PersonEntity> teacherByLetter() {
        return pr.teacherByLetter();
    }

    public List<StudentOnCourse> studentOnCourses() {
//        List<StudentOnCourse> list1 = null;
//        List<StudentOnCourse> list2 = null;
//        List<StudentOnCourse> list3 = null;
//        List<StudentOnCourse> list = null;
//
//        for (StudentOnCourse student : pr.StudentOnCourse()) {
//            if (student.getCourseTotalCount() == 1) {
//                list1.add(student);
//            }
//            if (student.getCourseTotalCount() == 2) {
//                list2.add(student);
//            }
//            if (student.getCourseTotalCount() >= 3) {
//                list3.add(student);
//            }
//        }
//        if (courseCount == 1) {
//            list = list1;}
//        if (courseCount == 2) {
//            list = list2;}
//        if (courseCount >=3){
//            list = list3;
//        }
//        return list;
    return pr.StudentOnCourse();
    }
}





