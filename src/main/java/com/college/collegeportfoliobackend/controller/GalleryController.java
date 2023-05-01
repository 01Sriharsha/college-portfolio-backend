package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Gallery;
import com.college.collegeportfoliobackend.service.GalleryService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @PostMapping("/gallery")
    public ResponseEntity<?> createGallery(@RequestBody Gallery gallery) {
        return new ResponseEntity<>(galleryService.createGallery(gallery), HttpStatus.CREATED);
    }

    @GetMapping("/gallery")
    public ResponseEntity<?> getAllGallerys() {
        return new ResponseEntity<>(galleryService.getAllGallerys(), HttpStatus.OK);
    }

    @GetMapping("/gallery/{galleryId}")
    public ResponseEntity<?> getSingleGallery(@PathVariable Integer galleryId) {
        return new ResponseEntity<>(galleryService.getSingleGallery(galleryId), HttpStatus.OK);
    }

    @PutMapping("/gallery/{galleryId}")
    public ResponseEntity<?> updateGallery(@PathVariable Integer galleryId, @RequestBody Gallery gallery) {
        return new ResponseEntity<>(galleryService.updateGallery(galleryId, gallery), HttpStatus.CREATED);
    }

    @DeleteMapping("/gallery/{galleryId}")
    public ResponseEntity<?> deleteGallery(@PathVariable Integer galleryId) {
        galleryService.deleteGallery(galleryId);
        return new ResponseEntity<>("Gallery removed successfully!!", HttpStatus.OK);
    }

    @PostMapping("/gallery/{galleryId}/upload")
    public ResponseEntity<?> uploadPhoto(@PathVariable Integer galleryId, @RequestParam("image") MultipartFile image) throws IOException {
        galleryService.uploadPhoto(galleryId, image);
        return new ResponseEntity<>("Photo Uploaded successfully", HttpStatus.OK);
    }

    @GetMapping("/gallery/{galleryId}/download")
    public ResponseEntity<?> downloadPhoto(@PathVariable Integer galleryId, HttpServletResponse response) throws IOException {
        Gallery gallery = galleryService.getSingleGallery(galleryId);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(gallery.getImage());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
