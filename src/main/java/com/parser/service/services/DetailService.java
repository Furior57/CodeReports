package com.parser.service.services;


import com.parser.service.entity.Detail;
import java.util.List;
import java.util.Optional;

public interface DetailService {
    List<Detail> getAllDetails();

    void saveOrUpdateDetail(Detail detail);

    Optional<Detail> getDetail(int id);

    void deleteDetail(int id);

    Detail getDetailByArticle(String article);

    void parseAndSaveArticle() throws Exception;


}
