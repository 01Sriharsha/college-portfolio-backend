package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Query;
import com.college.collegeportfoliobackend.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/query")
    public ResponseEntity<?> createQuery(@RequestBody Query query) {
        return new ResponseEntity<>(queryService.createQuery(query), HttpStatus.CREATED);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getAllQuerys() {
        return new ResponseEntity<>(queryService.getAllQuerys(), HttpStatus.OK);
    }

    @GetMapping("/query/{queryId}")
    public ResponseEntity<?> getSingleQuery(@PathVariable Integer queryId) {
        return new ResponseEntity<>(queryService.getSingleQuery(queryId), HttpStatus.OK);
    }

    @PutMapping("/query/{queryId}")
    public ResponseEntity<?> updateQuery(@PathVariable Integer queryId, @RequestBody Query query) {
        return new ResponseEntity<>(queryService.updateQuery(query, queryId), HttpStatus.CREATED);
    }

    @DeleteMapping("/query/{queryId}")
    public ResponseEntity<?> deleteQuery(@PathVariable Integer queryId) {
        queryService.deleteQuery(queryId);
        return new ResponseEntity<>("Query removed successfully!!", HttpStatus.OK);
    }
}
