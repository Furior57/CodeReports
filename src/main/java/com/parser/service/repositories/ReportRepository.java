package com.parser.service.repositories;

import com.parser.service.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    List<Report> findAllByArticle(int article);

    List<Report> findAllByDate(Date date);

    List<Report> findAllByArticleAndDate(int article, Date date);

    List<Report> findAllByDateBetween(Date startDate, Date endDate);

    List<Report> findAllByArticleAndDateBetween(int article, Date startDate, Date endDate);
}
