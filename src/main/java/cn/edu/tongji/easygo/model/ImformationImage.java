package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "imformation_image", schema = "easygo", catalog = "")
@IdClass(ImformationImagePK.class)
public class ImformationImage {
    private long informationId;
    private String informationImage;

    @Id
    @Column(name = "information_id")
    public long getInformationId() {
        return informationId;
    }

    public void setInformationId(long informationId) {
        this.informationId = informationId;
    }

    @Id
    @Column(name = "information_image")
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
        ImformationImage that = (ImformationImage) o;
        return informationId == that.informationId && Objects.equals(informationImage, that.informationImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationId, informationImage);
    }
}
