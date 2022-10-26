package com.parser.service.scheduledTasks;

import com.parser.json_handler.ReportHandler;
import com.parser.service.repositories.DetailRepository;
import com.parser.service.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTasks {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    DetailRepository detailRepository;

    @Scheduled(cron = "0 0 23 * * *")
    private void scheduledParsing() {
        ReportHandler handler = new ReportHandler();
        try {
            handler.reportHandle(reportRepository, detailRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
