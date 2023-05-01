package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Gallery;
import com.college.collegeportfoliobackend.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public Gallery createGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public List<Gallery> getAllGallerys() {
        return galleryRepository.findAll();
    }

    public Gallery getSingleGallery(Integer galleryId) {
        return galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));
    }

    public Gallery updateGallery(Integer galleryId, Gallery gallery) {
        Gallery existingGallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));
        existingGallery.setDescription(gallery.getDescription());
        return galleryRepository.save(existingGallery);
    }

    public void deleteGallery(Integer galleryId) {
        Gallery gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));
        galleryRepository.delete(gallery);
    }

    public void uploadPhoto(Integer galleryId, MultipartFile file) throws IOException {
        Gallery gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));
        gallery.setImage(file.getBytes());
        galleryRepository.save(gallery);
    }
}
