package os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import os.osHibernate.PersonEntity;
import os.osHibernate.StudentOnCourse;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

     List<PersonEntity> findAllByRoleOrderByLastname(Object role);

     @Query(value = "SELECT * FROM person where role = 'teacher' AND lastname REGEXP '^[A-N]|^[А-Г]'", nativeQuery = true) //|^[А-Н]and lastname like '^[A-N]'
     List<PersonEntity> teacherByLetter();

     @Query(name = "StudentOnCourse", nativeQuery = true)
     List<StudentOnCourse> StudentOnCourse();
}