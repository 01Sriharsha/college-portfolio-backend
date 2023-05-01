package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Query;
import com.college.collegeportfoliobackend.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public Query createQuery(Query query){
        return queryRepository.save(query);
    }

    public List<Query> getAllQuerys(){
        return queryRepository.findAll();
    }

    public Query getSingleQuery(Integer queryId){
        return queryRepository.findById(queryId)
                .orElseThrow(()->new RuntimeException("Query not found"));
    }

    public Query updateQuery(Query query , Integer queryId){
        Query existingQuery = queryRepository.findById(queryId)
                .orElseThrow(() -> new RuntimeException("Query not found"));
        existingQuery.setReply(query.getReply());
        return queryRepository.save(existingQuery);
    }

    public void deleteQuery(Integer queryId){
        Query query = queryRepository.findById(queryId)
                .orElseThrow(() -> new RuntimeException("Query not found"));
        queryRepository.delete(query);
    }
}
