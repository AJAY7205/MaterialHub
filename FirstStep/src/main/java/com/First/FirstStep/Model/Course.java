package com.First.FirstStep.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @NotBlank
    @Size(min = 6)
    private String courseCode;

    @NotBlank
    @Size(min = 6)
    private String courseName;

    @JsonIgnore
    @OneToMany(mappedBy = "courses",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    List<Files> files= new ArrayList<>();

}
