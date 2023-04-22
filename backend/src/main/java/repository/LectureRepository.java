package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import osHibernate.LectureEntity;
@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, Integer> {
    @Query(name = "FirstLectureWithHW", nativeQuery = true)
    LectureEntity firstLecture();
}








