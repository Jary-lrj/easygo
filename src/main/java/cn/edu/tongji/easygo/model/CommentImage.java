package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "comment_image", schema = "easygo", catalog = "")
@IdClass(CommentImagePK.class)
public class CommentImage {
    private long commentId;
    private String commentImage;

    @Id
    @Column(name = "comment_id")
    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    @Id
    @Column(name = "comment_image")
    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentImage that = (CommentImage) o;
        return commentId == that.commentId && Objects.equals(commentImage, that.commentImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentImage);
    }
}
