package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user_wechat", schema = "easygo", catalog = "")
@IdClass(UserWechatPK.class)
public class UserWechat {
    private long userId;
    private String userWechat;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_wechat")
    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWechat that = (UserWechat) o;
        return userId == that.userId && Objects.equals(userWechat, that.userWechat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userWechat);
    }
}
