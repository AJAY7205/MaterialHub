package com.First.FirstStep.controller;

import com.First.FirstStep.Model.Files;
import com.First.FirstStep.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/files")
    public ResponseEntity<List<Files>> getAllFiles(){
        List<Files> getFiles = fileService.getAllFiles();
        return new ResponseEntity<>(getFiles,HttpStatus.OK);
    }

    @GetMapping("/{courseId}/files")
    public ResponseEntity<List<Files>> getFilesByCourse(@PathVariable Long courseId){
        List<Files> files = fileService.getFilesbyCourse(courseId);
        return new ResponseEntity<>(files,HttpStatus.OK);
    }

    @GetMapping("/files/{keyword}")
    public ResponseEntity<List<Files>> getFilesByKeyword(@PathVariable String keyword){
        List<Files> files = fileService.getFilesByKeyword(keyword);
        return new ResponseEntity<>(files,HttpStatus.OK);
    }

    @PostMapping("/files/{courseId}")
    public ResponseEntity<Files> createFiles(@RequestParam("files") MultipartFile file,@PathVariable Long courseId) throws IOException {
        Files createdFile = fileService.createFile(file,courseId);
        return new ResponseEntity<>(createdFile, HttpStatus.CREATED);
    }


}
