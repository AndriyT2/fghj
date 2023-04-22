package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osHibernate.CourseEntity;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}