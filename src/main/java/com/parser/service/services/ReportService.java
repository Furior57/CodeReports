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

    List<Report> getReportsByArticle(int article);

    List<Report> getReportsByDate(Date date);

    List<Report> getReportsByArticleAndDate(int article, Date date);

    List<Report> getReportsBetweenDates(Date startDate, Date endDate);

    List<Report> getReportsByArticleAndBetweenDates(int article, Date startDate, Date endDate);
}
