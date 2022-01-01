package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user_email", schema = "easygo", catalog = "")
@IdClass(UserEmailPK.class)
public class UserEmail {
    private long userId;
    private String userEmail;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail userEmail1 = (UserEmail) o;
        return userId == userEmail1.userId && Objects.equals(userEmail, userEmail1.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail);
    }
}
