package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Image;
import cn.edu.tongji.easygo.model.ImagePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, ImagePK> {


}
