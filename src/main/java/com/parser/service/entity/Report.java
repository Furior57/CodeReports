package com.parser.service.entity;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long id;
    @Column(name = "report_name")
    String reportName;
    @Column
    int article;
    @Column
    int status1;
    @Column
    int status2;
    @Column
    int status3;
    @Column
    int status5;
    @Column
    int date;


    public Report() {
    }

    public Report(long id,String reportName, int article, int status1, int status2, int status3, int status5, int date) {
        this.id = id;
        this.reportName = reportName;
        this.article = article;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
        this.status5 = status5;
        this.date = date;
    }


    public Report(String reportName, int article, int status1, int status2, int status3, int status5, int date) {
        this.reportName = reportName;
        this.article = article;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
        this.status5 = status5;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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
