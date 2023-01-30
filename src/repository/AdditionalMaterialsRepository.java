package repository;

import models.AdditionalMaterials;
import models.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AdditionalMaterialsRepository {
    private List<AdditionalMaterials> additionalMaterialsList;

    public List<AdditionalMaterials> getAdditionalMaterialsList() {
        return additionalMaterialsList;
    }

    private static AdditionalMaterialsRepository instance;

    private AdditionalMaterialsRepository() {
        this.additionalMaterialsList = new ArrayList<>();
    }

    public static AdditionalMaterialsRepository getInstance() {
        if (instance == null) {
            instance = new AdditionalMaterialsRepository();
        }
        return instance;
    }

    public void getAll() {
        System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
    }

    public AdditionalMaterials getById(int index) {
        for (AdditionalMaterials additionalMaterials : additionalMaterialsList){
            if (additionalMaterials.getId() == index) {return additionalMaterials;}
        }
        throw new NoSuchElementException();
    }
}
