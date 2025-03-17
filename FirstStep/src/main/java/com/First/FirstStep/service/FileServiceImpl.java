package com.First.FirstStep.service;


import com.First.FirstStep.Model.Course;
import com.First.FirstStep.Model.FileType;
import com.First.FirstStep.Model.Files;
import com.First.FirstStep.exception.APIException;
import com.First.FirstStep.exception.ResourceNotFoundException;
import com.First.FirstStep.payload.FileDTO;
import com.First.FirstStep.payload.FileResponse;
import com.First.FirstStep.repositories.CourseRepository;
import com.First.FirstStep.repositories.FileRepository;
import org.apache.tika.Tika;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    @Value("${pdf.path}")
    private String path;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ModelMapper modelMapper;

    Tika tika = new Tika();

    @Override
    public FileDTO createFile(MultipartFile file, Long courseId) throws IOException {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "CourseId", courseId));

            Files files = new Files();

            String originalFileName = file.getOriginalFilename();
            String mimeType = tika.detect(file.getBytes()).toLowerCase();
            FileType fileType = FileType.fromMimeType(mimeType);
            String randomId = UUID.randomUUID().toString();
            assert originalFileName != null;
            String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
            String filePath = path + File.separator + fileName;

            File folder = new File(path);

            if (!folder.exists()) {
                folder.mkdir();
            }
            java.nio.file.Files.copy(file.getInputStream(), Paths.get(filePath));

            files.setFileType(fileType);
            files.setFileName(originalFileName);
            files.setCourses(course);
            files.setFileUrl(filePath);
            files.setCreatedAt(LocalDateTime.now());
            Files savedFiles = fileRepository.save(files);
            FileDTO fileDTO = modelMapper.map(savedFiles,FileDTO.class);
            fileDTO = new FileDTO(files);
            return fileDTO;

    }

    @Override
    public FileResponse getAllFiles() {
        List<Files> files = fileRepository.findAll();
        if (files.isEmpty()) {
            throw new APIException("No files Uploaded yet");
        }

        List<FileDTO> fileDTOS = files.stream().map(file -> {
            FileDTO fileDTO = modelMapper.map(file, FileDTO.class);
            if (file.getCourses() != null) {
                fileDTO.setCourseId(file.getCourses().getCourseId());
            }

            return fileDTO;
        }).toList();

        FileResponse fileResponse = new FileResponse();
        fileResponse.setContent(fileDTOS);
        return fileResponse;
    }


    @Override
    public List<Files> getFilesbyCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course","CourseId",courseId));

        List<Files> files = fileRepository.findByCourses(course);
        if(files.isEmpty()){
            throw new APIException("No files in this Course");
        }
        return files;
    }

    @Override
    public List<Files> getFilesByKeyword(String keyword) {
        List<Files> files = fileRepository.findByFileNameLikeIgnoreCase('%' + keyword + '%');
        return files;
    }


}
