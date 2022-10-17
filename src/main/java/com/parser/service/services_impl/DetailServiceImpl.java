package com.parser.service.services_impl;


import com.parser.service.services.DetailService;
import com.parser.service.repositories.DetailRepository;
import com.parser.service.entity.Detail;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.aspectj.weaver.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository repository;

    @Override
    public List<Detail> getAllDetails() {
        return repository.findAll();
    }

    @Override
    public void saveOrUpdateDetail(Detail detail) {
        repository.save(detail);
    }

    @Override
    public Optional<Detail> getDetail(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteDetail(int id) {
        repository.deleteById(id);
    }

    @Override
    public Detail getDetailByArticle(int article) {
        return repository.findByArticle(article);
    }

    @Override
    @Transactional
    public HttpStatus parseAndSaveArticle() {
        File file = new File("D:\\1\\articles.xls");
        try (HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file))) {
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
                List<Integer> integerList = new ArrayList<>();
                List<String> stringList = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    HSSFCell cell = (HSSFCell) cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            double a = cell.getNumericCellValue();
                            int b = (int) a;
                            integerList.add(b);
                            break;
                        case STRING:
                            stringList.add(cell.getStringCellValue());
                        default:
                            break;
                    }
                }
                Detail detail = new Detail();
                detail.setArticle(integerList.get(0));
                detail.setGtin(stringList.get(0));
                detail.setTnved(stringList.get(1));
                detail.setProductName(stringList.get(2));
                if (repository.findByArticle(detail.getArticle()) == null) {
                    repository.save(detail);
                }




            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return HttpStatus.OK;
    }
}
