package com.First.FirstStep.service;

import com.First.FirstStep.Model.Files;
import com.First.FirstStep.payload.FileDTO;
import com.First.FirstStep.payload.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    FileDTO createFile(MultipartFile file, Long courseId) throws IOException;

    FileResponse getAllFiles();



    FileResponse getFilesByCourse(String courseName);

    List<Files> getFilesByKeyword(String keyword);
}
