package com.First.FirstStep.service;

import com.First.FirstStep.Model.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    Files createFile(MultipartFile file, Long courseId) throws IOException;

    List<Files> getAllFiles();

    List<Files> getFilesbyCourse(Long courseId);

    List<Files> getFilesByKeyword(String keyword);
}
