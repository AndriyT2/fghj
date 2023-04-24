package os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.osHibernate.CourseEntity;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}