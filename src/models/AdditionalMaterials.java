package models;

public class AdditionalMaterials extends ModelsSuper implements Comparable<AdditionalMaterials> {

    private String name;
    private int lectureId;
    private ResourceType resourceType;

    public AdditionalMaterials() {
        super();
    }
    public AdditionalMaterials(ResourceType resourceType) {this.resourceType = resourceType;}

    public AdditionalMaterials(String name, int lectureId, ResourceType resourceType) {
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
    }

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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
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

    @Override
    public int compareTo(AdditionalMaterials am) {
        if (this.getId() > am.getId()) {
            return 1;
        } else if (this.getId() < am.getId()) {
            return -1;
        }
        return 0;
    }
}



