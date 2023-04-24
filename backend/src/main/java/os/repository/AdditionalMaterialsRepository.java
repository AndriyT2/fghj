package os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import os.osHibernate.AdditionalMaterialsEntity;
import os.osHibernate.AdditionalMaterialsWithLectures;

import java.util.List;

@Repository
public interface AdditionalMaterialsRepository extends JpaRepository<AdditionalMaterialsEntity, Integer> {

    //    @Query(value = "SELECT l.name, COUNT(am.additional_materials_id) AS am_count " +
//            "FROM lecture l LEFT JOIN additional_materials am ON l.lecture_id = am.lecture_id \n" +
//            "WHERE l.lecture_date < '2023-01-01 00:00:00' \n" +
//            "GROUP BY l.lecture_id ORDER BY l.lecture_date", nativeQuery = true)
//    List<Object[]> findLecture();
//
    @Query(name = "TotalAdditionalMaterialsByLectures", nativeQuery = true)
    List<AdditionalMaterialsWithLectures> lectureBefore2023();

    @Query(name = "AdditionalMaterialsCountType", nativeQuery = true)
    List<Object[]> amType();


}
