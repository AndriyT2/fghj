package repository;

import models.AdditionalMaterials;
import utility.comparator.AdditionalMaterialsLectureIdComparator;
import utility.comparator.AdditionalMaterialsResourceTypeComparator;

import java.io.Serializable;
import java.util.*;

public class AdditionalMaterialsRepository implements Serializable {
    private final List<AdditionalMaterials> additionalMaterialsList;

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

    public void sortAdditionalMaterialsById(){
        TreeSet<AdditionalMaterials> additionalMaterialsTreeSet = new TreeSet<>(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
        System.out.println(additionalMaterialsTreeSet);
    }

    public void sortAdditionalMaterialsByLectureId(){
        List<AdditionalMaterials> tmp = new ArrayList<>(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
        tmp.sort(new AdditionalMaterialsLectureIdComparator());
        System.out.println(tmp);
    }

    public void sortAdditionalMaterialsByResourceType(){
        List<AdditionalMaterials> tmp = new ArrayList<>(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
        tmp.sort(new AdditionalMaterialsResourceTypeComparator());
        System.out.println(tmp);
    }

    public TreeMap<Integer, AdditionalMaterials> additionalMaterialsTreeMap() {
        TreeMap<Integer, AdditionalMaterials> additionalMaterialsTreeMap = new TreeMap<>();
        for (AdditionalMaterials additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
           additionalMaterialsTreeMap.put(additionalMaterials.getLectureId(), additionalMaterials);
        }
        return additionalMaterialsTreeMap;
    }

}
