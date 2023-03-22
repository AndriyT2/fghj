package utility.comparator;

import models.Lecture;
import repository.AdditionalMaterialsRepository;

import java.util.Comparator;

public class LectureMaxCountOfAdditionalMaterialComparator implements Comparator<Lecture> {

    @Override
    public int compare(Lecture lecture1, Lecture lecture2) {

        int result = 0;
        int count1 = AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().stream().filter(additionalMaterials -> additionalMaterials.getLectureId() == lecture1.getId()).toList().size();
        int count2 = AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().stream().filter(additionalMaterials -> additionalMaterials.getLectureId() == lecture2.getId()).toList().size();
        if ((count1 - count2) > 0) {
            return 1;
        } else if ((count1 - count2) < 0) {
            return -1;
        } else {
            return result;
        }
    }
}
