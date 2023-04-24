package os.osHibernate;

import java.util.Objects;


public class AdditionalMaterialsWithLectures {
    private String name;
    private int amCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmCount() {
        return amCount;
    }

    public void setAmCount(int amCount) {
        this.amCount = amCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalMaterialsWithLectures that = (AdditionalMaterialsWithLectures) o;
        return amCount == that.amCount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amCount);
    }

    @Override
    public String toString() {
        return "AdditionalMaterialsWithLecturesEntity{" +
                "name='" + name + '\'' +
                ", amCount=" + amCount +
                '}';
    }
}
