package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ImformationImagePK implements Serializable {
    private long informationId;
    private String informationImage;

    @Column(name = "information_id")
    @Id
    public long getInformationId() {
        return informationId;
    }

    public void setInformationId(long informationId) {
        this.informationId = informationId;
    }

    @Column(name = "information_image")
    @Id
    public String getInformationImage() {
        return informationImage;
    }

    public void setInformationImage(String informationImage) {
        this.informationImage = informationImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImformationImagePK that = (ImformationImagePK) o;
        return informationId == that.informationId && Objects.equals(informationImage, that.informationImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationId, informationImage);
    }
}
