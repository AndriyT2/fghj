package utility;

import models.AdditionalMaterials;

import java.util.Comparator;

public class AdditionalMaterialsLectureIdComparator implements Comparator<AdditionalMaterials> {
    @Override
    public int compare(AdditionalMaterials am1, AdditionalMaterials am2) {
        return am1.getLectureId() - am2.getLectureId();
    }
}
