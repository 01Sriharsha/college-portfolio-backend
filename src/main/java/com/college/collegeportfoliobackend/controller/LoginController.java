package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.dto.LoginDto;
import com.college.collegeportfoliobackend.entity.Admin;
import com.college.collegeportfoliobackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
          if(loginDto.getUserType().equals("admin")){
              Admin admin = adminRepository.findById(Integer.parseInt(loginDto.getUserId()))
                      .orElseThrow(() -> new RuntimeException("User not found"));
              if(!admin.getPassword().equals(loginDto.getPassword())){
                  throw new RuntimeException("Invalid password");
              }
              return new ResponseEntity<>("admin" , HttpStatus.OK);
          }
          else{
              throw new RuntimeException("Select valid user type");
          }
    }
}
