package com.pet.sitter.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PetsitterFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileNo;

    @Column
    @NotNull
    private String originFileName;

    @Column
    @NotNull
    private String newFileName;

    @Column
    @NotNull
    private String filePath;

    @Column
    @NotNull
    private String type;

    private Integer fileSize;

    @ManyToOne
    @JoinColumn(name = "sitterNo", referencedColumnName = "sitterNo")
    private Petsitter petsitter;

    @Builder
    public PetsitterFile(Long fileNo, String originFileName, String newFileName, String filePath, String type, Petsitter petsitter, Integer fileSize) {
        this.fileNo = fileNo;
        this.originFileName = originFileName;
        this.newFileName = newFileName;
        this.filePath = filePath;
        this.type = type;
        this.petsitter = petsitter;
        this.fileSize = fileSize;
    }
}