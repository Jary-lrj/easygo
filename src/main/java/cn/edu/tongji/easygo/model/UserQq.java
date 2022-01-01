package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user_qq", schema = "easygo", catalog = "")
@IdClass(UserQqPK.class)
public class UserQq {
    private long userId;
    private String userQq;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_qq")
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
        UserQq userQq1 = (UserQq) o;
        return userId == userQq1.userId && Objects.equals(userQq, userQq1.userQq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userQq);
    }
}
