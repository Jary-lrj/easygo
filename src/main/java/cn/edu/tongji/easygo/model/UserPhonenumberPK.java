package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserPhonenumberPK implements Serializable {
    private long userId;
    private String userPhonenumber;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "user_phonenumber")
    @Id
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
        UserPhonenumberPK that = (UserPhonenumberPK) o;
        return userId == that.userId && Objects.equals(userPhonenumber, that.userPhonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPhonenumber);
    }
}
