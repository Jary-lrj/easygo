package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user_phonenumber", schema = "easygo", catalog = "")
@IdClass(UserPhonenumberPK.class)
public class UserPhonenumber {
    private long userId;
    private String userPhonenumber;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_phonenumber")
    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhonenumber that = (UserPhonenumber) o;
        return userId == that.userId && Objects.equals(userPhonenumber, that.userPhonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPhonenumber);
    }
}
