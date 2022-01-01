package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "advertisement_image", schema = "easygo", catalog = "")
@IdClass(AdvertisementImagePK.class)
public class AdvertisementImage {
    private long advertisementId;
    private String advertisementImage;

    @Id
    @Column(name = "advertisement_id")
    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Id
    @Column(name = "advertisement_image")
    public String getAdvertisementImage() {
        return advertisementImage;
    }

    public void setAdvertisementImage(String advertisementImage) {
        this.advertisementImage = advertisementImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementImage that = (AdvertisementImage) o;
        return advertisementId == that.advertisementId && Objects.equals(advertisementImage, that.advertisementImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisementId, advertisementImage);
    }
}
