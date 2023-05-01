package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Achievement;
import com.college.collegeportfoliobackend.entity.Faculty;
import com.college.collegeportfoliobackend.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public Achievement createAchievement(Achievement achievement){
         return achievementRepository.save(achievement);
    }

    public List<Achievement> getAllAchievements(){
        return achievementRepository.findAll();
    }

    public Achievement getSingleAchievement(Integer achievementId){
        return achievementRepository.findById(achievementId)
                .orElseThrow(()->new RuntimeException("Achievement not found"));
    }

    public Achievement updateAchievement(Integer achievementId , Achievement achievement){
        Achievement existingAchievement = achievementRepository.findById(achievementId)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
        existingAchievement.setStudentName(achievement.getStudentName());
        existingAchievement.setAchievement(achievement.getAchievement());
        existingAchievement.setYear(achievement.getYear());
        return achievementRepository.save(existingAchievement);
    }

    public void deleteAchievement(Integer achievementId){
        Achievement achievement = achievementRepository.findById(achievementId)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
        achievementRepository.delete(achievement);
    }

    public void uploadPhoto(Integer achievementId , MultipartFile file) throws IOException {
        Achievement achievement = achievementRepository.findById(achievementId)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
        achievement.setPhoto(file.getBytes());
    }
}
