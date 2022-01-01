package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
public class Complain {
    private long complainId;
    private long complainCommentId;
    private boolean complainStatus;
    private Timestamp complainTime;
    private String complainContent;
    private boolean complainResult;

    @Id
    @Column(name = "complain_id")
    public long getComplainId() {
        return complainId;
    }

    public void setComplainId(long complainId) {
        this.complainId = complainId;
    }

    @Basic
    @Column(name = "complain_comment_id")
    public long getComplainCommentId() {
        return complainCommentId;
    }

    public void setComplainCommentId(long complainCommentId) {
        this.complainCommentId = complainCommentId;
    }

    @Basic
    @Column(name = "complain_status")
    public boolean isComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(boolean complainStatus) {
        this.complainStatus = complainStatus;
    }

    @Basic
    @Column(name = "complain_time")
    public Timestamp getComplainTime() {
        return complainTime;
    }

    public void setComplainTime(Timestamp complainTime) {
        this.complainTime = complainTime;
    }

    @Basic
    @Column(name = "complain_content")
    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent;
    }

    @Basic
    @Column(name = "complain_result")
    public boolean isComplainResult() {
        return complainResult;
    }

    public void setComplainResult(boolean complainResult) {
        this.complainResult = complainResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complain complain = (Complain) o;
        return complainId == complain.complainId && complainCommentId == complain.complainCommentId && complainStatus == complain.complainStatus && complainResult == complain.complainResult && Objects.equals(complainTime, complain.complainTime) && Objects.equals(complainContent, complain.complainContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complainId, complainCommentId, complainStatus, complainTime, complainContent, complainResult);
    }
}
