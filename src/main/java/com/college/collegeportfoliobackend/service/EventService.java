package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Event;
import com.college.collegeportfoliobackend.entity.EventImage;
import com.college.collegeportfoliobackend.repository.EventImageRepository;
import com.college.collegeportfoliobackend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventImageRepository eventImageRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getSingleEvent(Integer eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event updateEvent(Integer eventId, Event event) {
        Event existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setEventName(event.getEventName());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDate(event.getDate());
        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Integer eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
    }

    public void uploadPhoto(Integer eventId, MultipartFile[] file) throws IOException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        Arrays.stream(file).forEach(image -> {
                    try {
                        EventImage eventImage = new EventImage();
                        eventImage.setImage(image.getBytes());
                        eventImage.setEvent(event);
                        eventImageRepository.save(eventImage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    public List<EventImage> downloadImagesByEventId(Integer eventId){
        return eventImageRepository.findByEventId(eventId);
    }

    public byte[] downloadImage(Integer imageId) {
        EventImage eventImage = eventImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return eventImage.getImage();
    }
}
