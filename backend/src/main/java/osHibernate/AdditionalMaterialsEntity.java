package osHibernate;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity

@NamedNativeQuery(name = "TotalAdditionalMaterialsByLectures",
        query = "SELECT l.name, COUNT(am.additional_materials_id) AS amCount FROM lecture l LEFT JOIN additional_materials am ON l.lecture_id = am.lecture_id WHERE l.lecture_date < '2023-01-01 00:00:00' GROUP BY l.lecture_id ORDER BY l.lecture_date",
        resultSetMapping = "TotalAdditionalMaterialsByLecturesMapping")
@SqlResultSetMapping(name = "TotalAdditionalMaterialsByLecturesMapping",
        classes = {
                @ConstructorResult(
                        columns = {
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "amCount", type = int.class),
                        },
                        targetClass = AdditionalMaterialsWithLectures.class
                )}
)


@NamedNativeQuery(name = "AdditionalMaterialsCountType",
        query = "select resource_type, count(resource_type) as type_total from additional_materials group by resource_type",
        resultSetMapping = "AdditionalMaterialsCountTypeMapping")
@SqlResultSetMapping(name = "AdditionalMaterialsCountTypeMapping",
        entities = @EntityResult(
                entityClass = AdditionalMaterialsEntity.class,
                fields = {
                        @FieldResult(name = "resourceType", column = "resource_type"),
                }
        ),
        columns = @ColumnResult(
                name = "type_total",
                type = int.class
        )
)


//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "additional_materials", schema = "online_school")
public class AdditionalMaterialsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "additional_materials_id", nullable = false)
    private int additionalMaterialsId;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "resource_type", nullable = false)
    private Object resourceType;
    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = true)
    private  LectureEntity lecture;

//    @Transient
    private String lectureName;

    public String getLectureName() {
        return lecture.getName();
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }



    public LectureEntity getLecture() {
        return lecture;
    }

    public void setLecture(LectureEntity lecture) {
        this.lecture = lecture;
    }

    public int getAdditionalMaterialsId() {
        return additionalMaterialsId;
    }

    public void setAdditionalMaterialsId(int additionalMaterialsId) {
        this.additionalMaterialsId = additionalMaterialsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getResourceType() {
        return resourceType;
    }

    public void setResourceType(Object resourceType) {
        this.resourceType = resourceType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalMaterialsEntity that = (AdditionalMaterialsEntity) o;
        return additionalMaterialsId == that.additionalMaterialsId && Objects.equals(name, that.name) && Objects.equals(resourceType, that.resourceType) && Objects.equals(lecture, that.lecture) && Objects.equals(lectureName, that.lectureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalMaterialsId, name, resourceType, lecture, lectureName);
    }

    @Override
    public String toString() {
        return "AdditionalMaterialsEntity{" +
                "additionalMaterialsId=" + additionalMaterialsId +
                ", name='" + name + '\'' +
                ", resourceType=" + resourceType +
                ", lecture=" + lecture +
                ", lectureName='" + lectureName + '\'' +
                '}';
    }
}
