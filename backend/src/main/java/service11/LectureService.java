package service11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osHibernate.LectureEntity;
import repository.LectureRepository;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lr;

public LectureEntity firstLecture() { return lr.firstLecture(); }

}
