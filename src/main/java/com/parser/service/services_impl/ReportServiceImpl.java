package com.parser.service.services_impl;

import com.parser.json_handler.ReportHandler;
import com.parser.service.repositories.DetailRepository;
import com.parser.service.services.ReportService;
import com.parser.service.entity.Report;
import com.parser.service.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    DetailRepository detailRepository;

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public void saveOrUpdateReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public Optional<Report> getReport(long id) {
        return reportRepository.findById(id);
    }

    @Override
    public void deleteReport(long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public void parseAndSaveReports() {
        ReportHandler handler = new ReportHandler();
        try {
            handler.reportHandle(reportRepository, detailRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Report> getReportsByArticle(String article) {
        return reportRepository.findAllByArticle(article);
    }

    @Override
    public List<Report> getReportsByDate(Date date) {
        return reportRepository.findAllByDate(date);
    }

    @Override
    public List<Report> getReportsByArticleAndDate(String article, Date date) {
        return reportRepository.findAllByArticleAndDate(article, date);
    }

    @Override
    public List<Report> getReportsBetweenDates(Date startDate, Date endDate) {
        return reportRepository.findAllByDateBetween(startDate, endDate);
    }

    @Override
    public List<Report> getReportsByArticleAndBetweenDates(String article, Date startDate, Date endDate) {
        return getReportsByArticleAndBetweenDates(article, startDate, endDate);
    }
}
