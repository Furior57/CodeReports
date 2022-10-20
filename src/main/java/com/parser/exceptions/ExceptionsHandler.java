package com.parser.exceptions;

import org.slf4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionsHandler {
    public static void fileExceptionHandler(File file, Exception e, Logger logger) throws Exception {
        if (e.getClass() == FileNotFoundException.class && e.getMessage().contains("Отказано в доступе")) {
            logger.error("Отказано в доступе к файлу.");
            throw new AccessDeniedException("Доступ к файлу \"" +file.getAbsoluteFile()+ "\" запрещен.");
        }
        if (e.getClass() == FileNotFoundException.class && e.getMessage().contains("Не удается найти указанный файл")) {
            logger.error("Файл \"" + file.getAbsoluteFile() + "\" не найден.");
            throw new NotFoundFileException("Файл \"" + file.getAbsoluteFile() + "\" не найден.");
        }else
            e.printStackTrace();
    }
}
