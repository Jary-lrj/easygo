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
public class Report {
    private long reportId;
    private long reportUserId;
    private long reportInformationId;
    private String reportType;
    private String reportReason;
    private boolean reportStatus;
    private Timestamp reportTime;
    private Boolean reportResult;

    @Id
    @Column(name = "report_id")
    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "report_user_id")
    public long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(long reportUserId) {
        this.reportUserId = reportUserId;
    }

    @Basic
    @Column(name = "report_information_id")
    public long getReportInformationId() {
        return reportInformationId;
    }

    public void setReportInformationId(long reportInformationId) {
        this.reportInformationId = reportInformationId;
    }

    @Basic
    @Column(name = "report_type")
    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Basic
    @Column(name = "report_reason")
    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    @Basic
    @Column(name = "report_status")
    public boolean isReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Basic
    @Column(name = "report_time")
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "report_result")
    public Boolean getReportResult() {
        return reportResult;
    }

    public void setReportResult(Boolean reportResult) {
        this.reportResult = reportResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return reportId == report.reportId && reportUserId == report.reportUserId && reportInformationId == report.reportInformationId && reportStatus == report.reportStatus && Objects.equals(reportType, report.reportType) && Objects.equals(reportReason, report.reportReason) && Objects.equals(reportTime, report.reportTime) && Objects.equals(reportResult, report.reportResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reportUserId, reportInformationId, reportType, reportReason, reportStatus, reportTime, reportResult);
    }
}