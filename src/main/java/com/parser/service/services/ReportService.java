package com.parser.service.services;

import com.parser.service.entity.Report;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportService {
    List<Report> getAllReports();

    void saveOrUpdateReport(Report report);

    Optional<Report> getReport(long id);

    void deleteReport(long id);

    void parseAndSaveReports();

    List<Report> getReportsByArticle(String article);

    List<Report> getReportsByDate(Date date);

    List<Report> getReportsByArticleAndDate(String article, Date date);

    List<Report> getReportsBetweenDates(Date startDate, Date endDate);

    List<Report> getReportsByArticleAndBetweenDates(String article, Date startDate, Date endDate);
}
