package os.service11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.osHibernate.AdditionalMaterialsWithLectures;
import os.repository.AdditionalMaterialsRepository;

import java.util.List;

@Service
public class AdditionalMaterialsService {
    @Autowired
    private AdditionalMaterialsRepository amr;

    public List<AdditionalMaterialsWithLectures> lectureBefore2023() { return  amr.lectureBefore2023();}

    public List<Object[]> amType() { return amr.amType(); }

//   public List<AdditionalMaterialsEntity> lectureBefore2023() {return  amr.lectureBefore2023();}
//
//    public List<Object[]> testRepo() {
//       List<Object[]> test = amr.findLecture();
//        List<AdditionalMaterialsEntity> additionalMaterialsEntities = new ArrayList<>();
//        for(Object[] addMat : test) {
//            AdditionalMaterialsEntity additionalMaterialsEntity = new AdditionalMaterialsEntity();
//            String firstReturnedValue = String.valueOf(addMat[0]);
//            String secondValuer = String.valueOf(addMat[1]);
//            System.out.println("f = " + firstReturnedValue + "  s = " + secondValuer);
//            additionalMaterialsEntity.setName(firstReturnedValue);
//
//            additionalMaterialsEntities.add(additionalMaterialsEntity);
//        }
//
//        System.out.println(additionalMaterialsEntities);
//       return amr.findLecture();
//    }
}
