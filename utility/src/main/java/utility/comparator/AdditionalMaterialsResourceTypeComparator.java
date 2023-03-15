package utility.comparator;

import models.AdditionalMaterials;

import java.util.Comparator;

public class AdditionalMaterialsResourceTypeComparator implements Comparator<AdditionalMaterials> {

    @Override
    public int compare(AdditionalMaterials am1, AdditionalMaterials am2) {
        return am1.getResourceType().compareTo(am2.getResourceType());
    }
}
