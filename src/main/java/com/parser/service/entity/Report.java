package com.parser.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;
    @Column(name = "report_name")
    String reportName;
    @Column
    String article;
    @Column(name = "status_1")
    int status1;
    @Column(name = "status_2")
    int status2;
    @Column(name = "status_3")
    int status3;
    @Column(name = "status_5")
    int status5;
    @Column
    Date date;
    @Column(name = "full_name")
    String fullReportName;


    public Report() {
    }

    public Report(int id, String reportName, String article, int status1,
                  int status2, int status3, int status5, Date date, String fullReportName) {
        this.id = id;
        this.reportName = reportName;
        this.article = article;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
        this.status5 = status5;
        this.date = date;
        this.fullReportName = fullReportName;
    }


    public Report(String reportName, String article, int status1, int status2, int status3, int status5, Date date) {
        this.reportName = reportName;
        this.article = article;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
        this.status5 = status5;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getStatus1() {
        return status1;
    }

    public void setStatus1(int status1) {
        this.status1 = status1;
    }

    public int getStatus2() {
        return status2;
    }

    public void setStatus2(int status2) {
        this.status2 = status2;
    }

    public int getStatus3() {
        return status3;
    }

    public void setStatus3(int status3) {
        this.status3 = status3;
    }

    public int getStatus5() {
        return status5;
    }

    public void setStatus5(int status5) {
        this.status5 = status5;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFullReportName() {
        return fullReportName;
    }

    public void setFullReportName(String fullReportName) {
        this.fullReportName = fullReportName;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportName='" + reportName + '\'' +
                ", article=" + article +
                ", status1=" + status1 +
                ", status2=" + status2 +
                ", status3=" + status3 +
                ", status5=" + status5 +
                ", date=" + date +
                '}';
    }
}
