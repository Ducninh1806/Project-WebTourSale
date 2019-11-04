package com.ducninh.controller;


import com.ducninh.model.UserTourGuide;
import com.ducninh.service.UserTourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTourGuideController {

    @Autowired
    private UserTourGuideService userTourGuideService;

    @GetMapping("/userTourGuide")
    public ResponseEntity<List<UserTourGuide>> findAllUserTourGuide(){
       List<UserTourGuide>  userTourGuide =(List<UserTourGuide>) userTourGuideService.findAll();
       if (userTourGuide.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
            return new ResponseEntity<>(userTourGuide, HttpStatus.OK);
    }

    @GetMapping("/userTourGuide/{id}")
    public ResponseEntity<UserTourGuide> findByIdUserTourGuide(@PathVariable("id")Long id){
        UserTourGuide userTourGuide = userTourGuideService.findById(id);
        if (userTourGuide == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(userTourGuide, HttpStatus.OK);
    }

    @PostMapping("/userTourGuide")
    public ResponseEntity<UserTourGuide> createUserTourGuide(@RequestBody UserTourGuide userTourGuide){
        userTourGuideService.save(userTourGuide);
        return new ResponseEntity<>(userTourGuide, HttpStatus.OK);
    }

    @PutMapping("/userTourGuide/{id}")
    public ResponseEntity<UserTourGuide> updateUserTourGuide(@PathVariable("id")Long id,@RequestBody UserTourGuide userTourGuide){
        UserTourGuide currentUserTourGuide = userTourGuideService.findById(id);
        if (currentUserTourGuide == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUserTourGuide.setFirstName(userTourGuide.getFirstName());
        currentUserTourGuide.setLastName(userTourGuide.getLastName());
        currentUserTourGuide.setAccount(userTourGuide.getAccount());
        currentUserTourGuide.setPassword(userTourGuide.getPassword());
        currentUserTourGuide.setEmail(userTourGuide.getEmail());
        currentUserTourGuide.setAddress(userTourGuide.getAddress());
        userTourGuideService.save(currentUserTourGuide);
        return new ResponseEntity<>(currentUserTourGuide, HttpStatus.OK);
    }

    @DeleteMapping("/userTourGuide/{id}")
    public ResponseEntity<UserTourGuide> deleteUserTourGuide(@PathVariable Long id){
        UserTourGuide userTourGuide = userTourGuideService.findById(id);
        if (userTourGuide == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            userTourGuideService.remove(id);
            return new ResponseEntity<>(userTourGuide, HttpStatus.NO_CONTENT);
    }




}
