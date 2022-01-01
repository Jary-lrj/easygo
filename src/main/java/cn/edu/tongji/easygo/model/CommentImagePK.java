package cn.edu.tongji.easygo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommentImagePK implements Serializable {
    private long commentId;
    private String commentImage;

    @Column(name = "comment_id")
    @Id
    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    @Column(name = "comment_image")
    @Id
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
        CommentImagePK that = (CommentImagePK) o;
        return commentId == that.commentId && Objects.equals(commentImage, that.commentImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentImage);
    }
}
