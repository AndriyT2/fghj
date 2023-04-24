package os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.osHibernate.HomeworkEntity;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Integer> {
}