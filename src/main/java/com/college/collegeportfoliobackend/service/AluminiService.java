package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Alumini;
import com.college.collegeportfoliobackend.repository.AluminiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AluminiService {

    @Autowired
    private AluminiRepository aluminiRepository;

    public Alumini createAlumini(Alumini alumini){
        return aluminiRepository.save(alumini);
    }

    public List<Alumini> getAllAluminis(){
        return aluminiRepository.findAll();
    }

    public Alumini getSingleAlumini(Integer aluminiId){
        return aluminiRepository.findById(aluminiId)
                .orElseThrow(()->new RuntimeException("Alumini not found"));
    }

    public Alumini updateAlumini(Alumini alumini , Integer aluminiId){
        Alumini existingAlumini = aluminiRepository.findById(aluminiId)
                .orElseThrow(() -> new RuntimeException("Alumini not found"));
        existingAlumini.setStudentName(alumini.getStudentName());
        existingAlumini.setBranch(alumini.getBranch());
        return aluminiRepository.save(existingAlumini);
    }

    public void deleteAlumini(Integer aluminiId){
        Alumini alumini = aluminiRepository.findById(aluminiId)
                .orElseThrow(() -> new RuntimeException("Alumini not found"));
        aluminiRepository.delete(alumini);
    }

    public void uploadPhoto(Integer aluminiId , MultipartFile file) throws IOException {
        Alumini faculty = aluminiRepository.findById(aluminiId)
                .orElseThrow(() -> new RuntimeException("Alumini not found"));
        faculty.setPhoto(file.getBytes());
    }
}
