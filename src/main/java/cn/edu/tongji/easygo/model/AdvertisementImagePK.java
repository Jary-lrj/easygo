package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AdvertisementImagePK implements Serializable {
    private long advertisementId;
    private String advertisementImage;

    @Column(name = "advertisement_id")
    @Id
    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Column(name = "advertisement_image")
    @Id
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
        AdvertisementImagePK that = (AdvertisementImagePK) o;
        return advertisementId == that.advertisementId && Objects.equals(advertisementImage, that.advertisementImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisementId, advertisementImage);
    }
}
