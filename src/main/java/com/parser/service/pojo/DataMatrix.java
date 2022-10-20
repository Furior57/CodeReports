package com.parser.service.pojo;


public class DataMatrix {

    String code;

    String dateProduction;

    String dateTimeEnd;

    int status;

    String reportName;

    public DataMatrix() {
    }

    public DataMatrix(String code, String dateProduction, String dateTimeEnd, int status) {
        this.code = code;
        this.dateProduction = dateProduction;
        this.dateTimeEnd = dateTimeEnd;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String toString() {
        return "DataMatrix{" +
                "code='" + code + '\'' +
                ", dateProduction=" + dateProduction +
                ", dateTimeEnd=" + dateTimeEnd +
                ", status=" + status +
                ", reportName='" + reportName + '\'' +
                '}';
    }
}
