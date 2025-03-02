package com.First.FirstStep.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    @Column(name = "fileName")
    private String fileName;

    @NotBlank
    @Column(name = "fileUrl")
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "fileType")
    private FileType fileType;



    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courses;

    @ManyToOne
    @JoinColumn(name="uploadedBy")
    private Brothers uploadedBy;

}
