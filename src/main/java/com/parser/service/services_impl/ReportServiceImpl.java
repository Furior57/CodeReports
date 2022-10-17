package com.parser.service.services_impl;

import com.parser.service.services.ReportService;
import com.parser.service.entity.Report;
import com.parser.service.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository repository;

    @Override
    public List<Report> getAllReports() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdateReport(Report report) {
        repository.save(report);
    }

    @Override
    public Optional<Report> getReport(long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteReport(long id) {
        repository.deleteById(id);
    }

    @Override
    public void parseAndSaveReports() {

    }

    @Override
    public List<Report> getReportsByArticle(int article) {
        return repository.findAllByArticle(article);
    }

    @Override
    public List<Report> getReportsByDate(int date) {
        return repository.findAllByDate(date);
    }

    @Override
    public List<Report> getReportsByArticleAndDate(int article, int date) {
        return repository.findAllByArticleAndDate(article, date);
    }
}
