package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserQqPK implements Serializable {
    private long userId;
    private String userQq;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "user_qq")
    @Id
    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQqPK userQqPK = (UserQqPK) o;
        return userId == userQqPK.userId && Objects.equals(userQq, userQqPK.userQq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userQq);
    }
}
