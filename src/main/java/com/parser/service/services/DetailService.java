package com.parser.service.services;

import com.parser.service.entity.Detail;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface DetailService {
    List<Detail> getAllDetails();

    void saveOrUpdateDetail(Detail detail);

    Optional<Detail> getDetail(int id);

    void deleteDetail(int id);

    Detail getDetailByArticle(int article);

    HttpStatus parseAndSaveArticle();


}
