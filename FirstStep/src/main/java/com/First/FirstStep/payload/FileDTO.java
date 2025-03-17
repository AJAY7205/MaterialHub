package com.First.FirstStep.payload;

import com.First.FirstStep.Model.FileType;
import com.First.FirstStep.Model.Files;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    //private final LocalDateTime createdAt;
    private UUID fileId;
    private String fileName;
    private String fileUrl;
    private String fileType;
    private Long courseId;
    private UUID uploadedBy;
    private  LocalDateTime createdAt;

    public FileDTO(Files file) {
        this.fileId = file.getFileId();
        this.fileName = file.getFileName();
        this.fileUrl = file.getFileUrl();
        this.fileType = file.getFileType().name();
        this.courseId = (file.getCourses() != null) ? file.getCourses().getCourseId() : null;
        //this.uploadedBy = (file.getUploadedBy() != null) ? file.getUploadedBy().getUserId() : null;
        this.createdAt = file.getCreatedAt();
    }
}
