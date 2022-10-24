package com.parser.json_handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parser.exceptions.ExceptionsHandler;
import com.parser.service.entity.Report;
import com.parser.service.pojo.DataMatrix;
import com.parser.service.pojo.DataMatrixObject;
import com.parser.service.repositories.DetailRepository;
import com.parser.service.repositories.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportHandler {

    private final Logger logger = LoggerFactory.getLogger(ReportHandler.class);


    DataMatrixObject codes = null;

    public void reportHandle(ReportRepository reportRepository, DetailRepository detailRepository) throws Exception {


        List<File> folderList = new ArrayList<>();

        folderList.add(new File("D:\\1\\report"));
        logger.info("Начато обновление базы данных.");
        for (File folder : folderList) {
            File[] fileList = folder.listFiles();
            if (fileList != null) {
                for (File file : fileList) {
                    String fileName = file.getName().split("\\\\")[file.getName().split("\\\\").length - 1];
                    if (reportRepository.findByFullReportName(fileName).size() != 0) {
                        System.out.println(fileName + " уже был");
                        continue;
                    }
                    System.out.println("Обрабатываем " + file.getName() + "\r");
                    try {
                        DateFormat df = new SimpleDateFormat("yyMMddhhmm");
                        DataMatrixObject dataMatrixCodes = getDataMatrixCodes(file);
                        String gtin = null;
                        Report report = new Report();
                        int status1 = 0;
                        int status2 = 0;
                        int status3 = 0;
                        int status5 = 0;
                        for (DataMatrix d : dataMatrixCodes.getDataMatrixs()) {
                            if (gtin == null) {
                                gtin = d.getCode().substring(2, 16);
                            }
                            switch (d.getStatus()) {
                                case 1:
                                    status1++;
                                    break;
                                case 2:
                                    status2++;
                                    break;
                                case 3:
                                    status3++;
                                    if (report.getDate() == null && !d.getDateProduction().equals("")) {
                                        report.setDate(df.parse(d.getDateProduction() + "" + "2350"));
                                    } else {
                                        String s = file.getName().split("_")[0];
                                        report.setDate(df.parse("" + s.substring(6) + s.substring(4, 6) +
                                                s.substring(2, 4) + "" + "2350"));
                                    }
                                    break;
                                case 5:
                                    status5++;
                                    break;
                                default:
                                    break;

                            }
                        }

                        String[] str = fileName.split("_");
                        StringBuilder reportName = new StringBuilder();
                        for (String s : str) {
                            if (!isNumeric(s)) {
                                reportName.append(s).append(" ");
                            }
                        }
                        report.setReportName(String.valueOf(reportName));
                        report.setArticle(detailRepository.findByGtin(gtin).getArticle());
                        report.setStatus1(status1);
                        report.setStatus2(status2);
                        report.setStatus3(status3);
                        report.setStatus5(status5);
                        report.setFullReportName(file.getName());
                        reportRepository.save(report);
                    } catch (Exception e) {
                        if (e.getClass() == FileNotFoundException.class) {
                            ExceptionsHandler.fileExceptionHandler(file, e, logger);
                        } else logger.error("Неизвестная ошибка.\n");
                        e.printStackTrace();

                    }


                }
            } else logger.error("Не найдено ни одного отчета в заданной директории. Возможно у вас нет прав доступа.");
            logger.info("Обновление базы данных завершено.");
        }


    }

    private DataMatrixObject getDataMatrixCodes(File file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            codes = mapper.readValue(file, DataMatrixObject.class);
            for (DataMatrix d : codes.dataMatrixs) {
                d.setReportName(file.getName());
            }
        } catch (Exception e) {
            ExceptionsHandler.fileExceptionHandler(file, e, logger);
        }

        return codes;
    }

    private static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
