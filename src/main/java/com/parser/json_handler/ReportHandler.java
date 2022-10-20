package com.parser.json_handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parser.exceptions.ExceptionsHandler;
import com.parser.service.pojo.DataMatrix;
import com.parser.service.pojo.DataMatrixObject;
import com.parser.service.repositories.DetailRepository;
import com.parser.service.repositories.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHandler {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    DetailRepository detailRepository;
    private final Logger logger = LoggerFactory.getLogger(ReportHandler.class);


    DataMatrixObject codes = null;

    public void reportHandle() throws Exception {

        List<File> folderList = new ArrayList<>();

        folderList.add(new File("D:\\1\\report"));

        for (File folder : folderList) {
            File[] fileList = folder.listFiles();
            if (fileList != null) {
                for (File file : fileList) {
                    try {
                        DataMatrixObject dataMatrixCodes = getDataMatrixCodes(file);
                        for (DataMatrix d : dataMatrixCodes.dataMatrixs) {

                        }
                    } catch (Exception e) {
                        ExceptionsHandler.fileExceptionHandler(file, e, logger);
                    }
                }
            }

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

}
