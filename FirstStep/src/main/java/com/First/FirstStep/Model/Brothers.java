package com.First.FirstStep.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "BTD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brothers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brotherId;

    @NotBlank
    @Column(name = "brotherMail")
    private String brotherMail;

    @OneToMany(mappedBy = "uploadedBy",cascade = CascadeType.ALL)
    List<Files> files = new ArrayList<>();

}
