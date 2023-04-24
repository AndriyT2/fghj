package os.service11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.osHibernate.LectureEntity;
import os.repository.LectureRepository;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lr;

public LectureEntity firstLecture() { return lr.firstLecture(); }

}
