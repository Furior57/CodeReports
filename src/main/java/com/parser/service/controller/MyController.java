package com.parser.service.controller;

import com.parser.service.entity.Report;
import com.parser.service.services.DetailService;
import com.parser.service.services.ReportService;
import com.parser.service.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    ReportService reportService;
    @Autowired
    DetailService detailService;

    // Operation with details
    @GetMapping("/details")
    List<Detail> getAllDetails() {
        return detailService.getAllDetails();
    }

    @PostMapping("/details")
    void saveOrUpdateDetail(@RequestBody Detail detail) {
        detailService.saveOrUpdateDetail(detail);
    }

    @GetMapping("/details/id={id}")
    Optional<Detail> getDetail(@PathVariable int id) {
        return detailService.getDetail(id);
    }

    @DeleteMapping("/details/{id}")
    void deleteDetail(@PathVariable int id) {
        detailService.deleteDetail(id);
    }

    @GetMapping("/getByArticle/{article}")
    Detail getDetailByArticle(@PathVariable String article) {
        return detailService.getDetailByArticle(article);
    }

    @GetMapping("/save_article")
    void parseAndSaveArticle() throws Exception {
        detailService.parseAndSaveArticle();
    }

    // Operations with reports
    @GetMapping("/reports")
    List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping("/reports")
    void saveOrUpdateReport(@RequestBody Report report) {
        reportService.saveOrUpdateReport(report);
    }

    @GetMapping("/reports/{id}")
    Optional<Report> getReport(@PathVariable long id) {
        return reportService.getReport(id);
    }

    @DeleteMapping("/reports/{id}")
    void deleteReport(@PathVariable long id) {
        reportService.deleteReport(id);
    }

    @GetMapping("/save_reports")
    void parseAndSaveReports() {
        reportService.parseAndSaveReports();
    }

    @GetMapping("/by_article/article={article}")
    List<Report> getReportsByArticle(@PathVariable String article) {
        return reportService.getReportsByArticle(article);
    }

    @GetMapping("/by_date/date={date}")
    List<Report> getReportsByDate(@PathVariable Date date) {
        return reportService.getReportsByDate(date);
    }

    @GetMapping("/by_article_and_date/article={article}&date={date}")
    List<Report> getReportsByArticleAndDate(@PathVariable String article, @PathVariable Date date) {
        return reportService.getReportsByArticleAndDate(article, date);
    }
    @GetMapping("/between_dates/date_start={dateStart}&date_end={dateEnd}")
    List<Report> getReportsBetweenDates(@PathVariable Date dateStart, @PathVariable Date dateEnd) {
        return reportService.getReportsBetweenDates(dateStart, dateEnd);
    }
    @GetMapping("/by_article_and_between_dates/article={article}&date_start={dateStart}&date_end={dateEnd}")
    List<Report> getReportsByArticleAndBetweenDates(@PathVariable String article, @PathVariable Date dateStart, @PathVariable Date dateEnd) {
        return reportService.getReportsByArticleAndBetweenDates(article, dateStart, dateEnd);
    }


}
