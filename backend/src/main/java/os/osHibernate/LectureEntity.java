package os.osHibernate;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.sql.Timestamp;
import java.util.Objects;

@Entity

@NamedNativeQuery(name = "FirstLectureWithHW",
        query = "SELECT l.lecture_id, l.description, l.lecture_date, l.name, l.creation_date, COUNT(h.homework_id)  AS hw_count FROM lecture l LEFT JOIN homework h ON l.lecture_id = h.lecture_id WHERE l.creation_date = (SELECT MIN(creation_date) FROM lecture)GROUP BY l.lecture_id ORDER BY hw_count LIMIT 1",
        resultSetMapping = "FirstLectureWithHWMapping")

@SqlResultSetMapping(name = "FirstLectureWithHWMapping",
        entities = @EntityResult(
                entityClass = LectureEntity.class,
                fields = {
                        @FieldResult(name = "lectureId", column = "lecture_id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "description", column = "description"),
                        @FieldResult(name = "creationDate", column = "creation_date"),
                        @FieldResult(name = "lectureDate", column = "lecture_date"),
                }
        )

)


@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "lecture", schema = "online_school")
public class LectureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lecture_id", nullable = false)
    private int lectureId;
    @Basic
    @Column(name = "name", nullable = true, length = 200)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 400)
    private String description;
    @Basic
    @Column(name = "creation_date", nullable = true)
    private Timestamp creationDate;
    @Basic
    @Column(name = "course_id", nullable = true)
    private Integer courseId;
    @Basic
    @Column(name = "lecture_date", nullable = true)
    private Timestamp lectureDate;


    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Timestamp getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(Timestamp lectureDate) {
        this.lectureDate = lectureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureEntity that = (LectureEntity) o;
        return lectureId == that.lectureId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(creationDate, that.creationDate) && Objects.equals(courseId, that.courseId) && Objects.equals(lectureDate, that.lectureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId, name, description, creationDate, courseId, lectureDate);
    }

    @Override
    public String toString() {
        return "LectureEntity{" +
                "lectureId=" + lectureId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", courseId=" + courseId +
                ", lectureDate=" + lectureDate +
                '}';
    }


}
