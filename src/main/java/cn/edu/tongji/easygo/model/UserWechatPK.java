package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserWechatPK implements Serializable {
    private long userId;
    private String userWechat;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "user_wechat")
    @Id
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
        UserWechatPK that = (UserWechatPK) o;
        return userId == that.userId && Objects.equals(userWechat, that.userWechat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userWechat);
    }
}
