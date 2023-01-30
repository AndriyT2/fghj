package models;

public class AdditionalMaterials extends ModelsSuper<AdditionalMaterials> {

    private String name;
    private int lectureId;
    private Enum resourceType;

    public AdditionalMaterials() {
        super();
    }
    public AdditionalMaterials(Enum resourceType) {this.resourceType = resourceType;}

    public AdditionalMaterials(String name, int lectureId) {
        this.name = name;
        this.lectureId =lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public Enum getResourceType() {
        return resourceType;
    }

    public void setResourceType(Enum resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "AdditionalMaterials{" +
                "name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resourceType=" + resourceType +
                ", Id" + getId() +
                '}';
    }
}



