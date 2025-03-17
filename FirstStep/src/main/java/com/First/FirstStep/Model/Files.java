package com.First.FirstStep.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID fileId;

    @NotBlank
    @Column(name = "fileName",nullable = false)
    private String fileName;

    @NotBlank
    @Lob
    @Column(name = "fileUrl", nullable = false)
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "fileType",nullable = false)
    private FileType fileType;



    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course courses;

    @ManyToOne
    @JoinColumn(name="uploadedBy")
    private Brothers uploadedBy;

    @Column(name = "created_at" , nullable = false,updatable = false)
    private LocalDateTime createdAt;

}
