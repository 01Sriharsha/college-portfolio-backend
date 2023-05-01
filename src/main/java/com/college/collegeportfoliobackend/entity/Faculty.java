package com.college.collegeportfoliobackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    private String id;

    private String name;

    private String type;

    private String qualification;

    private String designation;

    private String joinedDate;

    @Lob
    @JsonIgnore
    private byte[] photo;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    private List<Course> courses;
}
